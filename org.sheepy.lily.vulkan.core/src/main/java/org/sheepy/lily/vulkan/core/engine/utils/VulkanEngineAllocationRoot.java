package org.sheepy.lily.vulkan.core.engine.utils;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.core.device.VulkanContext;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;

import java.util.List;

public class VulkanEngineAllocationRoot implements IAllocable<VulkanContext>
{
	public static final EQueueType ENGINE_QUEUE_TYPE = EQueueType.Compute;

	private final List<IAllocable<? super ExecutionContext>> allocationObjects;
	public final ExecutionContext executionContext;

	public VulkanEngineAllocationRoot(List<? extends IAllocable<? super ExecutionContext>> allocationObjects)
	{
		this.allocationObjects = List.copyOf(allocationObjects);
		executionContext = new ExecutionContext(ENGINE_QUEUE_TYPE, false);
	}

	@Override
	public void allocate(VulkanContext context)
	{
	}

	@Override
	public void free(VulkanContext context)
	{
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, VulkanContext context)
	{
		config.setChildrenContext(executionContext);
		config.addChildren(allocationObjects);
	}
}
