package org.sheepy.lily.vulkan.process.binding;

import org.sheepy.lily.vulkan.model.binding.EContextIndex;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

import java.util.List;

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
		return switch (type)
				{
					case CONTEXT_INSTANCE -> instance;
					case CONTEXT_INSTANCE_MINUS_ONE -> (instance - 1) % size;
					case CONTEXT_INSTANCE_PLUS_ONE -> (instance + 1) % size;
				};
	}
}
