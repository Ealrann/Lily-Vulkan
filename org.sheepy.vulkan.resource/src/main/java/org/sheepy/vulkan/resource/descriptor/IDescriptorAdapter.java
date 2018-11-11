package org.sheepy.vulkan.resource.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
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

	static IDescriptorAdapter adapt(IDescriptor object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IDescriptorAdapter.class);
	}
}
