package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.core.execution.ISingleTimeCommand;
import org.sheepy.lily.vulkan.core.util.FillCommand;

import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

public final class DeviceBufferFiller
{
	private final ExecutionContext context;

	public DeviceBufferFiller(ExecutionContext context)
	{
		this.context = context;
	}

	public void fillData(List<FillCommand> partsToPush)
	{
		final long size = partsToPush.stream().mapToLong(FillCommand::size).sum();
		final var stagingBuffer = createStagingBuffer(size);
		final long stagingPtr = stagingBuffer.mapMemory(context.getVkDevice());

		long position = stagingPtr;
		for (final var part : partsToPush)
		{
			part.dataProvider().fillBuffer(position);
			position += part.size();
		}

		final var pushCommand = new VkPushCommand(partsToPush, stagingBuffer);
		context.execute(pushCommand);
	}

	private CPUBufferBackend createStagingBuffer(long byteSize)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
		final var bufferInfo = new BufferInfo(byteSize, usage, false, true);
		final var bufferBuilder = new CPUBufferBackend.Builder(bufferInfo);
		return bufferBuilder.build(context);
	}

	private final class VkPushCommand implements ISingleTimeCommand
	{
		private final List<FillCommand> partsToPush;
		private final CPUBufferBackend stagingBuffer;

		public VkPushCommand(List<FillCommand> partsToPush, CPUBufferBackend stagingBuffer)
		{
			this.partsToPush = partsToPush;
			this.stagingBuffer = stagingBuffer;
		}

		@Override
		public void execute(ExecutionContext context, ICommandBuffer commandBuffer)
		{
			final var stack = context.stack();
			final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
			long offset = 0;

			for (final var part : partsToPush)
			{
				final long partSize = part.size();
				final long dstOffset = part.offset();
				final long deviceBufferPtr = part.bufferPtr();
				fillBuffer(stack, vkCommandBuffer, deviceBufferPtr, offset, dstOffset, partSize);
				offset += partSize;
			}
		}

		@Override
		public void postExecute()
		{
			stagingBuffer.free(context);
		}

		private void fillBuffer(MemoryStack stack,
								VkCommandBuffer commandBuffer,
								long deviceBufferPtr,
								long srcOffset,
								long trgOffset,
								long byteSize)
		{
			final var srcAddress = stagingBuffer.getAddress();
			BufferUtils.copyBuffer(stack, commandBuffer, srcAddress, srcOffset, deviceBufferPtr, trgOffset, byteSize);
		}
	}
}
