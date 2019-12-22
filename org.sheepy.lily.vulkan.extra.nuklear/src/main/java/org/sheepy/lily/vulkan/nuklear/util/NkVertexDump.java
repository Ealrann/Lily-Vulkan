package org.sheepy.lily.vulkan.nuklear.util;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;

public class NkVertexDump
{
	public static void dumpVertex(long memoryAddress, long size)
	{
		final int elemSize = (int) (size / 4);
		final ByteBuffer buffer = MemoryUtil.memByteBuffer(memoryAddress, (int) size);
		for (int i = 0; i < elemSize - 5; i += 5)
		{
			final float x = buffer.getFloat();
			final float y = buffer.getFloat();
			final float u = buffer.getFloat();
			final float v = buffer.getFloat();
			final int color = buffer.getInt();
			final int r = color & 255;
			final int g = (color >> 8) & 255;
			final int b = (color >> 16) & 255;
			final int a = (color >> 24) & 255;
			final int index = i / 5;

			if (x != 0 || y != 0)
				System.out.print(String.format(	"%d| p:{%.0f, %.0f}, uv:{%.2f, %.2f}, rgb:{%d, %d, %d, %d}\n",
												index,
												x,
												y,
												u,
												v,
												r,
												g,
												b,
												a));
		}
	}

	public static void dumpIndex(long memoryAddress, long size)
	{
		final int elemSize = (int) (size / 2);
		final ByteBuffer buffer = MemoryUtil.memByteBuffer(memoryAddress, (int) size);
		for (int i = 0; i < elemSize - 3; i += 3)
		{
			final int i1 = buffer.getShort();
			final int i2 = buffer.getShort();
			final int i3 = buffer.getShort();

			if (i1 != 0 || i2 != 0 || i3 != 0)
				System.out.print(String.format("i:{%d, %d, %d}\n", i1, i2, i3));
		}
	}
}
