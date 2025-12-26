package org.sheepy.lily.vulkan.api.debug;

import java.util.ServiceLoader;

public interface IVulkanDebugService
{
	void register(long ptr, String name);
	void remove(long ptr);
	String get(long ptr);

	IVulkanDebugService INSTANCE = ServiceLoader.load(IVulkanDebugService.class).findFirst().orElse(null);
}
