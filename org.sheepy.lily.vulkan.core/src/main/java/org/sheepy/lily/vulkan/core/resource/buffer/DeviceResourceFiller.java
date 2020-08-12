package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.util.FillCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

public final class DeviceResourceFiller
{
	private final ExecutionContext context;

	public DeviceResourceFiller(ExecutionContext context)
	{
		this.context = context;
	}

	public void fillData(Stream<FillCommand> fillCommands, final long size)
	{
		// TODO create only one memory chunk for all the staging buffers
		final List<FillCommand.FillBufferCommand> fillBufferCommands = new ArrayList<>();
		final List<FillCommand.FillImageCommand> fillImageCommands = new ArrayList<>();
		fillCommands.forEach(command -> {
			if (command instanceof FillCommand.FillBufferCommand bufferCommand)
			{
				fillBufferCommands.add(bufferCommand);
			}
			else if (command instanceof FillCommand.FillImageCommand imageCommand)
			{
				fillImageCommands.add(imageCommand);
			}
		});

		final var bufferPushCommand = new PushBuffersCommand(fillBufferCommands, context);
		final var imagePushCommands = fillImageCommands.stream().map(PushImageCommand::new);

		bufferPushCommand.fillStagingBuffer();

		context.executeCommand(recordContext -> {
			bufferPushCommand.execute(recordContext);
			imagePushCommands.forEach(c -> c.execute(recordContext));
		});
	}

	private static final class PushBuffersCommand
	{
		private final List<FillCommand.FillBufferCommand> fillCommands;
		private final CPUBufferBackend stagingBuffer;
		private final IVulkanContext context;

		public PushBuffersCommand(List<FillCommand.FillBufferCommand> fillCommands, IVulkanContext context)
		{
			this.context = context;
			final long size = fillCommands.stream().mapToLong(FillCommand::size).sum();
			stagingBuffer = size > 0 ? createStagingBuffer(context, size) : null;
			this.fillCommands = fillCommands;
		}

		private static CPUBufferBackend createStagingBuffer(IVulkanContext context, long byteSize)
		{
			final int usage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
			final var bufferInfo = new BufferInfo(byteSize, usage, false, false);
			final var bufferBuilder = new CPUBufferBackend.Builder(bufferInfo);
			return bufferBuilder.build(context);
		}

		public void fillStagingBuffer()
		{
			if (stagingBuffer != null)
			{
				final var vkDevice = context.getVkDevice();
				final long stagingPtr = stagingBuffer.mapMemory(vkDevice);
				long position = stagingPtr;
				for (final var fillCommand : fillCommands)
				{
					final long size = fillCommand.size();
					fillCommand.dataProvider().fillBuffer(MemoryUtil.memByteBuffer(position, (int) size));
					position += size;
				}
				try (final var stack = MemoryStack.stackPush())
				{
					stagingBuffer.flush(stack, vkDevice);
				}
				stagingBuffer.unmapMemory(vkDevice);
			}
		}

		public void execute(final IRecordContext context)
		{
			if (stagingBuffer != null)
			{
				final var stack = context.stack();
				final var vkCommandBuffer = context.vkCommandBuffer();
				long offset = 0;

				for (final var fillCommand : fillCommands)
				{
					final long size = fillCommand.size();
					final long dstOffset = fillCommand.offset();
					final long deviceBufferPtr = fillCommand.bufferPtr();
					fillBuffer(stack, vkCommandBuffer, deviceBufferPtr, offset, dstOffset, size);
					offset += size;
				}

				context.listenExecution(status -> {
					if (status == EExecutionStatus.Done || status == EExecutionStatus.Canceled)
					{
						stagingBuffer.free(context);
					}
				});
			}
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

	private static final class PushImageCommand
	{
		private final FillCommand.FillImageCommand fillCommand;

		public PushImageCommand(FillCommand.FillImageCommand fillCommand)
		{
			this.fillCommand = fillCommand;
		}

		public void execute(IRecordContext context)
		{
			final var dataProvider = fillCommand.dataProvider();
			fillCommand.vkImage().fillWith(context, dataProvider);
		}
	}
}
