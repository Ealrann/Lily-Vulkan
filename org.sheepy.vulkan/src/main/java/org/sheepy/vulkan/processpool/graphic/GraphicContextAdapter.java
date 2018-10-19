package org.sheepy.vulkan.processpool.graphic;

import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapter;
import org.sheepy.vulkan.model.GraphicProcessPool;
import org.sheepy.vulkan.model.VulkanPackage;

public class GraphicContextAdapter extends AbstractSheepyAdapter implements IGraphicContextAdapter
{
	@Override
	public GraphicContext getGraphicContext()
	{
		var current = target;
		while (!VulkanPackage.Literals.GRAPHIC_PROCESS_POOL.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return GraphicProcessPoolAdapter.adapt((GraphicProcessPool) current).context;
	}
}
