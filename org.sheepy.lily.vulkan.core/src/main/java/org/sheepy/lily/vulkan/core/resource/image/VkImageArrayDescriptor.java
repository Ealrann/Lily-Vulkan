package org.sheepy.lily.vulkan.core.resource.image;

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

public class VkImageArrayDescriptor implements IVkDescriptor
{
	private final int maxSize;
	private final int descriptorType;
	private final int shaderStages;
	private final int imageLayout;

	private long[] imageViewPtrs;
	private boolean changed = true;

	public VkImageArrayDescriptor(	int maxSize,
									EImageLayout imageLayout,
									EDescriptorType descriptorType,
									List<EShaderStage> shaderStages)
	{
		this(maxSize, new long[0], imageLayout, descriptorType, shaderStages);
	}

	public VkImageArrayDescriptor(	int maxSize,
									long[] imageViewPtrs,
									EImageLayout imageLayout,
									EDescriptorType descriptorType,
									List<EShaderStage> shaderStages)
	{
		this.maxSize = maxSize;
		this.imageViewPtrs = imageViewPtrs;
		this.imageLayout = imageLayout != null ? imageLayout.getValue() : 0;
		this.descriptorType = descriptorType.getValue();
		this.shaderStages = VulkanModelUtil.getEnumeratedFlag(shaderStages);
	}

	@Override
	public void fillPoolSize(VkDescriptorPoolSize poolSize)
	{
		poolSize.type(descriptorType);
		poolSize.descriptorCount(maxSize);
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(descriptorType);
		res.descriptorCount(maxSize);
		res.stageFlags(shaderStages);
		return res;
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		final var imageInfos = VkDescriptorImageInfo.callocStack(maxSize, stack);

		for (int i = 0; i < imageViewPtrs.length; i++)
		{
			final var imageInfo = imageInfos.get();
			imageInfo.imageLayout(imageLayout);
			imageInfo.imageView(imageViewPtrs[i]);
		}

		imageInfos.flip();

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.descriptorCount(imageViewPtrs.length);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorType(descriptorType);
		writeDescriptor.pBufferInfo(null);
		writeDescriptor.pImageInfo(imageInfos);
		writeDescriptor.pTexelBufferView(null);

		changed = false;
	}

	@Override
	public boolean isEmpty()
	{
		return imageViewPtrs.length == 0;
	}

	public void updateViewPtrs(long[] viewPtrs)
	{
		if (viewPtrs.length > maxSize)
		{
			throw new IllegalArgumentException("Too many views");
		}

		this.imageViewPtrs = viewPtrs;
		changed = true;
	}

	public long[] getViewPtrs()
	{
		return imageViewPtrs;
	}

	@Override
	public boolean hasChanged()
	{
		return changed;
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
