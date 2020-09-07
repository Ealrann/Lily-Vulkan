package org.sheepy.lily.vulkan.core.resource.image;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

import java.util.Arrays;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

public final class VkImageDescriptor implements IVkDescriptor
{
	private final long[] imageViewPtrs;
	private final long samplerPtr;
	private final int descriptorType;
	private final int descriptorCount;
	private final int imageLayout;

	public VkImageDescriptor(long[] imageViewPtrs,
							 long samplerPtr,
							 EImageLayout imageLayout,
							 EDescriptorType descriptorType)
	{
		this.imageViewPtrs = imageViewPtrs;
		this.samplerPtr = samplerPtr;
		this.imageLayout = imageLayout != null ? imageLayout.getValue() : 0;
		this.descriptorType = descriptorType.getValue();

		final int viewCount = imageViewPtrs != null ? imageViewPtrs.length : 0;
		final int samplerCount = samplerPtr != 0 ? 1 : 0;
		descriptorCount = Math.max(viewCount, samplerCount);
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		final var imageInfos = VkDescriptorImageInfo.callocStack(descriptorCount, stack);
		for (int i = 0; i < descriptorCount; i++)
		{
			final var viewPtr = i < imageViewPtrs.length ? imageViewPtrs[i] : 0;
			final var imageInfo = imageInfos.get();
			imageInfo.imageLayout(imageLayout);
			imageInfo.imageView(viewPtr);
			imageInfo.sampler(samplerPtr);
		}
		imageInfos.flip();

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorCount(descriptorCount);
		writeDescriptor.descriptorType(descriptorType);
		writeDescriptor.pBufferInfo(null);
		writeDescriptor.pImageInfo(imageInfos);
		writeDescriptor.pTexelBufferView(null);
	}

	@Override
	public boolean isEmpty()
	{
		return descriptorCount == 0;
	}

	@Override
	public String toString()
	{
		return "VkImageDescriptor [imageViewPtrs=" + Arrays.toString(imageViewPtrs) + ", samplerAddress=" + samplerPtr + ", descriptorType=" + descriptorType + ", imageLayout=" + imageLayout + "]";
	}
}
