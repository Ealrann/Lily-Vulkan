package org.sheepy.lily.vulkan.process.binding;

import java.util.List;

import org.sheepy.lily.vulkan.model.binding.EContextIndex;
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

	public int computeInstance(EContextIndex type)
	{
		switch (type)
		{
		case CONTEXT_INSTANCE:
			return instance;
		case CONTEXT_INSTANCE_MINUS_ONE:
			return (instance - 1) % size;
		case CONTEXT_INSTANCE_PLUS_ONE:
			return (instance + 1) % size;
		default:
			return 0;
		}
	}
}
