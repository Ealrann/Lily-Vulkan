package org.sheepy.lily.vulkan.api.adapter;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.model.IEnginePart;

public interface IEnginePartAdapter extends IVulkanAdapter
{
	void allocatePart();
	void freePart();

	static IEnginePartAdapter adapt(IEnginePart part)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(part, IEnginePartAdapter.class);
	}
}
