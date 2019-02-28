package org.sheepy.lily.vulkan.process.process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.resource.Semaphore;
import org.sheepy.lily.vulkan.process.execution.AbstractCommandBuffers;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.resource.semaphore.SemaphoreAdapter;

public abstract class ProcessContext extends ExecutionContext
{
	public final DescriptorPool descriptorPool;
	public final AbstractCommandBuffers<?> commandBuffers;
	public final Application application;
	public final AbstractProcess process;
	public final ProcessSubmission submission;

	protected final List<IAllocable> allocationList = new ArrayList<>();

	public ProcessContext(	EQueueType queueType,
							boolean resetAllowed,
							DescriptorPool descriptorPool,
							AbstractCommandBuffers<?> commandBuffers,
							AbstractProcess process)
	{
		super(queueType, resetAllowed);

		this.process = process;
		this.descriptorPool = descriptorPool;
		this.commandBuffers = commandBuffers;
		this.submission = createSubmission(process);
		this.application = (Application) EcoreUtil.getRootContainer(process);
	}

	public Collection<? extends Object> getAllocationChildren()
	{
		return allocationList;
	}

	protected List<VkSemaphore> gatherSinalSemaphores()
	{
		var res = new ArrayList<VkSemaphore>();
		for (Semaphore semaphore : process.getSignals())
		{
			res.add(SemaphoreAdapter.adapt(semaphore).getVkSemaphore());
		}
		return res;
	}

	protected List<WaitData> gatherWaitDatas()
	{
		var waitDatas = new ArrayList<WaitData>();
		for (Semaphore waitFor : process.getWaitFor())
		{
			var semaphoreData = convertToData(waitFor);
			waitDatas.add(semaphoreData);
		}
		return waitDatas;
	}

	protected static WaitData convertToData(Semaphore semaphore)
	{
		var adapter = SemaphoreAdapter.adapt(semaphore);
		var waitStage = semaphore.getWaitStage();
		return new WaitData(adapter.getVkSemaphore(), waitStage);
	}

	protected abstract ProcessSubmission createSubmission(AbstractProcess process);
}
