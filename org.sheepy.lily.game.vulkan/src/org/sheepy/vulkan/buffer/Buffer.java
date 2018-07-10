package org.sheepy.vulkan.buffer;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkBufferCopy;
import org.lwjgl.vulkan.VkBufferCreateInfo;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.lwjgl.vulkan.VkMemoryRequirements;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.device.LogicalDevice;

public class Buffer implements IDescriptor
{
	private LogicalDevice logicalDevice;
	
	protected int stage = -1;
	protected int descriptorType = -1;

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

	public Buffer(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public void load(long size, int usage, int properties)
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

		// System.out.println(Long.toHexString(bufferMemoryId));

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
	
	public void fillWithBuffer(ByteBuffer byteBuffer)
	{
		PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
		vkMapMemory(logicalDevice.getVkDevice(), bufferMemoryId, 0, size, 0, pBuffer);
		long data = pBuffer.get(0);
		MemoryUtil.memCopy(memAddress(byteBuffer), data, byteBuffer.capacity());
		vkUnmapMemory(logicalDevice.getVkDevice(), bufferMemoryId);
		MemoryUtil.memFree(pBuffer);
	}
	
	public void copyToBuffer(ByteBuffer byteBuffer)
	{
		PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
		vkMapMemory(logicalDevice.getVkDevice(), bufferMemoryId, 0, size, 0, pBuffer);
		long data = pBuffer.get(0);
		MemoryUtil.memCopy(data, memAddress(byteBuffer), byteBuffer.capacity());
		vkUnmapMemory(logicalDevice.getVkDevice(), bufferMemoryId);
		MemoryUtil.memFree(pBuffer);
	}

	public static void copyBuffer(VkCommandBuffer vkCommandBuffer,
			long srcBuffer,
			long dstBuffer,
			int size)
	{
		VkBufferCopy.Buffer copyRegion = VkBufferCopy.calloc(1);
		copyRegion.srcOffset(0); // Optional
		copyRegion.dstOffset(0); // Optional
		copyRegion.size(size);
		vkCmdCopyBuffer(vkCommandBuffer, srcBuffer, dstBuffer, copyRegion);
	}
	
	public void configureDescriptor(int stage, int descriptorType)
	{
		this.stage = stage;
		this.descriptorType = descriptorType;
	}
	
	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		if(descriptorType == -1)
			new Exception("Unconfigured descriptor, call configureDescriptor() first.").printStackTrace();
		
		VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(descriptorType);
		res.descriptorCount(1);
		res.stageFlags(stage);
		return res;
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		if(descriptorType == -1)
			new Exception("Unconfigured descriptor, call configureDescriptor() first.").printStackTrace();
		
		VkDescriptorBufferInfo.Buffer bufferInfo = VkDescriptorBufferInfo.callocStack(1, stack);
		bufferInfo.buffer(bufferId);
		bufferInfo.offset(0);
		bufferInfo.range(size);

		VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(descriptorType);
		descriptorWrite.pBufferInfo(bufferInfo);
		descriptorWrite.pImageInfo(null); // Optional
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
	}

	@Override
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		if(descriptorType == -1)
			new Exception("Unconfigured descriptor, call configureDescriptor() first.").printStackTrace();
		
		VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(descriptorType);
		poolSize.descriptorCount(1);
		return poolSize;
	}
	
	
}
