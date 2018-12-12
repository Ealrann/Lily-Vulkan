package org.sheepy.vulkan.process.process;

import org.sheepy.vulkan.common.device.LogicalDeviceContext;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.resource.descriptor.DescriptorPool;

public class ProcessContext extends LogicalDeviceContext
{
	public final ExecutionManager executionManager;
	public final DescriptorPool descriptorPool;

	public ProcessContext(ExecutionManager executionManager, DescriptorPool descriptorPool)
	{
		super(executionManager.logicalDevice);

		this.executionManager = executionManager;
		this.descriptorPool = descriptorPool;
	}
}
