package org.sheepy.vulkan.processpool.graphic;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.vulkan.adapter.IVulkanAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;

public interface IGraphicContextAdapter extends IVulkanAdapter
{
	GraphicContext getGraphicContext();

	static IGraphicContextAdapter adapt(EObject object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, IGraphicContextAdapter.class);
	}
}
