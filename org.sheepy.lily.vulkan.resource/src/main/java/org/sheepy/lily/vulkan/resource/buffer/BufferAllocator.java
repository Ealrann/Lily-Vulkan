package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;

public class BufferAllocator
{
	public static GPUBufferBackend allocateGPUBufferAndFill(MemoryStack stack,
															ExecutionContext executionContext,
															long size,
															int usage,
															boolean keepStagingBuffer,
															boolean keptMapped,
															ByteBuffer fillWith)
	{
		var res = allocateGPUBuffer(stack, executionContext, size, usage, keepStagingBuffer,
				keptMapped);

		res.pushData(executionContext, fillWith);

		return res;
	}

	public static GPUBufferBackend allocateGPUBuffer(	MemoryStack stack,
														IAllocationContext context,
														long size,
														int usage,
														boolean keepStagingBuffer,
														boolean keptMapped)
	{
		var bufferInfo = new BufferInfo(size, usage, keptMapped);
		var res = new GPUBufferBackend(bufferInfo, keepStagingBuffer);
		res.allocate(stack, context);
		return res;
	}

	public static CPUBufferBackend allocateCPUBuffer(	MemoryStack stack,
														IAllocationContext context,
														long size,
														int usage,
														boolean keptMapped)
	{
		var bufferInfo = new BufferInfo(size, usage, keptMapped);
		var res = new CPUBufferBackend(bufferInfo, true);
		res.allocate(stack, context);
		return res;
	}

	public static CPUBufferBackend allocateCPUBufferAndFill(MemoryStack stack,
															ExecutionContext executionContext,
															long size,
															int usage,
															boolean keptMapped,
															ByteBuffer fillWith)
	{
		var res = allocateCPUBuffer(stack, executionContext, size, usage, keptMapped);
		res.pushData(executionContext, fillWith);
		return res;
	}
}
