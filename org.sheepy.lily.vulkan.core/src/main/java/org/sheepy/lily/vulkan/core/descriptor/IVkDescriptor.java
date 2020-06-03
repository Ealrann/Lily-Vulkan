package org.sheepy.lily.vulkan.core.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;

public interface IVkDescriptor
{
	VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack);
	void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor);

	default boolean isEmpty()
	{
		return false;
	}
	default boolean hasChanged()
	{
		return false;
	}
}
