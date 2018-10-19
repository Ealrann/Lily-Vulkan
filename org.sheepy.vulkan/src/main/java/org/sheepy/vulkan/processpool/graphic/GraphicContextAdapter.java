package org.sheepy.vulkan.processpool.graphic;

import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapter;
import org.sheepy.vulkan.model.process.GraphicProcessPool;
import org.sheepy.vulkan.model.process.ProcessPackage;

public class GraphicContextAdapter extends AbstractSheepyAdapter implements IGraphicContextAdapter
{
	@Override
	public GraphicContext getGraphicContext()
	{
		var current = target;
		while (!ProcessPackage.Literals.GRAPHIC_PROCESS_POOL.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return GraphicProcessPoolAdapter.adapt((GraphicProcessPool) current).context;
	}
}
