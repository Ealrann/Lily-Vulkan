package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.vulkan.core.resource.IVulkanBufferAllocation;
import org.sheepy.lily.vulkan.model.resource.IBufferObject;

import java.nio.ByteBuffer;

public interface IBufferObjectAllocationAllocation extends IVulkanBufferAllocation
{
	boolean needPush();
	void fillData(ByteBuffer buffer);

	static IBufferObjectAllocationAllocation adapt(IBufferObject bufferObject)
	{
		return bufferObject.adapt(IBufferObjectAllocationAllocation.class);
	}
}
