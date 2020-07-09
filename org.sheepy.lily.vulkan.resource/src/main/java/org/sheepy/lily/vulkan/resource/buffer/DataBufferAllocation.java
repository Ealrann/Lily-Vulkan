package org.sheepy.lily.vulkan.resource.buffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.resource.DataBuffer;
import org.sheepy.lily.vulkan.model.resource.MemoryChunk;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryPartAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.MemoryChunkAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.util.AlignmentData;

import java.nio.ByteBuffer;

import static org.lwjgl.system.MemoryUtil.memAddress;

@ModelExtender(scope = DataBuffer.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(parent = MemoryChunk.class, type = MemoryChunkAllocation.class)
public class DataBufferAllocation implements IMemoryPartAllocation
{
	private final DataBuffer buffer;
	private final long bufferPtr;
	private final MemoryChunkAllocation memoryChunkAllocation;
	private final AlignmentData alignmentData;

	private boolean needPush = true;

	public DataBufferAllocation(DataBuffer buffer,
								@InjectDependency(index = 0) MemoryChunkAllocation memoryChunkAllocation)
	{
		this.buffer = buffer;
		bufferPtr = memoryChunkAllocation.getBufferPtr();
		this.memoryChunkAllocation = memoryChunkAllocation;
		alignmentData = memoryChunkAllocation.getAlignmentData(buffer);
	}

	@Override
	public void fillData(long dstPtr)
	{
		MemoryUtil.memCopy(memAddress(buffer.getData()), dstPtr, alignmentData.size());
		needPush = false;
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		memoryChunkAllocation.attach(recordContext);
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
