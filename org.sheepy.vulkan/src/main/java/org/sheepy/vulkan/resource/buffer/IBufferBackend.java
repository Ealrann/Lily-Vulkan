package org.sheepy.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.execution.IExecutionContext;

public interface IBufferBackend extends IAllocable
{
	@Override
	default boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	long getAddress();

	long getMemoryAddress();

	public long mapMemory(VkDevice vkDevice);

	public void unmapMemory(VkDevice vkDevice);

	void nextInstance();
	long getOffset();

	void pushData(IExecutionContext executionContext, ByteBuffer data);
}
