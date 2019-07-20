package org.sheepy.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public class VkSamplerDescriptor implements IVkDescriptor
{
	private final VkSampler sampler;

	public VkSamplerDescriptor(VkSampler sampler)
	{
		this.sampler = sampler;
	}

	@Override
	public void fillPoolSize(VkDescriptorPoolSize poolSize)
	{
		poolSize.type(EDescriptorType.SAMPLER_VALUE);
		poolSize.descriptorCount(1);
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final var res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(EDescriptorType.SAMPLER_VALUE);
		res.descriptorCount(1);
		res.stageFlags(EShaderStage.FRAGMENT_BIT_VALUE);
		return res;
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		final var imageInfo = VkDescriptorImageInfo.callocStack(1, stack);
		imageInfo.sampler(sampler.getPtr());

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorType(EDescriptorType.SAMPLER_VALUE);
		writeDescriptor.pBufferInfo(null);
		writeDescriptor.pImageInfo(imageInfo);
		writeDescriptor.pTexelBufferView(null);
	}

	@Override
	public String toString()
	{
		return "VkSamplerDescriptor [sampler=" + sampler + "]";
	}
}
