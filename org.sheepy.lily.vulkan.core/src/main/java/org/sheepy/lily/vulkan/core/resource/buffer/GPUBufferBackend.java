package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunk;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunkBuilder;
import org.sheepy.lily.vulkan.core.util.VulkanDebugUtil;

import java.nio.ByteBuffer;

import static org.lwjgl.vulkan.VK10.*;

public final class GPUBufferBackend implements IBufferBackend
{
	private static final String NO_STAGING_ERROR = "Memory mapping for GPUBuffer is only availlable if keepStagingBuffer is true.";

	public static final int DEVICE_LOCAL = VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT;

	private final BufferInfo info;
	private final long address;
	private final CPUBufferBackend cpuBackend;

	private long memoryAddress;
	private MemoryChunk memory;
	private int currentInstance = 0;
	private long currentOffset = 0;

	public GPUBufferBackend(BufferInfo info, long address, CPUBufferBackend cpuBackend)
	{
		this.info = info;
		this.address = address;
		this.cpuBackend = cpuBackend;
	}

	private void bindBufferMemory(VkDevice vkDevice, long memoryPtr, long offset, long size)
	{
		memoryAddress = memoryPtr;
		vkBindBufferMemory(vkDevice, address, memoryAddress, offset);
		// System.out.println(Long.toHexString(bufferMemoryId));
	}

	private void linkMemory(final MemoryChunk memory)
	{
		this.memory = memory;
	}

	@Override
	public void free(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();

		vkDestroyBuffer(vkDevice, address, null);
		if (memory != null) memory.free(context);
		if (cpuBackend != null) cpuBackend.free(context);

		memoryAddress = 0;
	}

	@Override
	public void pushData(ExecutionContext executionContext, ByteBuffer data)
	{
		if (cpuBackend == null)
		{
			final int size = (int) Math.min(data.remaining(), info.size);
			final var bufferFiller = new BufferGPUFiller(executionContext, address);
			bufferFiller.fill(data, currentOffset, size);

			if (VulkanDebugUtil.DEBUG_ENABLED)
			{
				System.err.println(
						"[Warning] Pushing in a non staged GPU Buffer is slow. Don't use it in the main loop.");
			}
		}
		else
		{
			cpuBackend.pushData(executionContext, data);
			pushData(executionContext, cpuBackend);
		}
	}

	public void pushData(ExecutionContext executionContext, CPUBufferBackend stagingBuffer)
	{
		final int size = (int) Math.min(stagingBuffer.info.size, info.size);
		final long bufferPtr = stagingBuffer.getAddress();

		executionContext.execute((context, commandBuffer) -> {
			final var stack = context.stack();
			BufferUtils.copyBuffer(stack,
								   commandBuffer.getVkCommandBuffer(),
								   bufferPtr,
								   0,
								   address,
								   currentOffset,
								   size);
		});
	}

	@Override
	public long mapMemory(VkDevice vkDevice)
	{
		if (cpuBackend == null)
		{
			throwNoStagingError();
		}

		return cpuBackend.mapMemory(vkDevice);
	}

	@Override
	public void unmapMemory(VkDevice vkDevice)
	{
		if (cpuBackend == null)
		{
			throwNoStagingError();
		}

		cpuBackend.unmapMemory(vkDevice);
	}

	private static void throwNoStagingError() throws AssertionError
	{
		throw new AssertionError(NO_STAGING_ERROR);
	}

	public void pushStagging(ExecutionContext executionManager)
	{
		pushData(executionManager, cpuBackend);
	}

	public BufferInfo getInfos()
	{
		return info;
	}

	@Override
	public void nextInstance(VkDevice vkDevice)
	{
		currentInstance++;
		if (currentInstance >= info.instanceCount)
		{
			currentInstance = 0;
		}

		currentOffset = currentInstance * info.getInstanceSize();
	}

	@Override
	public long getInstanceOffset()
	{
		return currentOffset;
	}

	@Override
	public long getInstanceSize()
	{
		return info.getInstanceSize();
	}

	@Override
	public long getAddress()
	{
		return address;
	}

	@Override
	public long getMemoryAddress()
	{
		return memoryAddress;
	}

	@Override
	public void flush(MemoryStack stack, VkDevice vkDevice)
	{
		// Nothing to flush for device local buffer
	}

	@Override
	public void invalidate(MemoryStack stack, VkDevice vkDevice)
	{
		// Nothing to invalidate for device local buffer
	}

	public static final class Builder
	{
		private final BufferInfo info;
		private final boolean keepStagingBuffer;

		public Builder(BufferInfo info, boolean keepStagingBuffer)
		{
			this.info = info;
			this.keepStagingBuffer = keepStagingBuffer;
		}

		public GPUBufferBackend build(ExecutionContext context)
		{
			final var memoryBuilder = new MemoryChunkBuilder(context, DEVICE_LOCAL);
			final var res = build(context, memoryBuilder);
			final var memory = memoryBuilder.build();
			memory.allocate(context);
			res.linkMemory(memory);
			return res;
		}

		public GPUBufferBackend build(ExecutionContext context, MemoryChunkBuilder memoryBuilder)
		{
			info.computeAlignment(context.getPhysicalDevice());
			final long address = VkBufferAllocator.allocate(context, info);
			final var cpuBuffer = keepStagingBuffer ? createCpuBuffer(context) : null;
			final var backend = new GPUBufferBackend(info, address, cpuBuffer);
			memoryBuilder.registerBuffer(address, backend::bindBufferMemory);
			return backend;
		}

		private CPUBufferBackend createCpuBuffer(ExecutionContext context)
		{
			final BufferInfo stagingInfo = new BufferInfo(info.size, VK_BUFFER_USAGE_TRANSFER_SRC_BIT, info.keptMapped);
			final var bufferBuilder = new CPUBufferBackend.Builder(stagingInfo, true);
			return bufferBuilder.build(context);
		}
	}
}
