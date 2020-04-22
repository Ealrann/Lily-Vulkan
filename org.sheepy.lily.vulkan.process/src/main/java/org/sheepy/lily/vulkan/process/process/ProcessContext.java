package org.sheepy.lily.vulkan.process.process;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.core.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;

import java.util.ArrayList;
import java.util.List;

public abstract class ProcessContext<T extends ProcessContext<T>> extends ExecutionContext implements IProcessContext
{
	public final DescriptorPool descriptorPool;
	public final Application application;
	public final AbstractProcess process;

	protected final List<IAllocable<? super T>> allocationList = new ArrayList<>();

	public ProcessContext(final IVulkanContext vulkanContext, EQueueType queueType,
						  boolean resetAllowed,
						  DescriptorPool descriptorPool,
						  AbstractProcess process)
	{
		super(vulkanContext, queueType, resetAllowed);

		this.process = process;
		this.descriptorPool = descriptorPool;
		this.application = (Application) EcoreUtil.getRootContainer(process);
	}

	public List<IAllocable<? super T>> getAllocationChildren()
	{
		return allocationList;
	}

	public final DescriptorPool getDescriptorPool()
	{
		return descriptorPool;
	}

	public final AbstractProcess getProcess()
	{
		return process;
	}

	public abstract IExecutionRecorders<? super T> getExecutionRecorders();
	public abstract List<IExecutionRecorder<? super T>> getRecorders();
}
