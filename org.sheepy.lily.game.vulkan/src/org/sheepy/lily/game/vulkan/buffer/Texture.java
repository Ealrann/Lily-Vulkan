package org.sheepy.lily.game.vulkan.buffer;

import static org.lwjgl.stb.STBImage.STBI_rgb_alpha;
import static org.lwjgl.vulkan.VK10.*;

import java.io.File;
import java.net.URL;
import java.nio.ByteBuffer;

import org.lwjgl.stb.STBImage;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageBlit;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.lwjgl.vulkan.VkOffset3D;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.command.SingleTimeCommands;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.sampler.Sampler;
import org.sheepy.lily.game.vulkan.view.ImageView;

public class Texture
{
	private LogicalDevice logicalDevice;
	private String imagePath;
	private boolean generateMipMap;

	private ImageBuffer imageBuffer;
	private ImageView imageView;
	private Sampler sampler;

	private int mipLevels;
	private int width;
	private int height;

	public static Texture alloc(LogicalDevice logicalDevice,
			String imagePath,
			CommandPool commandPool,
			VkQueue graphicQueue,
			boolean generateMipMap)
	{
		Texture res = new Texture(logicalDevice, imagePath, generateMipMap);
		res.load(commandPool, graphicQueue);
		return res;
	}

	public Texture(LogicalDevice logicalDevice, String imagePath, boolean generateMipMap)
	{
		this.logicalDevice = logicalDevice;
		this.imagePath = imagePath;
		this.generateMipMap = generateMipMap;

		imageBuffer = new ImageBuffer(logicalDevice);
		imageView = new ImageView(logicalDevice);
		sampler = new Sampler(logicalDevice, true);
	}

	public void load(CommandPool commandPool, VkQueue graphicQueue)
	{
		Buffer buffer = loadImageFile();

		imageBuffer.createImage(width, height, mipLevels, VK_FORMAT_R8G8B8A8_UNORM,
				VK_IMAGE_TILING_OPTIMAL,
				VK_IMAGE_USAGE_TRANSFER_SRC_BIT
						| VK_IMAGE_USAGE_TRANSFER_DST_BIT
						| VK_IMAGE_USAGE_SAMPLED_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		imageBuffer.transitionImageLayout(commandPool, graphicQueue, VK_FORMAT_R8G8B8A8_UNORM,
				VK_IMAGE_LAYOUT_UNDEFINED, VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, mipLevels);

		imageBuffer.fillWithBuffer(commandPool, graphicQueue, buffer);
		
		// imageBuffer.transitionImageLayout(commandPool, graphicQueue,
		// VK_FORMAT_R8G8B8A8_UNORM,
		// VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL,
		// VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL, mipLevels);
		generateMipmaps(commandPool, graphicQueue, imageBuffer.getId());

		imageView.load(imageBuffer.getId(), mipLevels, VK_FORMAT_R8G8B8A8_UNORM,
				VK_IMAGE_ASPECT_COLOR_BIT);

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
		ByteBuffer pixels = STBImage.stbi_load(url.getFile(), texWidth, texHeight, texChannels,
				STBI_rgb_alpha);
		if (pixels == null)
		{
			throw new AssertionError(
					"Failed to load texture image: " + STBImage.stbi_failure_reason());
		}
		width = texWidth[0];
		height = texHeight[0];
		int imageSize = width * height * 4;
		mipLevels = 1;
		if(generateMipMap)
			mipLevels = (int) (Math.floor(log2nlz(Math.max(width, height))) + 1);

		Buffer buffer = Buffer.alloc(logicalDevice, imageSize, VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);
		buffer.fillWithBuffer(pixels, imageSize);

		STBImage.stbi_image_free(pixels);

		return buffer;
	}

	public static int log2nlz(int bits)
	{
		if (bits == 0) return 0; // or throw exception
		return 31 - Integer.numberOfLeadingZeros(bits);
	}

	private void generateMipmaps(CommandPool commandPool, VkQueue queue, long image)
	{
		SingleTimeCommands command = commandPool.newSingleTimeCommand();

		VkCommandBuffer commandBuffer = command.startRecording();

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

	    vkCmdPipelineBarrier(commandBuffer,
	        VK_PIPELINE_STAGE_TRANSFER_BIT, VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT, 0,
	        null,
	        null,
	        barrier);

		command.submitCommands(queue);
		
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

	public void free()
	{
		sampler.free();
		imageView.free();
		imageBuffer.free();
	}
}
