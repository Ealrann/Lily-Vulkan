package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.memory.VkMemoryAllocator;
import org.sheepy.vulkan.resource.memory.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.vulkan.resource.memory.VkMemoryAllocator.MemoryInfo;

public class CPUBufferBackend implements IBufferBackend
{
	public static final int HOST_VISIBLE = VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT
			| VK_MEMORY_PROPERTY_HOST_COHERENT_BIT;

	public final int properties;
	public final BufferInfo info;

	private long address = -1;
	private long memoryAddress;
	private long memoryMap = -1;
	private int currentInstance = 0;
	private long currentOffset = 0;

	private VkDevice vkDevice;

	public CPUBufferBackend(BufferInfo info, boolean coherent)
	{
		this.info = info;

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
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		vkDevice = context.getVkDevice();

		info.computeAlignment(context.getPhysicalDevice());
		address = VkBufferAllocator.allocate(stack, vkDevice, info);

		final var memoryInfo = allocateMemory(stack, context.getLogicalDevice());
		memoryAddress = memoryInfo.id;

		vkBindBufferMemory(vkDevice, address, memoryAddress, 0);
		// System.out.println(Long.toHexString(bufferMemoryId));

		if (info.keptMapped)
		{
			mapMemory();
		}
	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice)
	{
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, address, properties);
		return VkMemoryAllocator.allocateFromBuffer(stack, allocationInfo);
	}

	@Override
	public void free(IExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();

		if (memoryMap != -1)
		{
			unmapMemory();
		}

		vkDestroyBuffer(vkDevice, address, null);
		vkFreeMemory(vkDevice, memoryAddress, null);

		address = -1;
		memoryAddress = -1;
	}

	@Override
	public void pushData(IExecutionContext executionContext, ByteBuffer data)
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
		final boolean wasMapped = memoryMap != -1;

		if (wasMapped)
		{
			unmapMemory();
		}

		currentInstance++;
		if (currentInstance >= info.instanceCount)
		{
			currentInstance = 0;
		}

		currentOffset = currentInstance * info.getInstanceSize();

		if (wasMapped)
		{
			mapMemory();
		}
	}

	public void flush(LogicalDevice logicalDevice)
	{
		BufferUtils.flush(logicalDevice, memoryAddress, VK_WHOLE_SIZE, currentOffset);
	}

	public void invalidate(LogicalDevice logicalDevice)
	{
		BufferUtils.invalidate(logicalDevice, memoryAddress, VK_WHOLE_SIZE, currentOffset);
	}

	@Override
	public long getOffset()
	{
		return currentOffset;
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
}
