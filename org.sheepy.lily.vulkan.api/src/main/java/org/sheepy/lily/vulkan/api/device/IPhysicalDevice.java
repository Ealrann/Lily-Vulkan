package org.sheepy.lily.vulkan.api.device;

import org.lwjgl.vulkan.VkPhysicalDeviceProperties;

public interface IPhysicalDevice
{
	int findMemoryType(int typeFilter, int properties);

	int findSupportedFormat(int[] candidates, int tiling, int features);
	
	VkPhysicalDeviceProperties getDeviceProperties();
}
