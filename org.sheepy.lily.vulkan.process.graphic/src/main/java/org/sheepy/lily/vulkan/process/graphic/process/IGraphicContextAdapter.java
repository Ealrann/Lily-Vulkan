package org.sheepy.lily.vulkan.process.graphic.process;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.process.process.IContextAdapter;

public interface IGraphicContextAdapter extends IContextAdapter<GraphicContext>
{
	@Override
	GraphicContext getContext(EObject target);

	static IGraphicContextAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IGraphicContextAdapter.class);
	}
}
