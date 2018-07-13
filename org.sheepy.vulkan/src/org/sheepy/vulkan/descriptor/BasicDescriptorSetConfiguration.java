package org.sheepy.vulkan.descriptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ealrann
 *
 */
public class BasicDescriptorSetConfiguration implements IDescriptorSetConfiguration
{
	private List<IDescriptor> descriptors = new ArrayList<>();

	public void add(IDescriptor descriptor)
	{
		descriptors.add(descriptor);
	}

	public void addAll(Collection<IDescriptor> descriptors)
	{
		this.descriptors.addAll(descriptors);
	}

	@Override
	public List<IDescriptor> getDescriptors()
	{
		return descriptors;
	}
}
