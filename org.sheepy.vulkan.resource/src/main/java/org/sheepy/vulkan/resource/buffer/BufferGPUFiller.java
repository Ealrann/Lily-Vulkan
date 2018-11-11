package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.common.execution.SingleTimeCommand;

public class BufferGPUFiller
{
	private final ExecutionManager context;
	private final long targetBufferId;
	private final MemoryStack stack;

	private StandaloneBuffer stagingBuffer;

	public BufferGPUFiller(MemoryStack stack, ExecutionManager context, long targetBufferId)
	{
		this.stack = stack;
		this.context = context;
		this.targetBufferId = targetBufferId;
	}

	public void fill(ByteBuffer sourceBuffer, int byteSize)
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

	public void createStagingBuffer(ByteBuffer sourceBuffer, int byteSize)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
		final var logicalDevice = context.logicalDevice;
		stagingBuffer = BufferAllocator.allocateCPUBufferAndFill(stack, logicalDevice, byteSize,
				usage, sourceBuffer);
	}

	public void fillBuffer(VkCommandBuffer commandBuffer, int byteSize)
	{
		final var stagingBufferId = stagingBuffer.getId();

		BufferUtils.copyBuffer(commandBuffer, stagingBufferId, targetBufferId, byteSize);
	}
}
