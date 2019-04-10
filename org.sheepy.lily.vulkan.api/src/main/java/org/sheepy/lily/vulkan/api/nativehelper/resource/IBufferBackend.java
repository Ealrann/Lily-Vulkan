package org.sheepy.lily.vulkan.api.nativehelper.resource;

import java.nio.ByteBuffer;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;

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
