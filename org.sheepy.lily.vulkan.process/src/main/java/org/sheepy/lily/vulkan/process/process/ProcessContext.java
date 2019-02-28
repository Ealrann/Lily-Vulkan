package org.sheepy.lily.vulkan.process.process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.process.execution.AbstractCommandBuffers;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;

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

		this.descriptorPool = descriptorPool;
		this.commandBuffers = commandBuffers;
		this.submission = createSubmission(process);
		this.process = process;
		this.application = (Application) EcoreUtil.getRootContainer(process);
	}

	protected abstract ProcessSubmission createSubmission(AbstractProcess process);

	public Collection<? extends Object> getAllocationChildren()
	{
		return allocationList;
	}
}
