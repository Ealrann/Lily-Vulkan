package org.sheepy.vulkan.processpool;

import org.sheepy.vulkan.device.LogicalDeviceContext;
import org.sheepy.vulkan.execution.ExecutionManager;
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
