package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.vulkan.core.resource.IVulkanBufferAllocation;
import org.sheepy.lily.vulkan.model.resource.IBuffer;

import java.nio.ByteBuffer;

public interface IBufferAllocation extends IVulkanBufferAllocation
{
	boolean needPush();
	void fillData(ByteBuffer buffer);

	static IBufferAllocation adapt(IBuffer bufferObject)
	{
		return bufferObject.adapt(IBufferAllocation.class);
	}
}
