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
import org.lwjgl.vulkan.VkMappedMemoryRange;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.lwjgl.vulkan.VkMemoryRequirements;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.device.LogicalDevice;

public class Buffer implements IDescriptor, IAllocable
{
	private LogicalDevice logicalDevice;
	private long size;
	private int usage;
	private int properties;

	protected int stage = -1;
	protected int descriptorType = -1;

	private long bufferId;
	private long bufferMemoryId;
	
	private boolean allocated = false;

	public Buffer(LogicalDevice logicalDevice, int usage, int properties)
	{
		this(logicalDevice, -1, usage, properties);
	}

	public Buffer(LogicalDevice logicalDevice, long size, int usage, int properties)
	{
		this.logicalDevice = logicalDevice;
		this.size = size;
		this.usage = usage;
		this.properties = properties;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		allocate();
	}
	
	public void allocate()
	{
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
		
		allocated = true;
	}

	@Override
	public void free()
	{
		vkDestroyBuffer(logicalDevice.getVkDevice(), bufferId, null);
		vkFreeMemory(logicalDevice.getVkDevice(), bufferMemoryId, null);
		
		allocated = false;
	}
	
	public boolean isAllocated()
	{
		return allocated;
	}
	
	public void setSize(long size)
	{
		if(allocated)
		{
			throw new AssertionError("Impossible to change the size, this buffer is already allocated");
		}
		
		this.size = size;
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
		MemoryUtil.memCopy(memAddress(byteBuffer), data, size);
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


	public int flush()
	{
		return flush(VK_WHOLE_SIZE, 0);
	}
	
	/** 
	* Flush a memory range of the buffer to make it visible to the device
	*
	* @note Only required for non-coherent memory
	*
	* @param size (Optional) Size of the memory range to flush. Pass VK_WHOLE_SIZE to flush the complete buffer range.
	* @param offset (Optional) Byte offset from beginning
	*
	* @return VkResult of the flush call
	*/
	public int flush(long size, int offset)
	{
		VkMappedMemoryRange.Buffer mappedRange = VkMappedMemoryRange.calloc(1);
		mappedRange.sType(VK_STRUCTURE_TYPE_MAPPED_MEMORY_RANGE);
		mappedRange.memory(bufferMemoryId);
		mappedRange.offset(offset);
		mappedRange.size(size);
		return vkFlushMappedMemoryRanges(logicalDevice.getVkDevice(), mappedRange);
	}

	/**
	* Invalidate a memory range of the buffer to make it visible to the host
	*
	* @note Only required for non-coherent memory
	*
	* @param size (Optional) Size of the memory range to invalidate. Pass VK_WHOLE_SIZE to invalidate the complete buffer range.
	* @param offset (Optional) Byte offset from beginning
	*
	* @return VkResult of the invalidate call
	*/
	public int invalidate(int size, int offset)
	{
		VkMappedMemoryRange.Buffer mappedRange = VkMappedMemoryRange.calloc(1);
		mappedRange.sType(VK_STRUCTURE_TYPE_MAPPED_MEMORY_RANGE);
		mappedRange.memory(bufferMemoryId);
		mappedRange.offset(offset);
		mappedRange.size(size);
		return vkInvalidateMappedMemoryRanges(logicalDevice.getVkDevice(), mappedRange);
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		if (descriptorType == -1)
			new Exception("Unconfigured descriptor, call configureDescriptor() first.")
					.printStackTrace();

		VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(descriptorType);
		res.descriptorCount(getDescriptorCount());
		res.stageFlags(stage);
		return res;
	}

	protected int getDescriptorCount()
	{
		return 1;
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		if (descriptorType == -1)
			new Exception("Unconfigured descriptor, call configureDescriptor() first.")
					.printStackTrace();

		VkDescriptorBufferInfo.Buffer bufferInfo = allocBufferInfo(stack);

		VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(descriptorType);
		descriptorWrite.pBufferInfo(bufferInfo);
		descriptorWrite.pImageInfo(null); // Optional
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
	}
	
	protected VkDescriptorBufferInfo.Buffer allocBufferInfo(MemoryStack stack)
	{
		VkDescriptorBufferInfo.Buffer bufferInfo = VkDescriptorBufferInfo.callocStack(1, stack);
		bufferInfo.buffer(bufferId);
		bufferInfo.offset(0);
		bufferInfo.range(size);
		
		return bufferInfo;
	}

	@Override
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		if (descriptorType == -1)
			new Exception("Unconfigured descriptor, call configureDescriptor() first.")
					.printStackTrace();

		VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(descriptorType);
		poolSize.descriptorCount(getDescriptorCount());
		return poolSize;
	}

}
