package org.sheepy.lily.vulkan.demo.gameoflife.model;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.demo.gameoflife.compute.Board;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public class BoardBufferFactory
{
	private static final int TILE_SIZE = EngineBuilder.WORKGROUP_SIDE
			* EngineBuilder.WORKGROUP_SIDE;

	public static Buffer createBoardBuffer(Board board)
	{
		final Buffer res = ResourceFactory.eINSTANCE.createBuffer();

		final int width = board.getWidth();
		final int height = board.getHeight();
		final int size = width * height;
		final int byteSize = size * Integer.BYTES;

		final int widthInTiles = width / EngineBuilder.WORKGROUP_SIDE;

		res.setSize(byteSize);
		res.getUsages().add(EBufferUsage.STORAGE_BUFFER_BIT);
		res.getUsages().add(EBufferUsage.TRANSFER_SRC_BIT);
		res.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);

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

		res.setData(byteBuffer);

		return res;
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
