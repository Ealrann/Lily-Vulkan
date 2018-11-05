package org.sheepy.vulkan.processpool.graphic;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.AbstractServiceAdapter;
import org.sheepy.vulkan.model.process.GraphicProcessPool;
import org.sheepy.vulkan.model.process.ProcessPackage;

public class GraphicContextAdapter extends AbstractServiceAdapter implements IGraphicContextAdapter
{
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return true;
	}
	
	@Override
	public GraphicContext getGraphicContext(EObject target)
	{
		var current = target;
		while (!ProcessPackage.Literals.GRAPHIC_PROCESS_POOL.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return GraphicProcessPoolAdapter.adapt((GraphicProcessPool) current).context;
	}
}
