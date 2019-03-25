package org.sheepy.lily.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.execution.ISingleTimeCommand;

public class BufferGPUFiller
{
	private final IExecutionContext context;
	private final long targetBufferId;
	private final MemoryStack stack;

	private CPUBufferBackend stagingBuffer;

	public BufferGPUFiller(MemoryStack stack, IExecutionContext context, long targetBufferId)
	{
		this.stack = stack;
		this.context = context;
		this.targetBufferId = targetBufferId;
	}

	public void fill(ByteBuffer sourceBuffer, long byteSize)
	{
		createStagingBuffer(sourceBuffer, byteSize);

		context.execute(stack, new ISingleTimeCommand()
		{
			@Override
			public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				fillBuffer(commandBuffer, byteSize);
			}

			@Override
			public void postExecute()
			{
				stagingBuffer.free(context);
			}
		});
	}

	private void createStagingBuffer(ByteBuffer sourceBuffer, long byteSize)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
		stagingBuffer = BufferAllocator.allocateCPUBufferAndFill(stack, context, byteSize, usage,
				false, sourceBuffer);
	}

	private void fillBuffer(VkCommandBuffer commandBuffer, long byteSize)
	{
		final var stagingBufferId = stagingBuffer.getAddress();

		BufferUtils.copyBuffer(commandBuffer, stagingBufferId, targetBufferId, byteSize);
	}
}
