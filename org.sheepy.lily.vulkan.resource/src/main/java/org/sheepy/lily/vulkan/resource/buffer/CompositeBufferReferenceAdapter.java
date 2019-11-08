package org.sheepy.lily.vulkan.resource.buffer;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.NotifierAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.notification.LongNotification;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAdapter;
import org.sheepy.lily.vulkan.common.resource.IDataProviderAlignmentAdapter;
import org.sheepy.lily.vulkan.model.resource.CompositeBufferReference;
import org.sheepy.lily.vulkan.model.resource.IBufferReference;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.resource.buffer.provider.DataProviderWrapper;

@Statefull
@Adapter(scope = CompositeBufferReference.class, lazy = false)
public class CompositeBufferReferenceAdapter extends NotifierAdapter
		implements IBufferReferenceAdapter
{
	private final INotificationListener listenerProxy = this::fireNotification;
	private final INotificationListener instanceListener = this::instanceChange;
	private final CompositeBufferReference ref;

	private IDataProviderAlignmentAdapter providerAdapter;

	public CompositeBufferReferenceAdapter(CompositeBufferReference ref)
	{
		super(FEATURES.values().length);
		this.ref = ref;

	}

	@Load
	public void load()
	{
		final var provider = ref.getBuffer().getDataProviders().get(ref.getPart());
		providerAdapter = provider.adapt(IDataProviderAlignmentAdapter.class);
		providerAdapter.addListener(listenerProxy,
									DataProviderWrapper.FEATURES.SIZE.ordinal(),
									DataProviderWrapper.FEATURES.OFFSET.ordinal(),
									DataProviderWrapper.FEATURES.BUFFER_PTR.ordinal());
		ref.addListener(instanceListener, ResourcePackage.COMPOSITE_BUFFER_REFERENCE__INSTANCE);
	}

	@Dispose
	public void dispose()
	{
		providerAdapter.removeListener(	listenerProxy,
										DataProviderWrapper.FEATURES.SIZE.ordinal(),
										DataProviderWrapper.FEATURES.OFFSET.ordinal(),
										DataProviderWrapper.FEATURES.BUFFER_PTR.ordinal());
		ref.removeListener(instanceListener, ResourcePackage.COMPOSITE_BUFFER_REFERENCE__INSTANCE);
	}

	public void instanceChange(Notification notification)
	{
		final long oldOffset = providerAdapter.getInstanceOffset(notification.getOldIntValue());
		final var newNotification = new LongNotification(	ref,
															IBufferReferenceAdapter.FEATURES.OFFSET.ordinal(),
															oldOffset,
															getOffset(ref));
		fireNotification(newNotification);
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
		return providerAdapter.getInstanceOffset(this.ref.getInstance());
	}

	@Override
	public long getSize(IBufferReference ref)
	{
		return providerAdapter.getInstanceSize();
	}
}
