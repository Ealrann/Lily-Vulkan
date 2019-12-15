package org.sheepy.lily.vulkan.process.binding;

import java.util.List;

import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

public final class BindConfiguration
{
	public final int instance;
	public final int size;
	public final List<DescriptorSet> descriptorSets;

	public BindConfiguration(int instance, List<DescriptorSet> descriptorSets)
	{
		this.instance = instance;
		this.descriptorSets = List.copyOf(descriptorSets);
		this.size = descriptorSets.size();
	}

	public BindConfiguration(int instance, int size)
	{
		this.instance = instance;
		this.descriptorSets = List.of();
		this.size = size;
	}
}
