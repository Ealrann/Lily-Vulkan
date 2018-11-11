package org.sheepy.vulkan.process.graphic.pool;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;

public interface IGraphicContextAdapter extends IVulkanAdapter
{
	GraphicContext getGraphicContext(EObject target);

	static IGraphicContextAdapter adapt(EObject object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IGraphicContextAdapter.class);
	}
}
