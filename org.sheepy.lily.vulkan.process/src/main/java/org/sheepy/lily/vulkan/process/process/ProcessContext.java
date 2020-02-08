package org.sheepy.lily.vulkan.process.process;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.core.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.process.IProcessContext;
import org.sheepy.lily.vulkan.core.process.IProcessContext.IRecorderContext;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;

public abstract class ProcessContext<T extends IRecorderContext<T>> extends ExecutionContext
		implements IProcessContext, IRecorderContext<T>
{
	public final DescriptorPool descriptorPool;
	public final Application application;
	public final AbstractProcess process;

	protected final List<IAllocable<? super T>> allocationList = new ArrayList<>();

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

	@Override
	public List<IAllocable<? super T>> getAllocationChildren()
	{
		return allocationList;
	}

	@Override
	public final DescriptorPool getDescriptorPool()
	{
		return descriptorPool;
	}

	@Override
	public final AbstractProcess getProcess()
	{
		return process;
	}
}
