package org.sheepy.vulkan.process.graphic.process;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;

public class GraphicContextAdapter extends AbstractSingletonAdapter
		implements IGraphicContextAdapter
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
		while (!GraphicPackage.Literals.GRAPHIC_PROCESS.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return GraphicProcessAdapter.adapt((GraphicProcess) current).context;
	}
}
