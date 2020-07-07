package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.DummyNotifier;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.resource.DataBuffer;
import org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart;
import org.sheepy.lily.vulkan.resource.memorychunk.IMemoryPartAdapter;

@ModelExtender(scope = DataBuffer.class)
@Adapter(singleton = true)
public class DataBufferAdapter extends DummyNotifier<IMemoryPartAdapter.Features> implements IMemoryPartAdapter
{
	@Override
	public long getSize(final IMemoryChunkPart buffer)
	{
		return ((DataBuffer) buffer).getData().capacity();
	}

	@Override
	public int getUsage(final IMemoryChunkPart buffer)
	{
		return VulkanModelUtil.getEnumeratedFlag(((DataBuffer) buffer).getUsages());
	}
}
