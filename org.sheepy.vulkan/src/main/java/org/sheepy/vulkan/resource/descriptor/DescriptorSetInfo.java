package org.sheepy.vulkan.resource.descriptor;

import org.sheepy.vulkan.model.DescriptorSet;

public class DescriptorSetInfo
{
	private DescriptorSet descriptorSet;
	private int index;

	public DescriptorSetInfo(DescriptorSet descriptorSet, int index)
	{
		this.descriptorSet = descriptorSet;
		this.index = index;
	}

	public DescriptorSet getDescriptorSet()
	{
		return descriptorSet;
	}

	public int getIndex()
	{
		return index;
	}
}
