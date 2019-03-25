package org.sheepy.lily.vulkan.resource.descriptor;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;

public interface IVkDescriptorSet
{
	void allocate(MemoryStack stack, IAllocationContext context, DescriptorPool pool);

	void free(IAllocationContext context);

	long getId();

	long getLayoutId();

	List<IVkDescriptor> getDescriptors();

	void bindDescriptorSet(	VkCommandBuffer commandBuffer,
							int bindPoint,
							long pipelineLayoutId);
}
