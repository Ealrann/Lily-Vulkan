package org.sheepy.lily.vulkan.api.resource;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.nativehelper.resource.IVkDescriptor;

public interface IVkDescriptorSet
{
	void allocate(MemoryStack stack, IAllocationContext context, long poolAddress);

	void free(IAllocationContext context);

	long getId();

	long getLayoutId();

	List<IVkDescriptor> getDescriptors();
}
