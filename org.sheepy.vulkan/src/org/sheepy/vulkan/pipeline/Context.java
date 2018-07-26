package org.sheepy.vulkan.pipeline;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.resource.ResourceManager;

public class Context extends AllocationNode
{
	public final LogicalDevice logicalDevice;
	public final ResourceManager resourceManager;
	public final CommandPool commandPool;
	public final Configuration configuration;
	public final DescriptorPool descriptorPool;

	public Context(Configuration configuration, CommandPool commandPool,
			ResourceManager resourceManager, DescriptorPool descriptorPool)
	{
		this.logicalDevice = configuration.logicalDevice;
		this.resourceManager = resourceManager;
		this.commandPool = commandPool;
		this.configuration = configuration;
		this.descriptorPool = descriptorPool;
	}

	public VkDevice getVkDevice()
	{
		return logicalDevice.getVkDevice();
	}

}
