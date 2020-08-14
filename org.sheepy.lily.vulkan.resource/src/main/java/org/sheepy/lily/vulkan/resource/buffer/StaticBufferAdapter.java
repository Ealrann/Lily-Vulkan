package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.DummyNotifier;
import org.sheepy.lily.vulkan.model.resource.IBuffer;
import org.sheepy.lily.vulkan.model.resource.StaticBuffer;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferAdapter;

@ModelExtender(scope = StaticBuffer.class)
@Adapter(singleton = true)
public class StaticBufferAdapter extends DummyNotifier<IBufferAdapter.Features> implements IBufferAdapter
{
	@Override
	public long getSize(final IBuffer buffer)
	{
		return ((StaticBuffer) buffer).getSize();
	}
}
