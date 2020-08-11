package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
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

		final var bufferPushCommand = new PushBuffersCommand(fillBufferCommands);
		final var imagePushCommands = fillImageCommands.stream().map(PushImageCommand::new);

		context.executeCommand(recordContext -> {
			bufferPushCommand.execute(recordContext);
			imagePushCommands.forEach(c -> c.execute(recordContext));
		});
		bufferPushCommand.postExecute();
	}

	private final class PushBuffersCommand
	{
		private final List<FillCommand.FillBufferCommand> fillCommands;
		private final CPUBufferBackend stagingBuffer;

		public PushBuffersCommand(List<FillCommand.FillBufferCommand> fillCommands)
		{
			final long size = fillCommands.stream().mapToLong(FillCommand::size).sum();
			stagingBuffer = createStagingBuffer(size);
			this.fillCommands = fillCommands;
		}

		private CPUBufferBackend createStagingBuffer(long byteSize)
		{
			final int usage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
			final var bufferInfo = new BufferInfo(byteSize, usage, false, true);
			final var bufferBuilder = new CPUBufferBackend.Builder(bufferInfo);
			return bufferBuilder.build(context);
		}

		public void execute(IRecordContext context)
		{
			final long stagingPtr = stagingBuffer.mapMemory(context.getVkDevice());
			long position = stagingPtr;

			final var stack = context.stack();
			final var vkCommandBuffer = context.vkCommandBuffer();
			long offset = 0;

			for (final var fillCommand : fillCommands)
			{
				final long partSize = fillCommand.size();
				fillCommand.dataProvider().fillBuffer(MemoryUtil.memByteBuffer(position, (int) partSize));

				final long dstOffset = fillCommand.offset();
				final long deviceBufferPtr = fillCommand.bufferPtr();
				fillBuffer(stack, vkCommandBuffer, deviceBufferPtr, offset, dstOffset, partSize);
				offset += partSize;
				position += fillCommand.size();
			}
		}

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
