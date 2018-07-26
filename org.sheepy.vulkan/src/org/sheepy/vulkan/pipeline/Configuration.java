package org.sheepy.vulkan.pipeline;

import org.sheepy.vulkan.device.LogicalDevice;

public class Configuration
{
	public final LogicalDevice logicalDevice;

	public Configuration(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

}
