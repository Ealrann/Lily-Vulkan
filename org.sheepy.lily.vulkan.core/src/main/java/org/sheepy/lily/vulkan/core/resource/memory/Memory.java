package org.sheepy.lily.vulkan.core.resource.memory;

import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;

import java.util.List;

import static org.lwjgl.vulkan.VK10.vkFreeMemory;

public final record Memory(Info info, long ptr, List<BoundResource> resources)
{
	public void free(IVulkanContext context)
	{
		vkFreeMemory(context.getVkDevice(), ptr, null);
		if (DebugUtil.DEBUG_ENABLED) IVulkanDebugService.INSTANCE.remove(ptr);
	}

	public record BoundResource(long ptr, long size)
	{
	}

	public record Info(boolean hostVisible, boolean coherent)
	{
	}
}
