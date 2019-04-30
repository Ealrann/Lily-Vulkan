package org.sheepy.vulkan.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;

public interface IVkDescriptor
{
	void fillPoolSize(VkDescriptorPoolSize poolSize);
	VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack);
	void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor);

	default void update()
	{}
	default boolean hasChanged()
	{
		return false;
	}

}
