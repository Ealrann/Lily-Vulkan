package org.sheepy.lily.vulkan.common.engine.utils;

import java.util.List;

import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContextProvider;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.execution.IExecutionContext;

public class VulkanEngineAllocationRoot
		implements IAllocationContextProvider<IVulkanContext, IExecutionContext>
{
	private final IExecutionContext context;
	private final List<? extends IAllocable<? super IExecutionContext>> allocationObjects;

	public VulkanEngineAllocationRoot(	IExecutionContext context,
										List<? extends IAllocable<? super IExecutionContext>> allocationObjects)
	{
		this.context = context;
		this.allocationObjects = List.copyOf(allocationObjects);
	}

	@Override
	public IExecutionContext getAllocationContext()
	{
		return context;
	}

	@Override
	public List<? extends IAllocable<? super IExecutionContext>> getAllocationChildren()
	{
		return allocationObjects;
	}
}
