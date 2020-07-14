package org.sheepy.lily.vulkan.resource.buffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.resource.BufferMemory;
import org.sheepy.lily.vulkan.model.resource.StaticBuffer;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferObjectAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.util.AlignmentData;

import java.nio.ByteBuffer;

@ModelExtender(scope = StaticBuffer.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(parent = BufferMemory.class, type = BufferMemoryAllocation.class)
public class StaticBufferAllocation implements IBufferObjectAllocation
{
	private final StaticBuffer buffer;
	private final long bufferPtr;
	private final BufferMemoryAllocation bufferMemoryAllocation;
	private final AlignmentData alignmentData;

	public StaticBufferAllocation(StaticBuffer buffer,
								  @InjectDependency(index = 0) BufferMemoryAllocation bufferMemoryAllocation)
	{
		this.buffer = buffer;
		bufferPtr = bufferMemoryAllocation.getBufferPtr();
		this.bufferMemoryAllocation = bufferMemoryAllocation;
		alignmentData = bufferMemoryAllocation.getAlignmentData(buffer);
	}

	@Override
	public void fillData(ByteBuffer trgBuffer)
	{
		if (buffer.isInitWithZero())
		{
			MemoryUtil.memSet(trgBuffer, 0);
		}
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		bufferMemoryAllocation.attach(recordContext);
	}

	@Override
	public boolean needPush()
	{
		return false;
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
