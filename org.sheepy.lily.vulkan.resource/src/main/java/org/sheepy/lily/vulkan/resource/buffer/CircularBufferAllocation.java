package org.sheepy.lily.vulkan.resource.buffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.resource.CircularBuffer;
import org.sheepy.lily.vulkan.model.resource.MemoryChunk;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryPartAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.MemoryChunkAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.util.AlignmentData;

import java.nio.ByteBuffer;

@ModelExtender(scope = CircularBuffer.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(parent = MemoryChunk.class, type = MemoryChunkAllocation.class)
public final class CircularBufferAllocation implements IMemoryPartAllocation
{
	private final CircularBuffer circularBuffer;
	private final long bufferPtr;
	private final AlignmentData alignmentData;

	private boolean needPush = true;

	private CircularBufferAllocation(CircularBuffer circularBuffer,
									 IAllocationState allocationState,
									 IObservatoryBuilder observatory,
									 @InjectDependency(index = 0) MemoryChunkAllocation memoryChunkAllocation)
	{
		this.circularBuffer = circularBuffer;
		bufferPtr = memoryChunkAllocation.getBufferPtr();
		alignmentData = memoryChunkAllocation.getAlignmentData(circularBuffer);

		final var dataProviderObservatory = observatory.explore(VulkanResourcePackage.CIRCULAR_BUFFER__DATA_PROVIDER)
													   .adaptNotifier(IBufferDataProviderAdapter.class);
		dataProviderObservatory.listenNoParam(allocationState::setAllocationObsolete,
											  IBufferDataProviderAdapter.Features.Data);
	}

	@Override
	public void fillData(long dstPtr)
	{
		final var bufferDataProvider = circularBuffer.getDataProvider().adapt(IBufferDataProviderAdapter.class);
		final var trgBuffer = MemoryUtil.memByteBuffer(dstPtr, (int) getBindSize());
		bufferDataProvider.fill(trgBuffer);
		needPush = false;
	}

	@Override
	public boolean needPush()
	{
		return needPush;
	}

	@Override
	public long getPtr()
	{
		return bufferPtr;
	}

	@Override
	public long getMemoryPtr()
	{
		return 0;
	}

	@Override
	public long getBindOffset()
	{
		return alignmentData.offset();
	}

	@Override
	public long getBindSize()
	{
		return alignmentData.size();
	}

	@Override
	public long mapMemory()
	{
		throw new AssertionError("Unsupported Operation");
	}

	@Override
	public void unmapMemory()
	{
		throw new AssertionError("Unsupported Operation");
	}

	@Override
	public void flush()
	{
		throw new AssertionError("Unsupported Operation");
	}

	@Override
	public void invalidate()
	{
		throw new AssertionError("Unsupported Operation");
	}

	@Override
	public void pushData(ByteBuffer data)
	{
		throw new AssertionError("Unsupported Operation");
	}
}
