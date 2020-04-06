package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
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

	public final int properties;

	private final BufferInfo info;

	private long address = -1;
	private long memoryAddress;
	private MemoryChunk memory;
	private int currentInstance = 0;
	private long currentOffset = 0;

	private CPUBufferBackend cpuBackend = null;

	public GPUBufferBackend(BufferInfo info, boolean keepStagingBuffer)
	{
		this.info = info;

		if (keepStagingBuffer)
		{
			final BufferInfo stagingInfo = new BufferInfo(info.size, VK_BUFFER_USAGE_TRANSFER_SRC_BIT, info.keptMapped);
			cpuBackend = new CPUBufferBackend(stagingInfo, true);
		}

		properties = DEVICE_LOCAL;
	}

	@Override
	public void allocate(ExecutionContext context)
	{
		final var memoryBuilder = new MemoryChunkBuilder(context, properties);
		allocate(context, memoryBuilder);
		memory = memoryBuilder.build();
		memory.allocate(context);
	}

	@Override
	public void allocate(ExecutionContext context, MemoryChunkBuilder memoryBuilder)
	{
		final var vkDevice = context.getVkDevice();

		info.computeAlignment(context.getPhysicalDevice());
		address = VkBufferAllocator.allocate(context, info);

		memoryBuilder.registerBuffer(address, (memoryPtr, offset, memorySize) -> {
			memoryAddress = memoryPtr;

			vkBindBufferMemory(vkDevice, address, memoryAddress, offset);
			// System.out.println(Long.toHexString(bufferMemoryId));
		});

		if (cpuBackend != null)
		{
			cpuBackend.allocate(context);
		}
	}

	@Override
	public void free(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();

		vkDestroyBuffer(vkDevice, address, null);
		if (memory != null) memory.free(context);

		if (cpuBackend != null)
		{
			cpuBackend.free(context);
		}

		address = -1;
		memoryAddress = -1;
	}

	@Override
	public void pushData(ExecutionContext executionContext, ByteBuffer data)
	{
		if (address == -1)
		{
			throw new AssertionError("Buffer not allocated");
		}

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
	public long mapMemory()
	{
		if (cpuBackend == null)
		{
			throwNoStagingError();
		}

		return cpuBackend.mapMemory();
	}

	@Override
	public void unmapMemory()
	{
		if (cpuBackend == null)
		{
			throwNoStagingError();
		}

		cpuBackend.unmapMemory();
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
	public void nextInstance()
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
	public int getProperties()
	{
		return properties;
	}

	@Override
	public void flush(MemoryStack stack, LogicalDevice logicalDevice)
	{
		// Nothing to flush for device local buffer
	}

	@Override
	public void invalidate(MemoryStack stack, LogicalDevice logicalDevice)
	{
		// Nothing to invalidate for device local buffer
	}
}
