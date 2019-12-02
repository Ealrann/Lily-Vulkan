package org.sheepy.lily.vulkan.process.binding;

import java.util.List;

import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

public class BindConfiguration
{
	public final int instance;
	public final List<DescriptorSet> descriptorSets;

	public BindConfiguration(int instance, List<DescriptorSet> descriptorSets)
	{
		this.instance = instance;
		this.descriptorSets = List.copyOf(descriptorSets);
	}
}
