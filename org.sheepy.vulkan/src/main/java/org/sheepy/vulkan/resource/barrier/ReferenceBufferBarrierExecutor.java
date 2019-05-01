package org.sheepy.vulkan.resource.barrier;

import org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier;

public class ReferenceBufferBarrierExecutor extends BufferBarrierExecutor
{
	private final ReferenceBufferBarrier barrier;

	public ReferenceBufferBarrierExecutor(ReferenceBufferBarrier barrier)
	{
		super(barrier);
		this.barrier = barrier;
	}

	@Override
	protected long getBufferAddress()
	{
		return barrier.getBufferAddress();
	}
}
