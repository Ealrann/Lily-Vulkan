package org.sheepy.lily.vulkan.resource.image.backend;

import static org.lwjgl.stb.STBImage.STBI_rgb_alpha;

import java.nio.ByteBuffer;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryUtil;

public final class STBImageLoader
{
	private int width;
	private int height;
	private ByteBuffer pixels;

	public void allocBuffer(ByteBuffer bufferedImage)
	{
		final int[] texWidth = new int[1];
		final int[] texHeight = new int[1];
		final int[] texChannels = new int[1];
		pixels = STBImage.stbi_load_from_memory(bufferedImage,
												texWidth,
												texHeight,
												texChannels,
												STBI_rgb_alpha);
		width = texWidth[0];
		height = texHeight[0];
	}

	public static Vector2ic getSize(ByteBuffer bufferedImage)
	{
		final int[] texWidth = new int[1];
		final int[] texHeight = new int[1];
		final int[] texChannels = new int[1];
		STBImage.stbi_info_from_memory(bufferedImage, texWidth, texHeight, texChannels);

		return new Vector2i(texWidth[0], texHeight[0]);
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

	public void free()
	{
		MemoryUtil.memFree(pixels);
	}
}
