package org.sheepy.lily.vulkan.process.process;

import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;

public class ProcessContext extends ExecutionContext implements IProcessContext
{
	public final Application application;
	public final AbstractProcess process;

	public ProcessContext(final IVulkanContext vulkanContext,
						  EQueueType queueType,
						  boolean resetAllowed,
						  AbstractProcess process)
	{
		super(vulkanContext, queueType, resetAllowed);

		this.process = process;
		this.application = ModelUtil.getApplication(process);
	}

	@Override
	public final AbstractProcess getProcess()
	{
		return process;
	}
}

