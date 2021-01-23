package org.sheepy.lily.vulkan.core.resource;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.core.resource.buffer.IVulkanBufferAllocation;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;

import java.util.List;

public interface IBufferReferenceAllocation extends IAdapter
{
	List<IBuffer> getBuffers(int index);
	List<IVulkanBufferAllocation> getBufferAllocations(int index);
	int getBufferCountPerInstance();
}
