package org.sheepy.lily.vulkan.resource.image.backend;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

import static org.lwjgl.stb.STBImage.STBI_rgb_alpha;

public final class STBImageLoader
{
	public static ImageBuffer load(ByteBuffer bufferedImage)
	{
		final int[] texWidth = new int[1];
		final int[] texHeight = new int[1];
		final int[] texChannels = new int[1];

		final var pixels = STBImage.stbi_load_from_memory(bufferedImage,
														  texWidth,
														  texHeight,
														  texChannels,
														  STBI_rgb_alpha);
		final var width = texWidth[0];
		final var height = texHeight[0];

		return new ImageBuffer(width, height, pixels);
	}

	public static Vector2ic getSize(ByteBuffer bufferedImage)
	{
		final int[] texWidth = new int[1];
		final int[] texHeight = new int[1];
		final int[] texChannels = new int[1];
		STBImage.stbi_info_from_memory(bufferedImage, texWidth, texHeight, texChannels);

		return new Vector2i(texWidth[0], texHeight[0]);
	}

	public record ImageBuffer(int width, int height, ByteBuffer pixels)
	{
		public void free()
		{
			MemoryUtil.memFree(pixels);
		}
	}
}
