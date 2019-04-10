package org.sheepy.lily.vulkan.api.nativehelper.descriptor;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.vulkan.api.nativehelper.resource.IBufferBackend;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;

public class VkDescriptor implements IVkDescriptor
{
	private final IBufferBackend buffer;
	private final long offset;
	private final long capacity;
	private final EDescriptorType type;
	private final List<EShaderStage> stages;

	public VkDescriptor(IBufferBackend buffer,
						long capacity,
						long offset,
						EDescriptorType type,
						List<EShaderStage> stages)
	{
		this.buffer = buffer;
		this.capacity = capacity;
		this.offset = offset;
		this.type = type;
		this.stages = stages;
	}

	@Override
	public void fillPoolSize(VkDescriptorPoolSize poolSize)
	{
		poolSize.type(type.getValue());
		poolSize.descriptorCount(1);
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final int stageFlags = VulkanModelUtil.getEnumeratedFlag(stages);

		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(type.getValue());
		res.descriptorCount(1);
		res.stageFlags(stageFlags);
		return res;
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		final VkDescriptorBufferInfo.Buffer bufferInfo = allocBufferInfo(stack);

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorType(type.getValue());
		writeDescriptor.pBufferInfo(bufferInfo);
		writeDescriptor.pImageInfo(null);
		writeDescriptor.pTexelBufferView(null);
	}

	protected VkDescriptorBufferInfo.Buffer allocBufferInfo(MemoryStack stack)
	{
		final var bufferInfo = VkDescriptorBufferInfo.callocStack(1, stack);
		bufferInfo.buffer(buffer.getAddress());
		bufferInfo.offset(offset);
		bufferInfo.range(capacity);

		return bufferInfo;
	}
}
