package org.sheepy.lily.vulkan.resource.util;

import static org.lwjgl.stb.STBImage.STBI_rgb_alpha;

import java.nio.ByteBuffer;

import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.resource.file.FileResourceAdapter;

public class STBImageLoader
{
	private int width;
	private int height;
	private ByteBuffer pixels;

	public void allocBuffer(PathResource resource)
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
		pixels = STBImage.stbi_load_from_memory(bufferedRessource, texWidth, texHeight, texChannels,
				STBI_rgb_alpha);
		MemoryUtil.memFree(bufferedRessource);
		if (pixels == null)
		{
			System.err.println(("Problem with file: " + path));
			String failure_reason = STBImage.stbi_failure_reason();
			throw new AssertionError("Failed to load texture image: " + failure_reason);
		}
		width = texWidth[0];
		height = texHeight[0];
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public ByteBuffer getBuffer()
	{
		return pixels;
	}
}
