package org.sheepy.lily.vulkan.process.graphic.process;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;

public class GraphicContextAdapter extends AbstractSingletonAdapter
		implements IGraphicContextAdapter
{
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return true;
	}

	@Override
	public GraphicContext getContext(EObject target)
	{
		var current = target;
		while (!GraphicPackage.Literals.GRAPHIC_PROCESS.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return GraphicProcessAdapter.adapt((GraphicProcess) current).context;
	}
}
