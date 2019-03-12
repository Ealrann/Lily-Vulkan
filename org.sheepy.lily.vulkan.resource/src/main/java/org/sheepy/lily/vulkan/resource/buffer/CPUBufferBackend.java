package org.sheepy.lily.vulkan.resource.buffer;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.engine.IVulkanContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.resource.nativehelper.VkBufferAllocator;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryInfo;

public class CPUBufferBackend implements IBufferBackend
{
	public static final int HOST_VISIBLE = VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT
			| VK_MEMORY_PROPERTY_HOST_COHERENT_BIT;

	public final int properties;
	public final BufferInfo infos;

	private long bufferId;
	private long bufferMemoryId;
	private long memoryMap = -1;

	public CPUBufferBackend(BufferInfo info, boolean coherent)
	{
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
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		var vulkanContext = (IVulkanContext) context;
		var vkDevice = vulkanContext.getVkDevice();

		bufferId = VkBufferAllocator.allocate(stack, vkDevice, infos);

		final var memoryInfo = allocateMemory(stack, vulkanContext.getLogicalDevice());
		bufferMemoryId = memoryInfo.id;

		vkBindBufferMemory(vkDevice, bufferId, bufferMemoryId, 0);
		// System.out.println(Long.toHexString(bufferMemoryId));

		if (infos.keptMapped)
		{
			mapMemory(vkDevice);
		}
	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice)
	{
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, bufferId, properties);
		return VkMemoryAllocator.allocateFromBuffer(stack, allocationInfo);
	}

	@Override
	public void free(IAllocationContext context)
	{
		var vulkanContext = (IVulkanContext) context;
		var vkDevice = vulkanContext.getVkDevice();

		if (memoryMap != -1)
		{
			unmapMemory(vkDevice);
		}

		vkDestroyBuffer(vkDevice, bufferId, null);
		vkFreeMemory(vkDevice, bufferMemoryId, null);

		bufferId = -1;
		bufferMemoryId = -1;
	}

	@Override
	public void pushData(ExecutionContext executionContext, ByteBuffer data)
	{
		var vkDevice = executionContext.getVkDevice();

		mapMemory(vkDevice);
		MemoryUtil.memCopy(memAddress(data), memoryMap, infos.size);

		if (infos.keptMapped == false)
		{
			unmapMemory(vkDevice);
		}
	}

	@Override
	public long mapMemory(VkDevice vkDevice)
	{
		if (memoryMap == -1)
		{
			final PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
			vkMapMemory(vkDevice, bufferMemoryId, 0, infos.size, 0, pBuffer);
			memoryMap = pBuffer.get(0);
			MemoryUtil.memFree(pBuffer);
		}

		return memoryMap;
	}

	@Override
	public void unmapMemory(VkDevice vkDevice)
	{
		if (memoryMap != -1)
		{
			vkUnmapMemory(vkDevice, bufferMemoryId);
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

	public long getMemoryMap()
	{
		return memoryMap;
	}
}
