package org.sheepy.lily.vulkan.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IPushBufferAdapter;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.resource.buffer.IStagingBuffer;
import org.sheepy.vulkan.resource.buffer.StagingBuffer;

@Statefull
@Adapter(scope = PushBuffer.class)
public class PushBufferAdapter implements IPushBufferAdapter, IAllocable
{
	private final StagingBuffer stagingBuffer;

	public PushBufferAdapter(PushBuffer pushBuffer)
	{
		final long size = pushBuffer.getSize();
		final int instanceCount = pushBuffer.getInstanceCount();

		stagingBuffer = new StagingBuffer(size, instanceCount);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		stagingBuffer.allocate(stack, context);
	}

	@Override
	public void free(IAllocationContext context)
	{
		stagingBuffer.free(context);
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	@Override
	public IStagingBuffer getStagingBuffer()
	{
		return stagingBuffer;
	}
}
