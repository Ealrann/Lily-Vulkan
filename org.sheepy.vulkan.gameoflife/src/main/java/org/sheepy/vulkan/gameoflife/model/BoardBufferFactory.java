package org.sheepy.vulkan.gameoflife.model;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.gameoflife.compute.Board;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.model.resource.impl.BufferImpl;
import org.sheepy.vulkan.resource.buffer.BufferAdapter;
import org.sheepy.vulkan.resource.buffer.BufferAdapter.IBufferLoader;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.vulkan.resource.buffer.BufferBackend;
import org.sheepy.vulkan.resource.buffer.BufferGPUFiller;

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

		BoardBufferLoader loader = new BoardBufferLoader(board);
		BufferAdapter.adapt(res).setLoader(loader);

		return res;
	}

	private static class BoardBufferLoader implements IBufferLoader
	{
		private final Board board;

		public BoardBufferLoader(Board board)
		{
			this.board = board;
		}

		@Override
		public void load(ExecutionManager executionManager, BufferBackend backendBuffer)
		{
			var bufferInfo = backendBuffer.getInfos();
			int byteSize = (int) bufferInfo.size;
			int size = board.getWidth() * board.getHeight();

			var byteBuffer = MemoryUtil.memAlloc(byteSize);
			var intBufferView = byteBuffer.asIntBuffer();
			for (int i = 0; i < size; i++)
			{
				intBufferView.put(board.isActivated(i) ? 1 : 0);
			}
			intBufferView.flip();

			try (MemoryStack stack = MemoryStack.stackPush())
			{
				var bufferFiller = new BufferGPUFiller(stack, executionManager,
						backendBuffer.getId());
				bufferFiller.fill(byteBuffer, byteSize);
			}
		}
	}
}
