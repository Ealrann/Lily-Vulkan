package org.sheepy.lily.vulkan.core.resource.memory;

import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.resource.IVulkanResourcePointer;

import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public final record Memory(Info info, long ptr, List<BoundResource<?>> resources)
{
	public void free(IVulkanContext context)
	{
		vkFreeMemory(context.getVkDevice(), ptr, null);
		if (DebugUtil.DEBUG_ENABLED) IVulkanDebugService.INSTANCE.remove(ptr);
	}

	public record BoundResource<T extends IVulkanResourcePointer>(T vkResource, long size)
	{}

	public record Info(boolean hostVisible, boolean coherent)
	{
		public int propertyFlag()
		{
			if (hostVisible() == false)
			{
				return VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT;
			}
			else
			{
				return VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | (coherent() ? VK_MEMORY_PROPERTY_HOST_COHERENT_BIT : 0);
			}
		}
	}
}
