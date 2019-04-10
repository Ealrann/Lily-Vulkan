package org.sheepy.lily.vulkan.api.nativehelper.descriptor;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;

public interface IVkDescriptorSet
{
	void allocate(MemoryStack stack, IAllocationContext context, long poolAddress);
	void free(IAllocationContext context);

	long getId();
	long getLayoutId();

	void fillPoolSizes(VkDescriptorPoolSize.Buffer poolSizes);

	List<IVkDescriptor> getDescriptors();
	int size();

	void updateDescriptorSet(MemoryStack stack);
}
