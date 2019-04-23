package org.sheepy.lily.vulkan.common.engine.utils;

import java.util.List;

import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.allocation.IAllocationContextProvider;
import org.sheepy.vulkan.allocation.IAllocationNode;
import org.sheepy.vulkan.execution.ExecutionContext;

public class VulkanEngineAllocationRoot implements IAllocationNode, IAllocationContextProvider
{
	private final ExecutionContext context;
	private final List<Object> allocationObjects;

	public VulkanEngineAllocationRoot(ExecutionContext context, List<Object> allocationObjects)
	{
		this.context = context;
		this.allocationObjects = List.copyOf(allocationObjects);
	}

	@Override
	public IAllocationContext getAllocationContext()
	{
		return context;
	}

	@Override
	public List<Object> getAllocationChildren()
	{
		return allocationObjects;
	}
}
