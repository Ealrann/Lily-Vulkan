package org.sheepy.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import java.util.Collection;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.util.VkModelUtil;

public class VkImageArrayDescriptor implements IVkDescriptor
{
	private final long[] imageViewPtrs;
	private final int descriptorType;
	private final int shaderStages;
	private final int imageLayout;

	public VkImageArrayDescriptor(	long[] imageViewPtrs,
									EImageLayout imageLayout,
									EDescriptorType descriptorType,
									Collection<EShaderStage> shaderStages)
	{
		this.imageViewPtrs = imageViewPtrs;
		this.imageLayout = imageLayout != null ? imageLayout.getValue() : 0;
		this.descriptorType = descriptorType.getValue();
		this.shaderStages = VkModelUtil.getEnumeratedFlag(shaderStages);
	}

	@Override
	public void fillPoolSize(VkDescriptorPoolSize poolSize)
	{
		poolSize.type(descriptorType);
		poolSize.descriptorCount(imageViewPtrs.length);
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(descriptorType);
		res.descriptorCount(imageViewPtrs.length);
		res.stageFlags(shaderStages);
		return res;
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		final var imageInfos = VkDescriptorImageInfo.callocStack(imageViewPtrs.length, stack);

		for (int i = 0; i < imageViewPtrs.length; i++)
		{
			final var imageInfo = imageInfos.get();
			imageInfo.imageLayout(imageLayout);
			imageInfo.imageView(imageViewPtrs[i]);
		}
		imageInfos.flip();

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorType(descriptorType);
		writeDescriptor.pBufferInfo(null);
		writeDescriptor.pImageInfo(imageInfos);
		writeDescriptor.pTexelBufferView(null);
	}

	@Override
	public String toString()
	{
		return "VkImageArrayDescriptor [imageViewAddress="
				+ imageViewPtrs
				+ ", descriptorType="
				+ descriptorType
				+ ", shaderStages="
				+ shaderStages
				+ ", imageLayout="
				+ imageLayout
				+ "]";
	}
}
