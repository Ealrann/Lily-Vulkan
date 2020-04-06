package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunk;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunkBuilder;

import java.nio.ByteBuffer;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.*;

public final class CPUBufferBackend implements IBufferBackend
{
	public static final int HOST_VISIBLE = VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT;

	public final int properties;
	public final BufferInfo info;
	public final boolean coherent;

	private long address = -1;
	private long memoryAddress;
	private MemoryChunk memory;
	private long memoryMap = -1;
	private int currentInstance = 0;
	private long currentOffset = 0;

	private VkDevice vkDevice;

	public CPUBufferBackend(BufferInfo info, boolean coherent)
	{
		this.info = info;
		this.coherent = coherent;

		properties = createPropertyMask(coherent);
	}

	private static int createPropertyMask(boolean coherent)
	{
		int properties = VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT;
		if (coherent)
		{
			properties |= VK_MEMORY_PROPERTY_HOST_COHERENT_BIT;
		}
		return properties;
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
		vkDevice = context.getVkDevice();

		info.computeAlignment(context.getPhysicalDevice());
		address = VkBufferAllocator.allocate(context, info);

		memoryBuilder.registerBuffer(address, (memoryPtr, offset, memorySize) -> {
			memoryAddress = memoryPtr;

			vkBindBufferMemory(vkDevice, address, memoryAddress, offset);
			// System.out.println(Long.toHexString(bufferMemoryId));

			if (info.keptMapped)
			{
				mapMemory();
			}
		});
	}

	@Override
	public void free(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();

		if (memoryMap != -1)
		{
			unmapMemory();
		}

		vkDestroyBuffer(vkDevice, address, null);
		if (memory != null) memory.free(context);

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

		mapMemory();
		MemoryUtil.memCopy(memAddress(data), memoryMap, info.size);

		if (info.keptMapped == false)
		{
			unmapMemory();
		}
	}

	@Override
	public long mapMemory()
	{
		if (memoryMap == -1)
		{
			final PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
			vkMapMemory(vkDevice, memoryAddress, currentOffset, info.getInstanceSize(), 0, pBuffer);
			memoryMap = pBuffer.get(0);
			MemoryUtil.memFree(pBuffer);
		}

		return memoryMap;
	}

	@Override
	public void unmapMemory()
	{
		if (memoryMap != -1)
		{
			vkUnmapMemory(vkDevice, memoryAddress);
			memoryMap = -1;
		}
	}

	@Override
	public void nextInstance()
	{
		final int newInstance = (currentInstance + 1) % info.instanceCount;

		if (newInstance != currentInstance)
		{
			final boolean wasMapped = memoryMap != -1;

			if (wasMapped)
			{
				unmapMemory();
			}

			currentInstance = newInstance;

			currentOffset = getOffset(currentInstance);

			if (wasMapped)
			{
				mapMemory();
			}
		}
	}

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	@Override
	public void flush(MemoryStack stack, LogicalDevice logicalDevice)
	{
		if (coherent == false)
		{
			BufferUtils.flush(stack, logicalDevice, memoryAddress, VK_WHOLE_SIZE, currentOffset);
		}
	}

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	public void flush(MemoryStack stack, LogicalDevice logicalDevice, int instance)
	{
		if (coherent == false)
		{
			final long size = info.getInstanceSize();
			final long offset = getOffset(instance);
			BufferUtils.flush(stack, logicalDevice, memoryAddress, size, offset);
		}
	}

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	@Override
	public void invalidate(MemoryStack stack, LogicalDevice logicalDevice)
	{
		if (coherent == false)
		{
			BufferUtils.invalidate(stack, logicalDevice, memoryAddress, VK_WHOLE_SIZE, currentOffset);
		}
	}

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @apiNote Only required for non-coherent memory
	 */
	public void invalidate(MemoryStack stack, LogicalDevice logicalDevice, int instance)
	{
		if (coherent == false)
		{
			final long size = info.getInstanceSize();
			final long offset = getOffset(instance);
			BufferUtils.invalidate(stack, logicalDevice, memoryAddress, size, offset);
		}
	}

	private long getOffset(int instance)
	{
		return instance * info.getInstanceSize();
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

	public BufferInfo getInfos()
	{
		return info;
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

	public long getMemoryMap()
	{
		return memoryMap;
	}

	@Override
	public int getProperties()
	{
		return properties;
	}

	public int getCurrentInstance()
	{
		return currentInstance;
	}
}
