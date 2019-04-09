package org.sheepy.lily.vulkan.api.nativehelper.resource;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;

public interface IVkDescriptor
{
	VkDescriptorPoolSize allocPoolSize(MemoryStack stack);

	VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack);

	VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack);

	default boolean isDirty()
	{
		return false;
	}
}
