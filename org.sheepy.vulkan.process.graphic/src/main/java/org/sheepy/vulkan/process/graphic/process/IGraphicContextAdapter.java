package org.sheepy.vulkan.process.graphic.process;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.process.process.IContextAdapter;

public interface IGraphicContextAdapter extends IContextAdapter<GraphicContext>
{
	@Override
	GraphicContext getContext(EObject target);

	static IGraphicContextAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IGraphicContextAdapter.class);
	}
}
