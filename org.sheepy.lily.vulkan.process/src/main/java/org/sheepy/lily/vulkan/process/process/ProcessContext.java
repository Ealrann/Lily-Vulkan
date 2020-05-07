package org.sheepy.lily.vulkan.process.process;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;

import java.util.ArrayList;
import java.util.List;

public class ProcessContext extends ExecutionContext implements IProcessContext
{
	public final Application application;
	public final AbstractProcess process;

	protected final List<ILilyEObject> allocationList = new ArrayList<>();

	public ProcessContext(final IVulkanContext vulkanContext,
						  EQueueType queueType,
						  boolean resetAllowed,
						  AbstractProcess process)
	{
		super(vulkanContext, queueType, resetAllowed);

		this.process = process;
		this.application = (Application) EcoreUtil.getRootContainer(process);
	}

	public List<ILilyEObject> getAllocationChildren()
	{
		return allocationList;
	}

	public final AbstractProcess getProcess()
	{
		return process;
	}
}
