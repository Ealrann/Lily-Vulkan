package org.sheepy.lily.vulkan.common.engine.utils;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;

public class VulkanEngineAllocationRoot implements IAllocable<ExecutionContext>
{
	private final List<IAllocable<? super ExecutionContext>> allocationObjects;

	public VulkanEngineAllocationRoot(List<? extends IAllocable<? super ExecutionContext>> allocationObjects)
	{
		this.allocationObjects = List.copyOf(allocationObjects);
	}

	@Override
	public void allocate(ExecutionContext context)
	{}

	@Override
	public void free(ExecutionContext context)
	{}

	@Override
	public void configureAllocation(IAllocationConfigurator config, ExecutionContext context)
	{
		config.addChildren(allocationObjects);
	}
}
