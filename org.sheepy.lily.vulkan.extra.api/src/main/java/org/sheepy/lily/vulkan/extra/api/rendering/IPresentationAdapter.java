package org.sheepy.lily.vulkan.extra.api.rendering;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;


public interface IPresentationAdapter extends IVulkanAdapter
{
	int getPartCount();

	/**
	 * @return true if this presentation is intended to be instanciated only once
	 */
	boolean isSingleton();

	public static IPresentationAdapter adapt(Presentation presentation)
	{
		return IAdapterFactoryService.INSTANCE.adapt(presentation, IPresentationAdapter.class);
	}
}
