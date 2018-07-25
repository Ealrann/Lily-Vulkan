package org.sheepy.vulkan.descriptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ealrann
 *
 */
@Deprecated
public class BasicDescriptorSetConfiguration implements IDescriptorSetContext
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

	@Override
	public long getLayoutId()
	{
		return 0;
	}
}
