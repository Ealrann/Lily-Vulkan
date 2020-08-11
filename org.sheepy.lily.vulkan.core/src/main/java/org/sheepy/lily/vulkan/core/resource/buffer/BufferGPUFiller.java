package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

public final class BufferGPUFiller
{
	private static final int STAGING_USAGE = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
	private final long targetBufferPtr;

	public BufferGPUFiller(long targetBufferPtr)
	{
		this.targetBufferPtr = targetBufferPtr;
	}

	public void fill(IRecordContext recordContext, Consumer<ByteBuffer> dataProvider, long offset, long size)
	{
		recordFill(recordContext, offset, size, stagingBuffer -> stagingBuffer.pushData(recordContext, dataProvider));
	}

	public void fill(IRecordContext recordContext, ByteBuffer sourceBuffer, long offset, long size)
	{
		recordFill(recordContext, offset, size, stagingBuffer -> stagingBuffer.pushData(recordContext, sourceBuffer));
	}

	private void recordFill(IRecordContext recordContext, long offset, long size, Consumer<CPUBufferBackend> fillBuffer)
	{
		final var stagingBuffer = createStagingBuffer(recordContext, size);
		fillBuffer.accept(stagingBuffer);

		final var fillContext = new FillContext(stagingBuffer, targetBufferPtr, recordContext);
		fillContext.fillAndListen(offset, size);
	}

	private static CPUBufferBackend createStagingBuffer(IRecordContext recordContext, long byteSize)
	{
		final int usage = STAGING_USAGE;
		final var bufferInfo = new BufferInfo(byteSize, usage, false, true);
		final var bufferBuilder = new CPUBufferBackend.Builder(bufferInfo);
		return bufferBuilder.build(recordContext);
	}

	private static final class FillContext
	{
		private final CPUBufferBackend stagingBuffer;
		private final long targetBufferPtr;
		private final IRecordContext context;

		public FillContext(CPUBufferBackend stagingBuffer, long targetBufferPtr, IRecordContext context)
		{
			this.stagingBuffer = stagingBuffer;
			this.targetBufferPtr = targetBufferPtr;
			this.context = context;
		}

		public void fillAndListen(long offset, long size)
		{
			final var stack = context.stack();
			final var vkCommandBuffer = context.vkCommandBuffer();
			fillBuffer(stack, vkCommandBuffer, offset, size);

			context.listenExecution(this::onExecutionProgress);
		}

		private void fillBuffer(MemoryStack stack, VkCommandBuffer commandBuffer, long offset, long byteSize)
		{
			final var srcAddress = stagingBuffer.getAddress();
			BufferUtils.copyBuffer(stack, commandBuffer, srcAddress, 0, targetBufferPtr, offset, byteSize);
		}

		private void onExecutionProgress(EExecutionStatus status)
		{
			if (status == EExecutionStatus.Done || status == EExecutionStatus.Canceled)
			{
				stagingBuffer.free(context);
			}
		}
	}
}
