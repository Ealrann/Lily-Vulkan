package org.sheepy.lily.vulkan.core.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;

public interface IDescriptorSetAllocation extends IAllocation
{
	void allocate(ExecutionContext context, long poolAddress);
	void free(ExecutionContext context);

	long getPtr();
	long getLayoutPtr();

	void fillPoolSizes(VkDescriptorPoolSize.Buffer poolSizes);

	int descriptorCount();

	void prepare();
	boolean hasChanged();
	void updateDescriptorSet(MemoryStack stack);
}
