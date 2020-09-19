package org.sheepy.lily.vulkan.process.pipeline.task;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataConsumer;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.core.resource.IBufferReferenceAllocation;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferUtils;
import org.sheepy.lily.vulkan.core.resource.buffer.HostVisibleBufferBackend;
import org.sheepy.lily.vulkan.model.process.FetchBuffer;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_TRANSFER_DST_BIT;

@ModelExtender(scope = FetchBuffer.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(allocateBeforeParent = true, features = ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE)
@AllocationDependency(features = ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE, type = IBufferReferenceAllocation.class)
public final class FetchBufferRecorder implements IRecordableExtender
{
	private final ExecutionContext executionContext;
	private final IAllocationState allocationState;
	private final IBufferReferenceAllocation bufferReferenceAllocation;

	private FetchBufferRecorder(ExecutionContext executionContext,
								IAllocationState allocationState,
								@InjectDependency(index = 0) IBufferReferenceAllocation bufferReferenceAllocation)
	{
		this.executionContext = executionContext;
		this.allocationState = allocationState;
		this.bufferReferenceAllocation = bufferReferenceAllocation;
	}

	@Override
	public void record(final RecordContext context)
	{
		final var srcBufferAllocation = bufferReferenceAllocation.getBufferAllocations(context.index).get(0);
		final var srcBuffer = bufferReferenceAllocation.getBuffers(context.index).get(0);
		final var dataConsumerAdapter = srcBuffer.adaptNotNull(IBufferDataConsumer.class);
		final var fetcher = new Fetcher(executionContext, srcBufferAllocation, dataConsumerAdapter);

		srcBufferAllocation.attach(context);

		fetcher.record(context.commandBuffer);
		context.listenExecution(fetcher::fetch);
		allocationState.setAllocationObsolete();
	}

	private static final class Fetcher
	{
		private final ExecutionContext executionContext;
		private final IBufferAllocation srcBuffer;
		private final IBufferDataConsumer dataConsumer;
		private final HostVisibleBufferBackend stagingBuffer;
		private final long size;

		public Fetcher(final ExecutionContext executionContext,
					   final IBufferAllocation srcBuffer,
					   final IBufferDataConsumer dataConsumer)
		{
			this.executionContext = executionContext;
			this.srcBuffer = srcBuffer;
			this.dataConsumer = dataConsumer;
			size = srcBuffer.getBindSize();

			stagingBuffer = createStagingBuffer(srcBuffer.getBindSize());
		}

		private void record(VkCommandBuffer vkCommandBuffer)
		{
			try (final var stack = MemoryStack.stackPush())
			{
				BufferUtils.copyBuffer(stack,
									   vkCommandBuffer,
									   srcBuffer.getPtr(),
									   srcBuffer.getBindOffset(),
									   stagingBuffer.getAddress(),
									   0,
									   size);
			}
		}

		private void fetch(EExecutionStatus status)
		{
			if (status == EExecutionStatus.Done)
			{
				final var memoryPtr = stagingBuffer.mapMemory(executionContext.getVkDevice());
				try (final var stack = MemoryStack.stackPush())
				{
					stagingBuffer.invalidate(stack, executionContext.getVkDevice());
				}
				final var fetchBuffer = MemoryUtil.memByteBuffer(memoryPtr, (int) size);
				dataConsumer.fetch(fetchBuffer);
				stagingBuffer.unmapMemory(executionContext.getVkDevice());
				stagingBuffer.free(executionContext);
			}
			else if (status == EExecutionStatus.Canceled)
			{
				stagingBuffer.free(executionContext);
			}
		}

		private HostVisibleBufferBackend createStagingBuffer(long byteSize)
		{
			final int usage = VK_BUFFER_USAGE_TRANSFER_DST_BIT;
			final var bufferInfo = new BufferInfo(byteSize, usage, false);
			final var bufferBuilder = new HostVisibleBufferBackend.Builder(bufferInfo);
			executionContext.stackPush();
			final var res = bufferBuilder.build(executionContext);
			executionContext.stackPop();
			return res;
		}
	}
}
