package org.sheepy.lily.vulkan.gameoflife.model;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.gameoflife.compute.Board;
import org.sheepy.lily.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.lily.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.impl.BufferImpl;

public class BoardBufferFactory
{
	public static Buffer createBoardBuffer(Board board)
	{
		Buffer res = new BufferImpl();

		int size = board.getWidth() * board.getHeight();
		int byteSize = size * Integer.BYTES;

		res.setSize(byteSize);
		res.getUsages().add(EBufferUsage.STORAGE_BUFFER_BIT);
		res.getUsages().add(EBufferUsage.TRANSFER_SRC_BIT);
		res.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);
		res.setDescriptorType(EDescriptorType.STORAGE_BUFFER);
		res.getShaderStages().add(EShaderStage.COMPUTE_BIT);

		var byteBuffer = MemoryUtil.memAlloc(byteSize);
		var intBufferView = byteBuffer.asIntBuffer();
		for (int i = 0; i < size; i++)
		{
			intBufferView.put(board.isActivated(i) ? 1 : 0);
		}
		intBufferView.flip();

		res.setData(byteBuffer);

		return res;
	}
}
