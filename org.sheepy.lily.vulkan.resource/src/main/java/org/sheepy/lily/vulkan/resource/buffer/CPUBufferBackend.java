package org.sheepy.lily.vulkan.resource.buffer;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.resource.nativehelper.VkBufferAllocator;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryInfo;

public class CPUBufferBackend implements IBufferBackend
{
	public static final int HOST_VISIBLE = VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT
			| VK_MEMORY_PROPERTY_HOST_COHERENT_BIT;

	public final LogicalDevice logicalDevice;
	public final int properties;
	public final BufferInfo infos;

	private long bufferId;
	private long bufferMemoryId;
	private long memoryMap = -1;

	public CPUBufferBackend(LogicalDevice logicalDevice, BufferInfo info, boolean coherent)
	{
		this.logicalDevice = logicalDevice;
		this.infos = info;

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
	public void allocate(MemoryStack stack)
	{
		bufferId = VkBufferAllocator.allocate(stack, logicalDevice.getVkDevice(), infos);

		final var memoryInfo = allocateMemory(stack, logicalDevice);
		bufferMemoryId = memoryInfo.id;

		vkBindBufferMemory(logicalDevice.getVkDevice(), bufferId, bufferMemoryId, 0);
		// System.out.println(Long.toHexString(bufferMemoryId));

		if (infos.keptMapped)
		{
			mapMemory();
		}
	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice)
	{
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, bufferId, properties);
		return VkMemoryAllocator.allocateFromBuffer(stack, allocationInfo);
	}

	@Override
	public void free()
	{
		if (memoryMap != -1)
		{
			unmapMemory();
		}

		vkDestroyBuffer(logicalDevice.getVkDevice(), bufferId, null);
		vkFreeMemory(logicalDevice.getVkDevice(), bufferMemoryId, null);

		bufferId = -1;
		bufferMemoryId = -1;
	}

	@Override
	public void pushData(ExecutionContext executionManager, ByteBuffer data)
	{
		pushData(data);
	}

	public void pushData(ByteBuffer data)
	{
		mapMemory();
		MemoryUtil.memCopy(memAddress(data), memoryMap, infos.size);

		if (infos.keptMapped == false)
		{
			unmapMemory();
		}
	}

	@Override
	public long mapMemory()
	{
		if (memoryMap == -1)
		{
			final var device = logicalDevice.getVkDevice();
			final PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
			vkMapMemory(device, bufferMemoryId, 0, infos.size, 0, pBuffer);
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
			vkUnmapMemory(logicalDevice.getVkDevice(), bufferMemoryId);
			memoryMap = -1;
		}
	}

	public BufferInfo getInfos()
	{
		return infos;
	}

	@Override
	public long getId()
	{
		return bufferId;
	}

	@Override
	public long getMemoryId()
	{
		return bufferMemoryId;
	}
}
