package org.sheepy.vulkan.texture;

import static org.lwjgl.stb.STBImage.STBI_rgb_alpha;
import static org.lwjgl.vulkan.VK10.*;

import java.io.File;
import java.net.URL;
import java.nio.ByteBuffer;

import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkImageBlit;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.lwjgl.vulkan.VkOffset3D;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.buffer.Buffer;
import org.sheepy.vulkan.buffer.Image;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.SingleTimeCommand;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.view.ImageView;

public class Texture implements IDescriptor, IAllocable
{
	private LogicalDevice logicalDevice;
	private CommandPool commandPool;
	private String imagePath;
	private boolean generateMipMap;

	private Image imageBuffer;
	private ImageView imageView;
	private Sampler sampler;

	private int mipLevels;
	private int width;
	private int height;

	public Texture(LogicalDevice logicalDevice, CommandPool commandPool, String imagePath,
			boolean generateMipMap)
	{
		this.logicalDevice = logicalDevice;
		this.commandPool = commandPool;
		this.imagePath = imagePath;
		this.generateMipMap = generateMipMap;

		imageBuffer = new Image(logicalDevice);
		imageView = new ImageView(logicalDevice);
		sampler = new Sampler(logicalDevice, true);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		Buffer buffer = loadImageFile();

		imageBuffer.createImage(width, height, mipLevels, VK_FORMAT_R8G8B8A8_UNORM,
				VK_IMAGE_TILING_OPTIMAL,
				VK_IMAGE_USAGE_TRANSFER_SRC_BIT
						| VK_IMAGE_USAGE_TRANSFER_DST_BIT
						| VK_IMAGE_USAGE_SAMPLED_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		imageView.load(imageBuffer.getId(), mipLevels, VK_FORMAT_R8G8B8A8_UNORM,
				VK_IMAGE_ASPECT_COLOR_BIT);

		SingleTimeCommand stc = new SingleTimeCommand(commandPool,
				logicalDevice.getQueueManager().getGraphicQueue())
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				imageView.transitionImageLayout(commandBuffer, VK_IMAGE_LAYOUT_UNDEFINED,
						VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, mipLevels);

				imageBuffer.fillWithBuffer(commandBuffer, buffer);

				generateMipmaps(commandBuffer, imageBuffer.getId());
			}
		};
		stc.execute();

		sampler.load(0, mipLevels);

