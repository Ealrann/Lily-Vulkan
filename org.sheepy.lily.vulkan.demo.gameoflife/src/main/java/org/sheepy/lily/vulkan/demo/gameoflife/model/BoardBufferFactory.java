package org.sheepy.lily.vulkan.demo.gameoflife.model;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.demo.gameoflife.MainGameOfLife;
import org.sheepy.lily.vulkan.demo.gameoflife.compute.Board;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.impl.BufferImpl;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public class BoardBufferFactory
{
	private static final int WIDTH_IN_TILE = MainGameOfLife.WIDTH / ModelFactory.WORKGROUP_SIDE;
	private static final int TILE_SIZE = ModelFactory.WORKGROUP_SIDE * ModelFactory.WORKGROUP_SIDE;

	public static Buffer createBoardBuffer(Board board)
	{
		final Buffer res = new BufferImpl();

		final int width = board.getWidth();
		final int height = board.getHeight();
		final int size = width * height;
		final int byteSize = size * Integer.BYTES;

		res.setSize(byteSize);
		res.getUsages().add(EBufferUsage.STORAGE_BUFFER_BIT);
		res.getUsages().add(EBufferUsage.TRANSFER_SRC_BIT);
		res.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);
		res.setDescriptorType(EDescriptorType.STORAGE_BUFFER);
		res.getShaderStages().add(EShaderStage.COMPUTE_BIT);

		final var byteBuffer = MemoryUtil.memAlloc(byteSize);
		final var intBufferView = byteBuffer.asIntBuffer();
		final boolean[][] values = board.getValues();
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				final int index = globalIndexFromGlobal(x, y);
				intBufferView.put(index, values[x][y] ? 1 : 0);
			}
		}
		intBufferView.flip();

		res.setData(byteBuffer);

		return res;
	}

	private static int globalIndexFromGlobal(int x, int y)
	{
		final int xWorkgroup = x / ModelFactory.WORKGROUP_SIDE;
		final int yWorkgroup = y / ModelFactory.WORKGROUP_SIDE;

		final int localIdX = x - xWorkgroup * ModelFactory.WORKGROUP_SIDE;
		final int localIdY = y - yWorkgroup * ModelFactory.WORKGROUP_SIDE;

		final int tileIndex = (xWorkgroup + yWorkgroup * WIDTH_IN_TILE) * TILE_SIZE;
		final int index = tileIndex + localIdX + localIdY * ModelFactory.WORKGROUP_SIDE;

		return index;
	}
}
