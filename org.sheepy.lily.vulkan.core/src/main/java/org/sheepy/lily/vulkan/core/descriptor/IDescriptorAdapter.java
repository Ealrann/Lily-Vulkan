package org.sheepy.lily.vulkan.core.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.sheepy.lily.core.api.extender.IExtender;

public interface IDescriptorAdapter extends IExtender
{
	int sizeInPool();
	VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack);
	default boolean isEmpty()
	{
		return false;
	}
}
