package org.sheepy.vulkan.resource.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.adapter.IVulkanAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.model.resource.IDescriptor;

public interface IDescriptorAdapter extends IVulkanAdapter
{
	VkDescriptorPoolSize allocPoolSize(MemoryStack stack);

	VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack);

	VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack);

	default boolean isDirty()
	{
		return false;
	}

	public static IDescriptorAdapter adapt(IDescriptor object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, IDescriptorAdapter.class);
	}
}
