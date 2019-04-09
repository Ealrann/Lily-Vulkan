package org.sheepy.lily.vulkan.api.nativehelper.resource;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
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
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		final VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(type.getValue());
		poolSize.descriptorCount(1);
		return poolSize;
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
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		final VkDescriptorBufferInfo.Buffer bufferInfo = allocBufferInfo(stack);

		final VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(type.getValue());
		descriptorWrite.pBufferInfo(bufferInfo);
		descriptorWrite.pImageInfo(null);
		descriptorWrite.pTexelBufferView(null);
		return descriptorWrite;
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
