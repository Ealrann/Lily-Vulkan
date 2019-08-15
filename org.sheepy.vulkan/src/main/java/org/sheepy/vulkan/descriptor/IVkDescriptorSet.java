package org.sheepy.vulkan.descriptor;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.vulkan.device.IVulkanContext;

public interface IVkDescriptorSet
{
	void allocate(IVulkanContext context, long poolAddress);
	void free(IVulkanContext context);

	long getId();
	long getLayoutId();

	void fillPoolSizes(VkDescriptorPoolSize.Buffer poolSizes);

	List<IVkDescriptor> getDescriptors();
	int descriptorCount();

	void updateDescriptorSet(MemoryStack stack);
}
