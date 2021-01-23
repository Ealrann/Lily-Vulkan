package org.sheepy.lily.vulkan.resource.buffer;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.logoce.notification.api.DummyNotifier;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferAdapter;

@ModelExtender(scope = StaticBuffer.class)
@Adapter(singleton = true)
public final class StaticBufferAdapter extends DummyNotifier<IBufferAdapter.Features> implements IBufferAdapter
{
	@Override
	public long getSize(final IBuffer buffer)
	{
		return ((StaticBuffer) buffer).getSize();
	}
}
