package org.sheepy.vulkan.resource;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.device.LogicalDeviceContext;
import org.sheepy.vulkan.model.IProcessPool;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.resource.descriptor.DescriptorPool;

public class ResourceManager extends LogicalDeviceContext implements IBasicAllocable
{
	public final IProcessPool processPool;

	public final DescriptorPool descriptorPool;

	private List<DescriptorSet> descriptorSets = null;

	public ResourceManager(LogicalDevice logicalDevice, IProcessPool processPool)
	{
		super(logicalDevice);
		this.processPool = processPool;
		descriptorPool = new DescriptorPool(this);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		gatherDescriptorLists();
		descriptorPool.allocate(stack);
	}

	@Override
	public void free()
	{
		descriptorPool.free();
		descriptorSets = null;
	}

	@Override
	public boolean isDirty()
	{
		return false;
	}

	private void gatherDescriptorLists()
	{
		descriptorSets = new ArrayList<>();
		var treeIterator = processPool.eAllContents();
		while (treeIterator.hasNext())
		{
			var eObject = treeIterator.next();
			if (eObject instanceof DescriptorSet)
			{
				descriptorSets.add((DescriptorSet) eObject);
			}
		}
		descriptorSets = List.copyOf(descriptorSets);
	}

	public List<DescriptorSet> getDescriptorLists()
	{
		return descriptorSets;
	}
}
