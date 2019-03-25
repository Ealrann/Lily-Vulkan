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

	private long address = -1;
	private long memoryAddress;
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
		final var vulkanContext = (IVulkanContext) context;
		final var vkDevice = vulkanContext.getVkDevice();

		address = VkBufferAllocator.allocate(stack, vkDevice, infos);

		final var memoryInfo = allocateMemory(stack, vulkanContext.getLogicalDevice());
		memoryAddress = memoryInfo.id;

		vkBindBufferMemory(vkDevice, address, memoryAddress, 0);
		// System.out.println(Long.toHexString(bufferMemoryId));

		if (infos.keptMapped)
		{
			mapMemory(vkDevice);
		}
	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice)
	{
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, address, properties);
		return VkMemoryAllocator.allocateFromBuffer(stack, allocationInfo);
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var vulkanContext = (IVulkanContext) context;
		final var vkDevice = vulkanContext.getVkDevice();

		if (memoryMap != -1)
		{
			unmapMemory(vkDevice);
		}

		vkDestroyBuffer(vkDevice, address, null);
		vkFreeMemory(vkDevice, memoryAddress, null);

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

		final var vkDevice = executionContext.getVkDevice();

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
			vkMapMemory(vkDevice, memoryAddress, 0, infos.size, 0, pBuffer);
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
			vkUnmapMemory(vkDevice, memoryAddress);
			memoryMap = -1;
		}
	}

	public BufferInfo getInfos()
	{
		return infos;
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
