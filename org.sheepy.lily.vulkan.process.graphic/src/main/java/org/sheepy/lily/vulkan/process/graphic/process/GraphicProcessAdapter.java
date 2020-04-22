package org.sheepy.lily.vulkan.process.graphic.process;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;

@ModelExtender(scope = GraphicProcess.class)
@Adapter(singleton = true)
public class GraphicProcessAdapter implements InternalProcessAdapter
{
	@Override
	public EQueueType getExecutionQueueType()
	{
		return EQueueType.Graphic;
	}

	@Override
	public boolean needPresentQueue()
	{
		return true;
	}
}
