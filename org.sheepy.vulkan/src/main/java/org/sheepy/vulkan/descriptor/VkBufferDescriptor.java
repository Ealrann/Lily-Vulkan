package org.sheepy.vulkan.descriptor;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.util.VkModelUtil;

public class VkBufferDescriptor implements IVkDescriptor
{
	private final long bufferPtr;
	private final long capacity;
	private final int descriptorType;
	private final int shaderStages;

	private boolean hasChanged = false;
	private long offset;

	public VkBufferDescriptor(	long bufferPtr,
								long capacity,
								long offset,
								EDescriptorType descriptorType,
								List<EShaderStage> shaderStages)
	{
		this.bufferPtr = bufferPtr;
		this.capacity = capacity;
		this.offset = offset;
		this.descriptorType = descriptorType.getValue();
		this.shaderStages = VkModelUtil.getEnumeratedFlag(shaderStages);
	}

	@Override
	public void fillPoolSize(VkDescriptorPoolSize poolSize)
	{
		poolSize.type(descriptorType);
		poolSize.descriptorCount(1);
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(descriptorType);
		res.descriptorCount(1);
		res.stageFlags(shaderStages);
		return res;
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		final VkDescriptorBufferInfo.Buffer bufferInfo = allocBufferInfo(stack);

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorType(descriptorType);
		writeDescriptor.pBufferInfo(bufferInfo);
		writeDescriptor.pImageInfo(null);
		writeDescriptor.pTexelBufferView(null);

		hasChanged = false;
	}

	protected VkDescriptorBufferInfo.Buffer allocBufferInfo(MemoryStack stack)
	{
		final var bufferInfo = VkDescriptorBufferInfo.callocStack(1, stack);
		bufferInfo.buffer(bufferPtr);
		bufferInfo.offset(offset);
		bufferInfo.range(capacity);

		return bufferInfo;
	}

	public void updateOffset(long offset)
	{
		this.offset = offset;
		hasChanged = true;
	}

	@Override
	public boolean hasChanged()
	{
		return hasChanged;
	}

	@Override
	public String toString()
	{
		return "VkBufferDescriptor [bufferPtr=" + bufferPtr + ", capacity=" + capacity + ", descriptorType="
				+ descriptorType + ", shaderStages=" + shaderStages + ", hasChanged=" + hasChanged + ", offset="
				+ offset + "]";
	}
}
