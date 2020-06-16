package org.sheepy.lily.vulkan.core.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;

public interface IDescriptorSetAllocation extends IExtender
{
	long getPtr();
	long getLayoutPtr();

	void prepare();
	boolean hasChanged();
	void updateDescriptorSet(MemoryStack stack);


	int descriptorCount();
	void fillPoolSizes(VkDescriptorPoolSize.Buffer poolSizes);
}
