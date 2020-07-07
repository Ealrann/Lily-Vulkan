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
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAllocation;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferUtils;
import org.sheepy.lily.vulkan.core.resource.buffer.CPUBufferBackend;
import org.sheepy.lily.vulkan.model.process.FetchBuffer;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

@ModelExtender(scope = FetchBuffer.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(allocateBeforeParent = true, features = ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE)
@AllocationDependency(features = ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE, type = IBufferReferenceAllocation.class)
public final class FetchBufferRecorder implements IRecordableExtender
{
	private final FetchBuffer task;
	private final ExecutionContext executionContext;
	private final IAllocationState allocationState;
	private final IBufferReferenceAllocation bufferReferenceAllocation;

	private FetchBufferRecorder(FetchBuffer task,
								ExecutionContext executionContext,
								IAllocationState allocationState,
								@InjectDependency(index = 0) IBufferReferenceAllocation bufferReferenceAllocation)
	{
		this.task = task;
		this.executionContext = executionContext;
		this.allocationState = allocationState;
		this.bufferReferenceAllocation = bufferReferenceAllocation;
	}

	@Override
	public void record(final RecordContext context)
	{
		final var srcBuffer = bufferReferenceAllocation.getBufferAllocations(context.index, context.indexCount).get(0);
		final var dataProviderAdapter = task.getDataProvider().adapt(IBufferDataProviderAdapter.class);
		final var fetcher = new Fetcher(executionContext, srcBuffer, dataProviderAdapter);

		fetcher.record(context.commandBuffer);
		context.listenExecution(fetcher::fetch);
		allocationState.setAllocationObsolete();
	}

	private static final class Fetcher
	{
		private final ExecutionContext executionContext;
		private final IBufferAllocation srcBuffer;
		private final IBufferDataProviderAdapter dataProviderAdapter;
		private final CPUBufferBackend stagingBuffer;
		private final long size;

		public Fetcher(final ExecutionContext executionContext,
					   final IBufferAllocation srcBuffer,
					   final IBufferDataProviderAdapter dataProviderAdapter)
		{
			this.executionContext = executionContext;
			this.srcBuffer = srcBuffer;
			this.dataProviderAdapter = dataProviderAdapter;
			size = srcBuffer.getBindSize();

			stagingBuffer = createStagingBuffer(srcBuffer.getBindSize());
		}

		private void record(VkCommandBuffer vkCommandBuffer)
		{
			try (final var stack = MemoryStack.stackPush())
			{
				executionContext.stackPush();
				BufferUtils.copyBuffer(stack,
									   vkCommandBuffer,
									   srcBuffer.getPtr(),
									   srcBuffer.getBindOffset(),
									   stagingBuffer.getAddress(),
									   0,
									   size);
				executionContext.stackPop();
			}
		}

		private void fetch()
		{
			final var memoryPtr = stagingBuffer.mapMemory(executionContext.getVkDevice());
			final var fetchBuffer = MemoryUtil.memByteBuffer(memoryPtr, (int) size);
			dataProviderAdapter.fetch(fetchBuffer);
			stagingBuffer.unmapMemory(executionContext.getVkDevice());
			stagingBuffer.free(executionContext);
		}

		private CPUBufferBackend createStagingBuffer(long byteSize)
		{
			final int usage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
			final var bufferInfo = new BufferInfo(byteSize, usage, false);
			final var bufferBuilder = new CPUBufferBackend.Builder(bufferInfo, true);
			executionContext.stackPush();
			final var res = bufferBuilder.build(executionContext);
			executionContext.stackPop();
			return res;
		}
	}
}
