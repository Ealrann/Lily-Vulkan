package org.sheepy.vulkan.process.process;

import org.sheepy.vulkan.common.device.LogicalDeviceContext;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.resource.ResourceManager;

public class ProcessContext extends LogicalDeviceContext
{
	public final ExecutionManager executionManager;
	public final ResourceManager resourceManager;

	public ProcessContext(ExecutionManager executionManager, ResourceManager resourceManager)
	{
		super(executionManager.logicalDevice);

		this.executionManager = executionManager;
		this.resourceManager = resourceManager;
	}
}
