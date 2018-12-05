package org.sheepy.vulkan.api.adapter;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.model.IEnginePart;

public interface IEnginePartAdapter extends IVulkanAdapter
{
	void allocatePart();
	void freePart();

	static IEnginePartAdapter adapt(IEnginePart part)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(part, IEnginePartAdapter.class);
	}
}
