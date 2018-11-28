package org.sheepy.vulkan.resource.util;

import static org.lwjgl.stb.STBImage.STBI_rgb_alpha;
import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

import java.nio.ByteBuffer;

import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.model.resource.PathResource;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.vulkan.resource.buffer.BufferBackend;
import org.sheepy.vulkan.resource.file.FileResourceAdapter;

public class STBImageLoader
{
	private final LogicalDevice logicalDevice;

	private int width;
	private int height;
	private BufferBackend buffer;

	public STBImageLoader(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}
	
	public void load(MemoryStack stack, PathResource resource)
	{
		final var path = resource.getPath();
		final var fileAdapter = FileResourceAdapter.adapt(resource);
		final ByteBuffer bufferedRessource = fileAdapter.toByteBuffer(resource);

		if (bufferedRessource == null)
		{
			System.err.println("Can't access the file : " + path);
		}

		final int[] texWidth = new int[1];
		final int[] texHeight = new int[1];
		final int[] texChannels = new int[1];
		final ByteBuffer pixels = STBImage.stbi_load_from_memory(bufferedRessource, texWidth,
				texHeight, texChannels, STBI_rgb_alpha);
		if (pixels == null)
		{
			System.err.println(("Problem with file: " + path));
			throw new AssertionError(
					"Failed to load texture image: " + STBImage.stbi_failure_reason());
		}
		width = texWidth[0];
		height = texHeight[0];

		final int imageSize = width * height * 4;
		final int usage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
		buffer = BufferAllocator.allocateCPUBufferAndFill(stack, logicalDevice,
				imageSize, usage, pixels);

		STBImage.stbi_image_free(pixels);
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public BufferBackend getBuffer()
	{
		return buffer;
	}
}
