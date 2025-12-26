package org.sheepy.lily.vulkan.demo.gameoflife.model;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.demo.gameoflife.compute.Board;
import org.sheepy.lily.vulkan.model.vulkanresource.DataBuffer;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public class BoardBufferFactory
{
	private static final int TILE_SIZE = EngineBuilder.WORKGROUP_SIDE * EngineBuilder.WORKGROUP_SIDE;

	public static DataBuffer createBoardBuffer(Board board)
	{
		return createBoardBuffer(board, null);
	}

	public static DataBuffer createBoardBuffer(Board board, String name)
	{
		final int width = board.getWidth();
		final int height = board.getHeight();
		final int size = width * height;
		final int byteSize = size * Integer.BYTES;
		final int widthInTiles = width / EngineBuilder.WORKGROUP_SIDE;

		final var byteBuffer = MemoryUtil.memAlloc(byteSize);
		final var intBufferView = byteBuffer.asIntBuffer();
		final boolean[][] values = board.getValues();
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				final int index = globalIndexFromGlobal(widthInTiles, x, y);
				intBufferView.put(index, values[x][y] ? 1 : 0);
			}
		}
		intBufferView.flip();

		final var builder = DataBuffer.builder()
									  .addUsage(EBufferUsage.STORAGE_BUFFER_BIT)
									  .addUsage(EBufferUsage.TRANSFER_SRC_BIT)
									  .addUsage(EBufferUsage.TRANSFER_DST_BIT)
									  .data(byteBuffer);
		if (name != null) builder.name(name);
		return builder.build();
	}

	private static int globalIndexFromGlobal(int widthInTiles, int x, int y)
	{
		final int xWorkgroup = x / EngineBuilder.WORKGROUP_SIDE;
		final int yWorkgroup = y / EngineBuilder.WORKGROUP_SIDE;

		final int localIdX = x - xWorkgroup * EngineBuilder.WORKGROUP_SIDE;
		final int localIdY = y - yWorkgroup * EngineBuilder.WORKGROUP_SIDE;

		final int tileIndex = (xWorkgroup + yWorkgroup * widthInTiles) * TILE_SIZE;
		final int index = tileIndex + localIdX + localIdY * EngineBuilder.WORKGROUP_SIDE;

		return index;
	}
}
