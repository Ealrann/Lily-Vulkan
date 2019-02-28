package org.sheepy.lily.vulkan.common.engine;

import java.util.List;

import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContextProvider;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationNode;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;

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
