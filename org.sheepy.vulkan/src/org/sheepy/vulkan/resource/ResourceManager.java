package org.sheepy.vulkan.resource;

import java.util.HashSet;
import java.util.Set;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocable;

public class ResourceManager extends AllocationNode implements IAllocable
{
	private CommandPool commandPool;

	public Set<IResource> resources = new HashSet<>();

	public ResourceManager(CommandPool commandPool)
	{
		this.commandPool = commandPool;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		for (IResource resource : resources)
		{
			resource.allocate(stack, commandPool);
		}
	}

	@Override
	public void free()
	{
		for (IResource resource : resources)
		{
			resource.free();
		}
	}

	public void addResource(IResource resource)
	{
		resources.add(resource);
	}

	public void addResource(IAllocable resource)
	{
		allocationObjects.add(resource);
	}

}
