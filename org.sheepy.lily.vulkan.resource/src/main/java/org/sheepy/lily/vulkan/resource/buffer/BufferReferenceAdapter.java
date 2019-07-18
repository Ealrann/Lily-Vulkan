package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferReference;

@Adapter(scope = BufferReference.class)
public class BufferReferenceAdapter implements IBufferReferenceAdapter<BufferReference>
{
	@Override
	public long getBufferPtr(BufferReference ref)
	{
		final var buffer = ref.getBuffer();
		final var adapter = IBufferAdapter.adapt(buffer);
		return adapter.getPtr();
	}

	@Override
	public long getOffset(BufferReference ref)
	{
		return ref.getOffset();
	}
}
