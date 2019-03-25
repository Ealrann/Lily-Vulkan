package org.sheepy.lily.vulkan.api.device;

public interface IPhysicalDevice
{
	int findMemoryType(int typeFilter, int properties);

	public int findSupportedFormat(int[] candidates, int tiling, int features);
}
