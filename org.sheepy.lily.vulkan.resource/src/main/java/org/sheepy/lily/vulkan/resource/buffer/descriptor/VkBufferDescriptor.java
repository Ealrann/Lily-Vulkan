package org.sheepy.lily.vulkan.resource.buffer.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

public class VkBufferDescriptor implements IVkDescriptor
{
	private final long bufferPtr;
	private final long range;
	private final long offset;
	private final int descriptorType;

	public VkBufferDescriptor(long bufferPtr, long size, long offset, EDescriptorType descriptorType)
	{
		this.bufferPtr = bufferPtr;
		this.range = size;
		this.offset = offset;
		this.descriptorType = descriptorType.getValue();
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		final var bufferInfo = allocBufferInfo(stack);

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.descriptorCount(1);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorType(descriptorType);
		writeDescriptor.pBufferInfo(bufferInfo);
		writeDescriptor.pImageInfo(null);
		writeDescriptor.pTexelBufferView(null);
	}

	protected VkDescriptorBufferInfo.Buffer allocBufferInfo(MemoryStack stack)
	{
		final var bufferInfo = VkDescriptorBufferInfo.calloc(1, stack);
		bufferInfo.buffer(bufferPtr);
		bufferInfo.offset(offset);
		bufferInfo.range(range);

		return bufferInfo;
	}

	@Override
	public String toString()
	{
		return "VkBufferDescriptor [bufferPtr=" + bufferPtr + ", capacity=" + range + ", descriptorType=" + descriptorType + ", offset=" + offset + "]";
	}
}
