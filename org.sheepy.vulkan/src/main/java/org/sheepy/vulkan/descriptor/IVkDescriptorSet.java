package org.sheepy.vulkan.descriptor;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.vulkan.allocation.IAllocationContext;

public interface IVkDescriptorSet
{
	void allocate(MemoryStack stack, IAllocationContext context, long poolAddress);
	void free(IAllocationContext context);

	long getId();
	long getLayoutId();

	void fillPoolSizes(VkDescriptorPoolSize.Buffer poolSizes);

	List<IVkDescriptor> getDescriptors();
	int descriptorCount();

	void updateDescriptorSet(MemoryStack stack);
}
