package org.sheepy.lily.vulkan.process.compute.process;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;

@ModelExtender(scope = ComputeProcess.class)
@Adapter(singleton = true)
public class ComputeProcessAdapter implements InternalProcessAdapter
{
	@Override
	public EQueueType getExecutionQueueType()
	{
		return EQueueType.Compute;
	}

	@Override
	public boolean needPresentQueue()
	{
		return false;
	}

}
