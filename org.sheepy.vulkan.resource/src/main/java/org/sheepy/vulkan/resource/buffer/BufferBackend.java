package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.resource.nativehelper.VkBufferAllocator;
import org.sheepy.vulkan.resource.nativehelper.VkMemoryAllocator;
import org.sheepy.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryInfo;

public class BufferBackend
{
	private final LogicalDevice logicalDevice;

	private final BufferInfo bufferInfo;
	
	private long bufferId;
	private long bufferMemoryId;

	public BufferBackend(LogicalDevice logicalDevice, BufferInfo bufferInfo)
	{
		this.logicalDevice = logicalDevice;
		this.bufferInfo = bufferInfo;
	}

	public void allocate(MemoryStack stack)
	{
		bufferId = VkBufferAllocator.allocate(stack, logicalDevice.getVkDevice(), bufferInfo);

		final var memoryInfo = allocateMemory(stack, logicalDevice);
		bufferMemoryId = memoryInfo.id;

		vkBindBufferMemory(logicalDevice.getVkDevice(), bufferId, bufferMemoryId, 0);

		// System.out.println(Long.toHexString(bufferMemoryId));
	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice)
	{
		final var properties = bufferInfo.properties;
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, bufferId, properties);
		return VkMemoryAllocator.allocateFromBuffer(stack, allocationInfo);
	}
	
	public void free()
	{
		vkDestroyBuffer(logicalDevice.getVkDevice(), bufferId, null);
		vkFreeMemory(logicalDevice.getVkDevice(), bufferMemoryId, null);
	}

	public void fillWithBuffer(ByteBuffer byteBuffer)
	{
		final var device = logicalDevice.getVkDevice();
		final PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
		vkMapMemory(device, bufferMemoryId, 0, bufferInfo.size, 0, pBuffer);
		final long data = pBuffer.get(0);
		MemoryUtil.memCopy(memAddress(byteBuffer), data, bufferInfo.size);
		vkUnmapMemory(device, bufferMemoryId);
		MemoryUtil.memFree(pBuffer);
	}

	public long getId()
	{
		return bufferId;
	}

	public long getMemoryId()
	{
		return bufferMemoryId;
	}
}
