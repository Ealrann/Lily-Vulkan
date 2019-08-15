package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

import java.nio.ByteBuffer;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.execution.ISingleTimeCommand;

public class BufferGPUFiller
{
	private static final int STAGING_USAGE = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
	private final IExecutionContext context;
	private final long targetBufferId;

	private CPUBufferBackend stagingBuffer;

	public BufferGPUFiller(IExecutionContext context, long targetBufferId)
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
			public void execute(IExecutionContext context, VkCommandBuffer commandBuffer)
			{
				fillBuffer(commandBuffer, offset, byteSize);
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

	private void fillBuffer(VkCommandBuffer commandBuffer, long offset, long byteSize)
	{
		final var srcAddress = stagingBuffer.getAddress();

		BufferUtils.copyBuffer(commandBuffer, srcAddress, 0, targetBufferId, offset, byteSize);
	}
}