		buffer.free();
	}

	private Buffer loadImageFile()
	{
		URL url = Thread.currentThread().getContextClassLoader().getResource(imagePath);
		File file = new File(url.getFile());

		if (file.exists() == false)
		{
			System.err.println("Can't access the file : " + imagePath);
		}

		int[] texWidth = new int[1];
		int[] texHeight = new int[1];
		int[] texChannels = new int[1];
		ByteBuffer pixels = STBImage.stbi_load(file.getAbsolutePath(), texWidth, texHeight,
				texChannels, STBI_rgb_alpha);
		if (pixels == null)
		{
			System.err.println(("Problem with file: " + url.getFile()));
			throw new AssertionError(
					"Failed to load texture image: " + STBImage.stbi_failure_reason());
		}
		width = texWidth[0];
		height = texHeight[0];
		int imageSize = width * height * 4;
		mipLevels = 1;
		if (generateMipMap) mipLevels = (int) (Math.floor(log2nlz(Math.max(width, height))) + 1);

		Buffer buffer = new Buffer(logicalDevice, imageSize, VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);
		buffer.allocate(null);
		buffer.fillWithBuffer(pixels);

		STBImage.stbi_image_free(pixels);

		return buffer;
	}

	public static int log2nlz(int bits)
	{
		if (bits == 0) return 0; // or throw exception
		return 31 - Integer.numberOfLeadingZeros(bits);
	}

	private void generateMipmaps(VkCommandBuffer commandBuffer, long image)
	{
		VkImageMemoryBarrier.Buffer barrier = VkImageMemoryBarrier.calloc(1);
		barrier.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		barrier.image(image);
		barrier.srcQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
		barrier.dstQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
		barrier.subresourceRange().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		barrier.subresourceRange().baseArrayLayer(0);
		barrier.subresourceRange().layerCount(1);
		barrier.subresourceRange().levelCount(1);

		int mipWidth = width;
		int mipHeight = height;

		for (int i = 1; i < mipLevels; i++)
		{
			barrier.subresourceRange().baseMipLevel(i - 1);
			barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL);
			barrier.newLayout(VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL);
			barrier.srcAccessMask(VK_ACCESS_TRANSFER_WRITE_BIT);
			barrier.dstAccessMask(VK_ACCESS_TRANSFER_READ_BIT);

			vkCmdPipelineBarrier(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT,
					VK_PIPELINE_STAGE_TRANSFER_BIT, 0, null, null, barrier);

			VkOffset3D.Buffer srcOffsets = VkOffset3D.calloc(2);
			srcOffsets.get(0).set(0, 0, 0);
			srcOffsets.get(1).set(mipWidth, mipHeight, 1);

			VkOffset3D.Buffer dstOffsets = VkOffset3D.calloc(2);
			dstOffsets.get(0).set(0, 0, 0);
			dstOffsets.get(1).set(mipWidth / 2, mipHeight / 2, 1);

			VkImageBlit.Buffer blit = VkImageBlit.calloc(1);
			blit.srcOffsets(srcOffsets);
			blit.srcSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
			blit.srcSubresource().mipLevel(i - 1);
			blit.srcSubresource().baseArrayLayer(0);
			blit.srcSubresource().layerCount(1);
			blit.dstOffsets(dstOffsets);
			blit.dstSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
			blit.dstSubresource().mipLevel(i);
			blit.dstSubresource().baseArrayLayer(0);
			blit.dstSubresource().layerCount(1);

			vkCmdBlitImage(commandBuffer, image, VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL, image,
					VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, blit, VK_FILTER_LINEAR);

			barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL);
			barrier.newLayout(VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);
			barrier.srcAccessMask(VK_ACCESS_TRANSFER_READ_BIT);
			barrier.dstAccessMask(VK_ACCESS_SHADER_READ_BIT);

			vkCmdPipelineBarrier(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT,
					VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT, 0, null, null, barrier);

			if (mipWidth > 1) mipWidth /= 2;
			if (mipHeight > 1) mipHeight /= 2;

			blit.free();
		}

		barrier.subresourceRange().baseMipLevel(mipLevels - 1);
		barrier.oldLayout(VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL);
		barrier.newLayout(VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);
		barrier.srcAccessMask(VK_ACCESS_TRANSFER_WRITE_BIT);
		barrier.dstAccessMask(VK_ACCESS_SHADER_READ_BIT);

		vkCmdPipelineBarrier(commandBuffer, VK_PIPELINE_STAGE_TRANSFER_BIT,
				VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT, 0, null, null, barrier);

		barrier.free();
	}

	public Sampler getSampler()
	{
		return sampler;
	}

	public long getImageId()
	{
		return imageBuffer.getId();
	}

	public long getImageViewId()
	{
		return imageView.getId();
	}

	@Override
	public void free()
	{
		sampler.free();
		imageView.free();
		imageBuffer.free();
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		res.descriptorCount(1);
		res.stageFlags(VK_SHADER_STAGE_FRAGMENT_BIT);
		return res;
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		VkDescriptorImageInfo.Buffer imageInfo = VkDescriptorImageInfo.callocStack(1, stack);
		imageInfo.imageLayout(VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);
		imageInfo.imageView(getImageViewId());
		imageInfo.sampler(getSampler().getId());

		VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		descriptorWrite.pBufferInfo(null);
		descriptorWrite.pImageInfo(imageInfo);
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
	}

	@Override
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
		poolSize.descriptorCount(1);
		return poolSize;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageBuffer == null) ? 0 : imageBuffer.hashCode());
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Texture other = (Texture) obj;
		if (imageBuffer == null)
		{
			if (other.imageBuffer != null) return false;
		}
		else if (!imageBuffer.equals(other.imageBuffer)) return false;
		if (imagePath == null)
		{
			if (other.imagePath != null) return false;
		}
		else if (!imagePath.equals(other.imagePath)) return false;
		return true;
	}

}