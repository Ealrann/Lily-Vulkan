package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.DummyNotifier;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.resource.IBufferObject;
import org.sheepy.lily.vulkan.model.resource.StaticBuffer;
import org.sheepy.lily.vulkan.resource.memorychunk.IBufferObjectAdapter;

@ModelExtender(scope = StaticBuffer.class)
@Adapter(singleton = true)
public class StaticBufferAdapter extends DummyNotifier<IBufferObjectAdapter.Features> implements IBufferObjectAdapter
{
	@Override
	public long getSize(final IBufferObject buffer)
	{
		return ((StaticBuffer) buffer).getSize();
	}

	@Override
	public int getUsage(final IBufferObject buffer)
	{
		return VulkanModelUtil.getEnumeratedFlag(((StaticBuffer) buffer).getUsages());
	}
}
