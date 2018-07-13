package org.sheepy.vulkan.descriptor;

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
