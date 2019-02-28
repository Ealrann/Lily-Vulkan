package org.sheepy.lily.vulkan.resource.descriptor;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;

public interface IVkDescriptorSet
{
	void allocate(MemoryStack stack, IAllocationContext context, DescriptorPool pool);

	void free();

	long getId();

	long getLayoutId();

	List<IVkDescriptor> getDescriptors();

	void bindDescriptorSet(	AbstractCommandBuffer commandBuffer,
							int bindPoint,
							long pipelineLayoutId);
}
