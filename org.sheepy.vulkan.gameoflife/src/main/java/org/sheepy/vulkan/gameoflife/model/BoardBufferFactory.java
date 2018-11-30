package org.sheepy.vulkan.gameoflife.model;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.vulkan.gameoflife.compute.Board;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.model.resource.impl.BufferImpl;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;

public class BoardBufferFactory
{
	public static Buffer createBoardBuffer(Board board)
	{
		Buffer res = new BufferImpl();

		int size = board.getWidth() * board.getHeight();
		int byteSize = size * Integer.BYTES;
		int usage = VK_BUFFER_USAGE_STORAGE_BUFFER_BIT
				| VK_BUFFER_USAGE_TRANSFER_SRC_BIT
				| VK_BUFFER_USAGE_TRANSFER_DST_BIT;

		res.setSize(byteSize);
		res.setUsage(usage);
		res.setProperties(BufferAllocator.DEVICE_LOCAL);
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
