package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferReference;
import org.sheepy.lily.vulkan.model.resource.IBufferReference;

@Adapter(scope = BufferReference.class, lazy = false)
public class BufferReferenceAdapter implements IBufferReferenceAdapter
{
	@Override
	public void flush(IBufferReference ref)
	{
		final var buffer = ((BufferReference) ref).getBuffer();
		final var adapter = buffer.adaptNotNull(IBufferAdapter.class);
		adapter.flush();
	}

	@Override
	public long getBufferPtr(IBufferReference ref)
	{
		final var buffer = ((BufferReference) ref).getBuffer();
		final var adapter = buffer.adaptNotNull(IBufferAdapter.class);
		return adapter.getPtr();
	}

	@Override
	public long getOffset(IBufferReference ref)
	{
		return ((BufferReference) ref).getOffset();
	}

	@Override
	public long getSize(IBufferReference ref)
	{
		final var buffer = ((BufferReference) ref).getBuffer();
		return buffer.getSize();
	}

	@Override
	public void addListener(INotificationListener listener, int... features)
	{}

	@Override
	public void removeListener(INotificationListener listener, int... features)
	{}
}
