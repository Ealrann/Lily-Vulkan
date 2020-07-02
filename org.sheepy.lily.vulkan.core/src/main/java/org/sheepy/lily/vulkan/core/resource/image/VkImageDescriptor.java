package org.sheepy.lily.vulkan.core.resource.image;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

public class VkImageDescriptor implements IVkDescriptor
{
	private final long imageViewPtr;
	private final long samplerPtr;
	private final int descriptorType;
	private final int imageLayout;

	public VkImageDescriptor(long imageViewPtr,
							 long samplerPtr,
							 EImageLayout imageLayout,
							 EDescriptorType descriptorType,
							 List<EShaderStage> shaderStages)
	{
		this.imageViewPtr = imageViewPtr;
		this.samplerPtr = samplerPtr;
		this.imageLayout = imageLayout != null ? imageLayout.getValue() : 0;
		this.descriptorType = descriptorType.getValue();
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
	}

	@Override
	public String toString()
	{
		return "VkImageDescriptor [imageViewAddress=" + imageViewPtr + ", samplerAddress=" + samplerPtr + ", descriptorType=" + descriptorType + ", imageLayout=" + imageLayout + "]";
	}
}
