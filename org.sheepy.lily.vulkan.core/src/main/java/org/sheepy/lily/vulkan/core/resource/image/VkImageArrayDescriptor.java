package org.sheepy.lily.vulkan.core.resource.image;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

import java.util.Arrays;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

public class VkImageArrayDescriptor implements IVkDescriptor
{
	private final long[] imageViewPtrs;
	private final int descriptorType;
	private final int imageLayout;

	public VkImageArrayDescriptor(long[] imageViewPtrs, EImageLayout imageLayout, EDescriptorType descriptorType)
	{
		this.imageViewPtrs = imageViewPtrs;
		this.imageLayout = imageLayout != null ? imageLayout.getValue() : 0;
		this.descriptorType = descriptorType.getValue();
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
		writeDescriptor.descriptorCount(imageViewPtrs.length);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorType(descriptorType);
		writeDescriptor.pBufferInfo(null);
		writeDescriptor.pImageInfo(imageInfos);
		writeDescriptor.pTexelBufferView(null);
	}

	@Override
	public boolean isEmpty()
	{
		return imageViewPtrs.length == 0;
	}

	public long[] getViewPtrs()
	{
		return imageViewPtrs;
	}

	@Override
	public String toString()
	{
		return "VkImageArrayDescriptor{" + "imageViewPtrs=" + Arrays.toString(imageViewPtrs) + ", descriptorType=" + descriptorType + ", imageLayout=" + imageLayout + '}';
	}
}
