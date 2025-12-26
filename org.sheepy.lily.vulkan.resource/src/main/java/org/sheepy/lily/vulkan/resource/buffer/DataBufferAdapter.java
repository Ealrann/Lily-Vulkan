package org.sheepy.lily.vulkan.resource.buffer;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.DummyNotifier;
import org.sheepy.lily.vulkan.model.vulkanresource.DataBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferAdapter;

@ModelExtender(scope = DataBuffer.class)
@Adapter(singleton = true)
public final class DataBufferAdapter extends DummyNotifier<IBufferAdapter.Features> implements IBufferAdapter
{
	@Override
	public long getSize(final IBuffer buffer)
	{
		return ((DataBuffer) buffer).data().capacity();
	}
}

