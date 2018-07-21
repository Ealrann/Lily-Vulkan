package org.sheepy.vulkan.imgui;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferImageCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkSamplerCreateInfo;
import org.sheepy.vulkan.buffer.Buffer;
import org.sheepy.vulkan.buffer.Image;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.SingleTimeCommand;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.view.ImageView;

import glm_.vec2.Vec2i;
import imgui.IO;
import imgui.ImGui;
import kotlin.Triple;

public class ImGuiFontTexture implements IAllocable
{
	private LogicalDevice logicalDevice;
	private CommandPool commandPool;

	private long sampler;
	private Image image;
	private ImageView imageView;

	public ImGuiFontTexture(LogicalDevice logicalDevice, CommandPool commandPool)
	{
		this.logicalDevice = logicalDevice;
		this.commandPool = commandPool;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		long[] lArray = new long[1];
		// Create font texture
		IO io = ImGui.INSTANCE.getIo();
		Triple<ByteBuffer, Vec2i, Integer> texData = io.getFonts().getTexDataAsRGBA32();
		ByteBuffer fontData = texData.component1();
		int texWidth = texData.component2().getX();
		int texHeight = texData.component2().getY();

		int uploadSize = texWidth * texHeight * 4;

		image = new Image(logicalDevice);
		image.createImage(texWidth, texHeight, 1, VK_FORMAT_R8G8B8A8_UNORM, VK_IMAGE_TILING_OPTIMAL,
				VK_IMAGE_USAGE_SAMPLED_BIT | VK_IMAGE_USAGE_TRANSFER_DST_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		imageView = new ImageView(logicalDevice);
		imageView.load(image.getId(), 1, VK_FORMAT_R8G8B8A8_UNORM, VK_IMAGE_ASPECT_COLOR_BIT);

		// Staging buffers for font data upload
		Buffer stagingBuffer = new Buffer(logicalDevice, uploadSize,
				VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);
		stagingBuffer.allocate();
		stagingBuffer.fillWithBuffer(fontData);

		SingleTimeCommand stc = new SingleTimeCommand(commandPool,
				logicalDevice.getQueueManager().getGraphicQueue())
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				image.transitionImageLayout(commandBuffer, VK_PIPELINE_STAGE_HOST_BIT,
						VK_PIPELINE_STAGE_TRANSFER_BIT, VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL,
						VK_ACCESS_TRANSFER_WRITE_BIT);

				// Copy
				VkBufferImageCopy.Buffer bufferCopyRegion = VkBufferImageCopy.callocStack(1, stack);
				bufferCopyRegion.imageSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
				bufferCopyRegion.imageSubresource().layerCount(1);
				bufferCopyRegion.imageExtent().width(texWidth);
				bufferCopyRegion.imageExtent().height(texHeight);
				bufferCopyRegion.imageExtent().depth(1);

				vkCmdCopyBufferToImage(commandBuffer, stagingBuffer.getId(), image.getId(),
						VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, bufferCopyRegion);

				image.transitionImageLayout(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT,
						VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT,
						VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL,
						VK_ACCESS_INPUT_ATTACHMENT_READ_BIT);
			}
		};
		stc.execute();

		// Font texture Sampler
		VkSamplerCreateInfo samplerInfo = VkSamplerCreateInfo.callocStack(stack);
		samplerInfo.sType(VK_STRUCTURE_TYPE_SAMPLER_CREATE_INFO);
		samplerInfo.magFilter(VK_FILTER_LINEAR);
		samplerInfo.minFilter(VK_FILTER_LINEAR);
		samplerInfo.mipmapMode(VK_SAMPLER_MIPMAP_MODE_LINEAR);
		samplerInfo.addressModeU(VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE);
		samplerInfo.addressModeV(VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE);
		samplerInfo.addressModeW(VK_SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE);
		samplerInfo.borderColor(VK_BORDER_COLOR_FLOAT_OPAQUE_WHITE);
		vkCreateSampler(logicalDevice.getVkDevice(), samplerInfo, null, lArray);

		sampler = lArray[0];

		stagingBuffer.free();
	}

	@Override
	public void free()
	{
		imageView.free();
		image.free();
		vkDestroySampler(logicalDevice.getVkDevice(), sampler, null);
	}

	public ImageView getImageView()
	{
		return imageView;
	}

	public long getSampler()
	{
		return sampler;
	}
}
