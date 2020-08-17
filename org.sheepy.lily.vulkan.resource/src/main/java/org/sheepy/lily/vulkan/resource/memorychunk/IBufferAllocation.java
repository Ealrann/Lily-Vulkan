package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.vulkan.core.resource.buffer.IVulkanBufferAllocation;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;

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
