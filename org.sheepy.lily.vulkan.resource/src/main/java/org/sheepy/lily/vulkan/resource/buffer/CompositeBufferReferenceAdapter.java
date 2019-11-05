package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.NotifierAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAdapter;
import org.sheepy.lily.vulkan.model.resource.CompositeBufferReference;
import org.sheepy.lily.vulkan.model.resource.IBufferReference;
import org.sheepy.lily.vulkan.resource.buffer.provider.DataProviderWrapper;

@Statefull
@Adapter(scope = CompositeBufferReference.class, lazy = false)
public class CompositeBufferReferenceAdapter extends NotifierAdapter
		implements IBufferReferenceAdapter
{
	private final INotificationListener listenerProxy = this::fireNotification;
	private final DataProviderWrapper providerAdapter;

	public CompositeBufferReferenceAdapter(CompositeBufferReference ref)
	{
		super(FEATURES.values().length);

		final var provider = ref.getBuffer().getDataProviders().get(ref.getPart());
		providerAdapter = provider.adapt(DataProviderWrapper.class);
		providerAdapter.addListener(listenerProxy,
									DataProviderWrapper.FEATURES.SIZE.ordinal(),
									DataProviderWrapper.FEATURES.OFFSET.ordinal(),
									DataProviderWrapper.FEATURES.BUFFER_PTR.ordinal());
	}

	@Dispose
	public void dispose()
	{
		providerAdapter.removeListener(	listenerProxy,
										DataProviderWrapper.FEATURES.SIZE.ordinal(),
										DataProviderWrapper.FEATURES.OFFSET.ordinal(),
										DataProviderWrapper.FEATURES.BUFFER_PTR.ordinal());
	}

	@Override
	public void flush(IBufferReference ref)
	{}

	@Override
	public long getBufferPtr(IBufferReference ref)
	{
		return providerAdapter.getBufferPtr();
	}

	@Override
	public long getOffset(IBufferReference ref)
	{
		return providerAdapter.getOffset();
	}

	@Override
	public long getSize(IBufferReference ref)
	{
		return providerAdapter.getSize();
	}
}
