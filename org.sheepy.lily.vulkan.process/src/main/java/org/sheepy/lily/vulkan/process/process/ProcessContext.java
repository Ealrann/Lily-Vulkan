package org.sheepy.lily.vulkan.process.process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorders;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.queue.EQueueType;

public abstract class ProcessContext extends ExecutionContext
{
	public final DescriptorPool descriptorPool;
	public final Application application;
	public final AbstractProcess process;

	protected final List<IAllocable> allocationList = new ArrayList<>();

	public ProcessContext(	EQueueType queueType,
							boolean resetAllowed,
							DescriptorPool descriptorPool,
							AbstractProcess process)
	{
		super(queueType, resetAllowed);

		this.process = process;
		this.descriptorPool = descriptorPool;
		this.application = (Application) EcoreUtil.getRootContainer(process);
	}

	public Collection<? extends Object> getAllocationChildren()
	{
		return allocationList;
	}

	public DescriptorPool getDescriptorPool()
	{
		return descriptorPool;
	}

	public abstract ExecutionRecorders getExecutionRecorders();

	public abstract List<IExecutionRecorder> getRecorders();
}
