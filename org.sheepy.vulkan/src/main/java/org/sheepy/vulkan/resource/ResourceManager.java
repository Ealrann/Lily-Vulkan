package org.sheepy.vulkan.resource;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IBasicAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.device.LogicalDeviceContext;
import org.sheepy.vulkan.model.process.AbstractProcessPool;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.resource.descriptor.DescriptorPool;

public class ResourceManager extends LogicalDeviceContext implements IBasicAllocable
{
	public final AbstractProcessPool<?> processPool;

	public final DescriptorPool descriptorPool;
	
	private List<DescriptorSet> descriptorSets = null;

	public ResourceManager(LogicalDevice logicalDevice, AbstractProcessPool<?> processPool)
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
		final TreeIterator<EObject> it = processPool.eAllContents();
		while (it.hasNext())
		{
			final EObject eo = it.next();
			if (eo instanceof DescriptorSet)
			{
				descriptorSets.add((DescriptorSet) eo);
			}
		}
		descriptorSets = List.copyOf(descriptorSets);
	}

	public List<DescriptorSet> getDescriptorLists()
	{
		return descriptorSets;
	}
}
