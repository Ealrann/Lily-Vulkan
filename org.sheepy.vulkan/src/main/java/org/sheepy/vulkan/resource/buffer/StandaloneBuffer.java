package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.model.Buffer;
import org.sheepy.vulkan.nativehelper.VkBufferAllocator;
import org.sheepy.vulkan.nativehelper.VkMemoryAllocator;
import org.sheepy.vulkan.nativehelper.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.vulkan.nativehelper.VkMemoryAllocator.MemoryInfo;

public class StandaloneBuffer
{
	private final LogicalDevice logicalDevice;

	private final Buffer buffer;
	
	private long bufferId;
	private long bufferMemoryId;

	public StandaloneBuffer(LogicalDevice logicalDevice, Buffer buffer)
	{
		this.logicalDevice = logicalDevice;
		this.buffer = buffer;
	}

	public void allocate(MemoryStack stack)
	{
		bufferId = VkBufferAllocator.allocate(stack, logicalDevice.getVkDevice(), buffer);

		final var memoryInfo = allocateMemory(stack, logicalDevice, buffer);
		bufferMemoryId = memoryInfo.id;

		vkBindBufferMemory(logicalDevice.getVkDevice(), bufferId, bufferMemoryId, 0);

		// System.out.println(Long.toHexString(bufferMemoryId));

	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice, Buffer buffer)
	{
		final var properties = buffer.getProperties();
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
		vkMapMemory(device, bufferMemoryId, 0, buffer.getSize(), 0, pBuffer);
		final long data = pBuffer.get(0);
		MemoryUtil.memCopy(memAddress(byteBuffer), data, buffer.getSize());
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
