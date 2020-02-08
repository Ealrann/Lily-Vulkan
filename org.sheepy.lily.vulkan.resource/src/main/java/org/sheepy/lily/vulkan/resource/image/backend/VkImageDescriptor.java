package org.sheepy.lily.vulkan.resource.image.backend;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public class VkImageDescriptor implements IVkDescriptor
{
	private final int descriptorType;
	private final int shaderStages;
	private final int imageLayout;

	private long imageViewPtr;
	private long samplerPtr;
	private boolean changed = true;

	public VkImageDescriptor(	long imageViewPtr,
								long samplerPtr,
								EImageLayout imageLayout,
								EDescriptorType descriptorType,
								List<EShaderStage> shaderStages)
	{
		this.imageViewPtr = imageViewPtr;
		this.samplerPtr = samplerPtr;
		this.imageLayout = imageLayout != null ? imageLayout.getValue() : 0;
		this.descriptorType = descriptorType.getValue();
		this.shaderStages = VulkanModelUtil.getEnumeratedFlag(shaderStages);
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
		final var imageInfo = VkDescriptorImageInfo.callocStack(1, stack);
		imageInfo.imageLayout(imageLayout);
		imageInfo.imageView(imageViewPtr);
		imageInfo.sampler(samplerPtr);

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorCount(1);
		writeDescriptor.descriptorType(descriptorType);
		writeDescriptor.pBufferInfo(null);
		writeDescriptor.pImageInfo(imageInfo);
		writeDescriptor.pTexelBufferView(null);

		changed = false;
	}

	public void updateSamplerPtr(long samplerPtr)
	{
		this.samplerPtr = samplerPtr;
		changed = true;
	}

	public void updateViewPtr(long viewPtr)
	{
		this.imageViewPtr = viewPtr;
		changed = true;
	}

	public long getSamplerPtr()
	{
		return samplerPtr;
	}

	@Override
	public boolean hasChanged()
	{
		return changed;
	}

	@Override
	public String toString()
	{
		return "VkImageDescriptor [imageViewAddress="
				+ imageViewPtr
				+ ", samplerAddress="
				+ samplerPtr
				+ ", descriptorType="
				+ descriptorType
				+ ", shaderStages="
				+ shaderStages
				+ ", imageLayout="
				+ imageLayout
				+ "]";
	}
}
