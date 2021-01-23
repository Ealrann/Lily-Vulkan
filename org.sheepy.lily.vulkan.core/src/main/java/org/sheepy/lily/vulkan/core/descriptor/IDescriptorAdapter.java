package org.sheepy.lily.vulkan.core.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.logoce.extender.api.IAdapter;

public interface IDescriptorAdapter extends IAdapter
{
	int sizeInPool();
	VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack);
	default boolean isEmpty()
	{
		return false;
	}
}
