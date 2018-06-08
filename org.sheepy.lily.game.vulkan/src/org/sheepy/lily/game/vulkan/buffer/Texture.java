package org.sheepy.lily.game.vulkan.buffer;

import static org.lwjgl.stb.STBImage.STBI_rgb_alpha;
import static org.lwjgl.vulkan.VK10.*;

import java.io.File;
import java.net.URL;
import java.nio.ByteBuffer;

import org.lwjgl.stb.STBImage;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.sampler.Sampler;
import org.sheepy.lily.game.vulkan.view.ImageView;

public class Texture
{
	private LogicalDevice logicalDevice;
	private String imagePath;

	private ImageBuffer imageBuffer;
	private ImageView imageView;
	private Sampler sampler;

	private int width;
	private int height;

	public static Texture alloc(LogicalDevice logicalDevice,
			String imagePath,
			CommandPool commandPool,
			VkQueue graphicQueue)
	{
		Texture res = new Texture(logicalDevice, imagePath);
		res.load(commandPool, graphicQueue);
		return res;
	}

	public Texture(LogicalDevice logicalDevice, String imagePath)
	{
		this.logicalDevice = logicalDevice;
		this.imagePath = imagePath;

		imageBuffer = new ImageBuffer(logicalDevice);
		imageView = new ImageView(logicalDevice);
		sampler = new Sampler(logicalDevice, true);
	}

	public void load(CommandPool commandPool, VkQueue graphicQueue)
	{
		Buffer buffer = loadImageFile();

		imageBuffer.createImage(width, height, VK_FORMAT_R8G8B8A8_UNORM, VK_IMAGE_TILING_OPTIMAL,
				VK_IMAGE_USAGE_TRANSFER_DST_BIT | VK_IMAGE_USAGE_SAMPLED_BIT,
				VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		imageBuffer.transitionImageLayout(commandPool, graphicQueue, VK_FORMAT_R8G8B8A8_UNORM,
				VK_IMAGE_LAYOUT_UNDEFINED, VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL);

		imageBuffer.fillWithBuffer(commandPool, graphicQueue, buffer);

		imageBuffer.transitionImageLayout(commandPool, graphicQueue, VK_FORMAT_R8G8B8A8_UNORM,
				VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);

		imageView.load(imageBuffer.getId(), VK_FORMAT_R8G8B8A8_UNORM, VK_IMAGE_ASPECT_COLOR_BIT);
		
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

		Buffer buffer = Buffer.alloc(logicalDevice, imageSize, VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);
		buffer.fillWithBuffer(pixels, imageSize);

		STBImage.stbi_image_free(pixels);

		return buffer;
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
