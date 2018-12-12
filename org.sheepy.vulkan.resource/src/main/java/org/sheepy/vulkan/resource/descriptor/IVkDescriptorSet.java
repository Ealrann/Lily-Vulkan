package org.sheepy.vulkan.resource.descriptor;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;

public interface IVkDescriptorSet
{
	void allocate(MemoryStack stack, DescriptorPool pool);
	void free();
	
	long getId();

	long getLayoutId();

	List<IVkDescriptor> getDescriptors();

	void bindDescriptorSet(	AbstractCommandBuffer commandBuffer,
							int bindPoint,
							long pipelineLayoutId);
}
