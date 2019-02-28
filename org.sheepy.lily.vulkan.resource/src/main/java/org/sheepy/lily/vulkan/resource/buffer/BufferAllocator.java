package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;

public class BufferAllocator
{
	public static GPUBufferBackend allocateGPUBufferAndFill(MemoryStack stack,
															ExecutionContext executionManager,
															long size,
															int usage,
															boolean keepStagingBuffer,
															boolean keptMapped,
															ByteBuffer fillWith)
	{
		var logicalDevice = executionManager.getLogicalDevice();
		var res = allocateGPUBuffer(stack, logicalDevice, size, usage, keepStagingBuffer,
				keptMapped);

		res.pushData(executionManager, fillWith);

		return res;
	}

	public static GPUBufferBackend allocateGPUBuffer(	MemoryStack stack,
														LogicalDevice logicalDevice,
														long size,
														int usage,
														boolean keepStagingBuffer,
														boolean keptMapped)
	{
		var bufferInfo = new BufferInfo(size, usage, keptMapped);
		var res = new GPUBufferBackend(logicalDevice, bufferInfo, keepStagingBuffer);
		res.allocate(stack);
		return res;
	}

	public static CPUBufferBackend allocateCPUBuffer(	MemoryStack stack,
														LogicalDevice logicalDevice,
														long size,
														int usage,
														boolean keptMapped)
	{
		var bufferInfo = new BufferInfo(size, usage, keptMapped);
		var res = new CPUBufferBackend(logicalDevice, bufferInfo, true);
		res.allocate(stack);
		return res;
	}

	public static CPUBufferBackend allocateCPUBufferAndFill(MemoryStack stack,
															LogicalDevice logicalDevice,
															long size,
															int usage,
															boolean keptMapped,
															ByteBuffer fillWith)
	{
		var res = allocateCPUBuffer(stack, logicalDevice, size, usage, keptMapped);
		res.pushData(fillWith);
		return res;
	}
}
