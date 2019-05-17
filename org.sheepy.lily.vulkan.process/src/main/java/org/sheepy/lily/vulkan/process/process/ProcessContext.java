package org.sheepy.lily.vulkan.process.process;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.process.IProcessContext.IRecorderContext;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.allocation.IAllocationObject;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.queue.EQueueType;

public abstract class ProcessContext<T extends IRecorderContext<T>> extends ExecutionContext
		implements IProcessContext, IRecorderContext<T>
{
	public final DescriptorPool descriptorPool;
	public final Application application;
	public final AbstractProcess process;

	protected final List<IAllocationObject<? super T>> allocationList = new ArrayList<>();

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
	public List<IAllocationObject<? super T>> getAllocationChildren()
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
