package org.sheepy.vulkan.descriptor;

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

	int descriptorCount();

	boolean hasChanged();
	void updateDescriptorSet(MemoryStack stack);
}
