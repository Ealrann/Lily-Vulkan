package org.sheepy.lily.vulkan.common.engine.utils;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.execution.IExecutionContext;

public class VulkanEngineAllocationRoot implements IAllocable<IVulkanContext>
{
	private final IExecutionContext childrenContext;
	private final List<IAllocable<? super IExecutionContext>> allocationObjects;

	public VulkanEngineAllocationRoot(	IExecutionContext childrenContext,
										List<? extends IAllocable<? super IExecutionContext>> allocationObjects)
	{
		this.childrenContext = childrenContext;
		this.allocationObjects = List.copyOf(allocationObjects);
	}

	@Override
	public void allocate(IVulkanContext context)
	{}

	@Override
	public void free(IVulkanContext context)
	{}

	@Override
	public void configureAllocation(IAllocationConfiguration config, IVulkanContext context)
	{
		config.setChildrenContext(childrenContext);
		config.addChildren(allocationObjects);
	}
}
