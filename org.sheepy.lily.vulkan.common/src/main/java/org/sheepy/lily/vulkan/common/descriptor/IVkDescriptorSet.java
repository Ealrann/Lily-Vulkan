package org.sheepy.lily.vulkan.common.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;

public interface IVkDescriptorSet
{
	void allocate(ExecutionContext context, long poolAddress);
	void free(ExecutionContext context);

	long getId();
	long getLayoutId();

	void fillPoolSizes(VkDescriptorPoolSize.Buffer poolSizes);

	int descriptorCount();

	void prepare();
	boolean hasChanged();
	void updateDescriptorSet(MemoryStack stack);
}
