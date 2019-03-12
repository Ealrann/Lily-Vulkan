package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;

public interface IBufferBackend extends IAllocable
{

	@Override
	default boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	long getId();

	long getMemoryId();

	public long mapMemory(VkDevice vkDevice);

	public void unmapMemory(VkDevice vkDevice);

	void pushData(ExecutionContext executionContext, ByteBuffer data);
}
