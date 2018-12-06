package org.sheepy.vulkan.api.adapter;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.model.IEnginePart;

public interface IEnginePartAdapter extends IVulkanAdapter
{
	void allocatePart();
	void freePart();

	static IEnginePartAdapter adapt(IEnginePart part)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(part, IEnginePartAdapter.class);
	}
}
