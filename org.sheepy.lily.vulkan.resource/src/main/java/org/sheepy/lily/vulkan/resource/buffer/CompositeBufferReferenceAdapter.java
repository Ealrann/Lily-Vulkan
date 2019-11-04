package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.ICompositeBufferAdapter;
import org.sheepy.lily.vulkan.model.resource.CompositeBufferReference;

@Adapter(scope = CompositeBufferReference.class)
public class CompositeBufferReferenceAdapter
		implements IBufferReferenceAdapter<CompositeBufferReference>
{
	@Override
	public long getBufferPtr(CompositeBufferReference ref)
	{
		final var buffer = ref.getBuffer();
		final var adapter = buffer.adaptNotNull(ICompositeBufferAdapter.class);
		return adapter.getPtr();
	}

	@Override
	public long getOffset(CompositeBufferReference ref)
	{
		final var buffer = ref.getBuffer();
		final var adapter = buffer.adaptNotNull(ICompositeBufferAdapter.class);
		return adapter.getOffset(ref.getPart());
	}

	@Override
	public long getSize(CompositeBufferReference ref)
	{
		final var buffer = ref.getBuffer();
		final var adapter = buffer.adaptNotNull(ICompositeBufferAdapter.class);
		return adapter.getSize(ref.getPart());
	}

	@Override
	public void flush(CompositeBufferReference ref)
	{}
}
