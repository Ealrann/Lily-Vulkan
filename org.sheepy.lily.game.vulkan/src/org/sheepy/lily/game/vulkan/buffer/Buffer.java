package org.sheepy.lily.game.vulkan.buffer;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkBufferCopy;
import org.lwjgl.vulkan.VkBufferCreateInfo;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.lwjgl.vulkan.VkMemoryRequirements;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.game.vulkan.command.SingleTimeCommand;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class Buffer
{
	private LogicalDevice logicalDevice;

	private long bufferId;
	private long bufferMemoryId;

	private long size;

	/**
	 * Don't forget to free it.
	 * 
	 * @param physicalDevice
	 * @param logicalDevice
	 * @param size
	 * @param usage
	 * @param properties
	 * @return
	 */
	public static Buffer alloc(LogicalDevice logicalDevice, long size, int usage, int properties)
	{
		Buffer buffer = new Buffer(logicalDevice);
		buffer.load(size, usage, properties);

		return buffer;
	}

	private Buffer(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	private void load(long size, int usage, int properties)
	{
		this.size = size;
		VkBufferCreateInfo bufferInfo = VkBufferCreateInfo.calloc();
		bufferInfo.sType(VK_STRUCTURE_TYPE_BUFFER_CREATE_INFO);
		bufferInfo.size(size);
		bufferInfo.usage(usage);
		bufferInfo.sharingMode(VK_SHARING_MODE_EXCLUSIVE);

		long[] aVertexBuffer = new long[1];
		if (vkCreateBuffer(logicalDevice.getVkDevice(), bufferInfo, null,
				aVertexBuffer) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create vertex buffer!");
		}
		bufferId = aVertexBuffer[0];

		VkMemoryRequirements memRequirements = VkMemoryRequirements.calloc();
		vkGetBufferMemoryRequirements(logicalDevice.getVkDevice(), bufferId, memRequirements);

		VkMemoryAllocateInfo allocInfo = VkMemoryAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO);
		allocInfo.allocationSize(memRequirements.size());
		allocInfo.memoryTypeIndex(logicalDevice.getPhysicalDevice()
				.findMemoryType(memRequirements.memoryTypeBits(), properties));

		long[] aVertexBufferMemory = new long[1];
		if (vkAllocateMemory(logicalDevice.getVkDevice(), allocInfo, null,
				aVertexBufferMemory) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to allocate vertex buffer memory!");
		}
		bufferMemoryId = aVertexBufferMemory[0];

		vkBindBufferMemory(logicalDevice.getVkDevice(), bufferId, bufferMemoryId, 0);

//		System.out.println(Long.toHexString(bufferMemoryId));
		
		bufferInfo.free();
		allocInfo.free();
		memRequirements.free();
	}

	public void free()
	{
		vkDestroyBuffer(logicalDevice.getVkDevice(), bufferId, null);
		vkFreeMemory(logicalDevice.getVkDevice(), bufferMemoryId, null);
	}

	public long getId()
	{
		return bufferId;
	}

	public long getMemoryId()
	{
		return bufferMemoryId;
	}

	public long getSize()
	{
		return size;
	}

	public void fillWithBuffer(ByteBuffer byteBuffer, long byteSize)
	{
		PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
		vkMapMemory(logicalDevice.getVkDevice(), bufferMemoryId, 0, byteSize, 0, pBuffer);
		long data = pBuffer.get(0);
		MemoryUtil.memCopy(memAddress(byteBuffer), data, byteBuffer.capacity());
		vkUnmapMemory(logicalDevice.getVkDevice(), bufferMemoryId);
		MemoryUtil.memFree(pBuffer);
	}

	public static void copyBuffer(LogicalDevice logicalDevice,
			VkQueue queue,
			long srcBuffer,
			long dstBuffer,
			int size)
	{
		SingleTimeCommand stc = logicalDevice.getCommandPool().newSingleTimeCommand(queue);
		VkCommandBuffer vkCommandBuffer = stc.start();

		VkBufferCopy.Buffer copyRegion = VkBufferCopy.calloc(1);
		copyRegion.srcOffset(0); // Optional
		copyRegion.dstOffset(0); // Optional
		copyRegion.size(size);
		vkCmdCopyBuffer(vkCommandBuffer, srcBuffer, dstBuffer, copyRegion);

		// Now, we execute the command
		stc.end();
	}
}
