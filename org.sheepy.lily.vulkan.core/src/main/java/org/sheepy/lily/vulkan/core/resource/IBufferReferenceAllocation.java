package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.model.resource.IBuffer;

import java.util.List;

public interface IBufferReferenceAllocation extends IExtender
{
	List<IBuffer> getBuffers(int index);
	List<IVulkanBufferAllocation> getBufferAllocations(int index);
	int getBufferCountPerInstance();
}
