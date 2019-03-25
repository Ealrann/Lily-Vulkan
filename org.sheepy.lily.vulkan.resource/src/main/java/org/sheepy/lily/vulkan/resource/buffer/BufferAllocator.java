package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;

public class BufferAllocator
{
	public static GPUBufferBackend allocateGPUBufferAndFill(MemoryStack stack,
															IExecutionContext executionContext,
															long size,
															int usage,
															boolean keepStagingBuffer,
															boolean keptMapped,
															ByteBuffer fillWith)
	{
		final var res = allocateGPUBuffer(stack, executionContext, size, usage, keepStagingBuffer,
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
		final var bufferInfo = new BufferInfo(size, usage, keptMapped);
		final var res = new GPUBufferBackend(bufferInfo, keepStagingBuffer);
		res.allocate(stack, context);
		return res;
	}

	public static CPUBufferBackend allocateCPUBuffer(	MemoryStack stack,
														IAllocationContext context,
														long size,
														int usage,
														boolean keptMapped)
	{
		final var bufferInfo = new BufferInfo(size, usage, keptMapped);
		final var res = new CPUBufferBackend(bufferInfo, true);
		res.allocate(stack, context);
		return res;
	}

	public static CPUBufferBackend allocateCPUBufferAndFill(MemoryStack stack,
															IExecutionContext executionContext,
															long size,
															int usage,
															boolean keptMapped,
															ByteBuffer fillWith)
	{
		final var res = allocateCPUBuffer(stack, executionContext, size, usage, keptMapped);
		res.pushData(executionContext, fillWith);
		return res;
	}
}
