package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.model.resource.impl.BufferImpl;

public class BufferAllocator
{
	public static final int DEVICE_LOCAL = VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT;

	public static final int HOST_VISIBLE = VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT
			| VK_MEMORY_PROPERTY_HOST_COHERENT_BIT;

	public static StandaloneBuffer allocateGPUBufferAndFill(MemoryStack stack,
															ExecutionManager executionManager,
															long size,
															int usage,
															ByteBuffer fillWith)
	{
		final var logicalDevice = executionManager.logicalDevice;
		StandaloneBuffer res = allocateGPUBuffer(stack, logicalDevice, size, usage);

		BufferGPUFiller filler = new BufferGPUFiller(stack, executionManager, res.getId());
		filler.fill(fillWith, size);

		return res;
	}

	public static StandaloneBuffer allocateGPUBuffer(	MemoryStack stack,
														LogicalDevice logicalDevice,
														long size,
														int usage)
	{
		return allocateBuffer(stack, logicalDevice, size, usage, DEVICE_LOCAL);
	}

	public static StandaloneBuffer allocateCPUBuffer(	MemoryStack stack,
														LogicalDevice logicalDevice,
														long size,
														int usage)
	{
		return allocateBuffer(stack, logicalDevice, size, usage, HOST_VISIBLE);
	}

	public static StandaloneBuffer allocateCPUBufferAndFill(MemoryStack stack,
															LogicalDevice logicalDevice,
															long size,
															int usage,
															ByteBuffer fillWith)
	{
		final var res = allocateBuffer(stack, logicalDevice, size, usage, HOST_VISIBLE);
		res.fillWithBuffer(fillWith);

		return res;
	}

	public static StandaloneBuffer allocateBuffer(	MemoryStack stack,
													LogicalDevice logicalDevice,
													long size,
													int usage,
													int properties)
	{
		final Buffer buffer = new BufferImpl();
		buffer.setSize(size);
		buffer.setUsage(usage);
		buffer.setProperties(properties);

		final var res = new StandaloneBuffer(logicalDevice, buffer);
		res.allocate(stack);

		return res;
	}
}
