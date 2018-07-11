package org.sheepy.vulkan.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;

public interface IDescriptor
{
	VkDescriptorPoolSize allocPoolSize(MemoryStack stack);
	
	VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack);
	
	VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack);
}
