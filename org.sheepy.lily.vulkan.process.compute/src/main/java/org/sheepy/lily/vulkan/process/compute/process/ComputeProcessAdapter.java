package org.sheepy.lily.vulkan.process.compute.process;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.queue.EQueueType;
import org.sheepy.vulkan.queue.VulkanQueue;

@Statefull
@Adapter(scope = ComputeProcess.class)
public class ComputeProcessAdapter extends AbstractProcessAdapter
{
	private static final List<ECommandStage> stages = List.of(ECommandStage.COMPUTE);

	public ComputeProcessAdapter(ComputeProcess process)
	{
		super(process);
	}

	@Override
	protected ProcessContext createContext()
	{
		return new ComputeContext(getQueueType(), isResetAllowed(), descriptorPool,
				(ComputeProcess) process);
	}

	@Override
	protected Integer prepareNextExecution()
	{
		return 0;
	}

	@Override
	public VulkanQueue getQueue()
	{
		return context.getQueue();
	}

	@Override
	protected EQueueType getQueueType()
	{
		return EQueueType.Compute;
	}

	public static ComputeProcessAdapter adapt(ComputeProcess object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, ComputeProcessAdapter.class);
	}

	@Override
	protected List<ECommandStage> getStages()
	{
		return stages;
	}
}
