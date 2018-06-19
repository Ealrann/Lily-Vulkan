package org.sheepy.lily.game.vulkan.descriptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author ealrann
 *
 */
public class BasicDescriptorSetConfiguration<T extends IDescriptor> implements IDescriptorSetConfiguration<T>
{
	private List<T> descriptors = new ArrayList<>();

	public void add(T descriptor)
	{
		descriptors.add(descriptor);
	}

	public void addAll(Collection<T> descriptors)
	{
		this.descriptors.addAll(descriptors);
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return descriptors.iterator();
	}

	@Override
	public int size()
	{
		return descriptors.size();
	}

}
