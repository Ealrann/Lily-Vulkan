package org.sheepy.lily.vulkan.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IPushBufferAdapter;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.staging.IStagingBuffer;
import org.sheepy.vulkan.resource.staging.StagingBuffer;

@Statefull
@Adapter(scope = PushBuffer.class)
public class PushBufferAdapter implements IPushBufferAdapter, IResourceAdapter
{
	private final StagingBuffer stagingBuffer;

	public PushBufferAdapter(PushBuffer pushBuffer)
	{
		final long size = pushBuffer.getSize();
		final int instanceCount = pushBuffer.getInstanceCount();

		stagingBuffer = new StagingBuffer(size, instanceCount);
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		stagingBuffer.allocate(stack, context);
	}

	@Override
	public void free(IExecutionContext context)
	{
		stagingBuffer.free(context);
	}

	@Override
	public boolean isAllocationDirty(IExecutionContext context)
	{
		return false;
	}

	@Override
	public IStagingBuffer getStagingBuffer()
	{
		return stagingBuffer;
	}
}
