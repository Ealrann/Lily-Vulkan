package org.sheepy.vulkan.process.graphic.process;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;

public interface IGraphicContextAdapter extends IVulkanAdapter
{
	GraphicContext getGraphicContext(EObject target);

	static IGraphicContextAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IGraphicContextAdapter.class);
	}
}
