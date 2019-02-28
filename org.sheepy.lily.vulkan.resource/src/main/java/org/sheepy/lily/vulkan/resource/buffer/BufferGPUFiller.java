package org.sheepy.lily.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.execution.SingleTimeCommand;

public class BufferGPUFiller
{
	private final ExecutionContext context;
	private final long targetBufferId;
	private final MemoryStack stack;

	private CPUBufferBackend stagingBuffer;

	public BufferGPUFiller(MemoryStack stack, ExecutionContext context, long targetBufferId)
	{
		this.stack = stack;
		this.context = context;
		this.targetBufferId = targetBufferId;
	}

	public void fill(ByteBuffer sourceBuffer, long byteSize)
	{
		createStagingBuffer(sourceBuffer, byteSize);

		final SingleTimeCommand stc = new SingleTimeCommand(context)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				fillBuffer(commandBuffer, byteSize);
			}

			@Override
			protected void postExecute()
			{
				stagingBuffer.free();
			}
		};
		stc.execute();
	}

	private void createStagingBuffer(ByteBuffer sourceBuffer, long byteSize)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
		final var logicalDevice = context.getLogicalDevice();
		stagingBuffer = BufferAllocator.allocateCPUBufferAndFill(stack, logicalDevice, byteSize,
				usage, false, sourceBuffer);
	}

	private void fillBuffer(VkCommandBuffer commandBuffer, long byteSize)
	{
		final var stagingBufferId = stagingBuffer.getId();

		BufferUtils.copyBuffer(commandBuffer, stagingBufferId, targetBufferId, byteSize);
	}
}
