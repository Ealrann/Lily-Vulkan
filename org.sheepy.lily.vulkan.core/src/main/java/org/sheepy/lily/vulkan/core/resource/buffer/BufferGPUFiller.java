package org.sheepy.lily.vulkan.core.resource.buffer;

import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.core.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.core.execution.ISingleTimeCommand;
import org.sheepy.lily.vulkan.core.execution.InternalExecutionContext;

public class BufferGPUFiller
{
	private static final int STAGING_USAGE = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
	private final InternalExecutionContext context;
	private final long targetBufferId;

	private CPUBufferBackend stagingBuffer;

	public BufferGPUFiller(InternalExecutionContext context, long targetBufferId)
	{
		this.context = context;
		this.targetBufferId = targetBufferId;
	}

	public void fill(ByteBuffer sourceBuffer, long offset, long byteSize)
	{
		createStagingBuffer(sourceBuffer, byteSize);

		context.execute(new ISingleTimeCommand()
		{
			@Override
			public void execute(InternalExecutionContext context, ICommandBuffer<?> commandBuffer)
			{
				final var stack = context.stack();
				fillBuffer(stack, commandBuffer.getVkCommandBuffer(), offset, byteSize);
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
		final int usage = STAGING_USAGE;
		final var bufferInfo = new BufferInfo(byteSize, usage, false);
		stagingBuffer = new CPUBufferBackend(bufferInfo, true);
		stagingBuffer.allocate(context);
		stagingBuffer.pushData(context, sourceBuffer);
	}

	private void fillBuffer(MemoryStack stack,
							VkCommandBuffer commandBuffer,
							long offset,
							long byteSize)
	{
		final var srcAddress = stagingBuffer.getAddress();

		BufferUtils.copyBuffer(	stack,
								commandBuffer,
								srcAddress,
								0,
								targetBufferId,
								offset,
								byteSize);
	}
}
