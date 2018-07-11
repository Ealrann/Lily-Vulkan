package org.sheepy.vulkan.pipeline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.device.LogicalDevice;

public abstract class PipelinePool extends AllocationNode
{
	protected CommandPool commandPool;
	protected List<IAllocationObject> subAllocationObjects = new ArrayList<>();
	
	public PipelinePool(LogicalDevice logicalDevice, int queueIndex)
	{
		commandPool = new CommandPool(logicalDevice,
				logicalDevice.getQueueManager().getGraphicQueueIndex());
		subAllocationObjects.add(commandPool);
	}
	
	public abstract void execute();

	public final CommandPool getCommandPool()
	{
		return commandPool;
	}

	@Override
	protected final Collection<? extends IAllocationObject> getSubAllocables()
	{
		return subAllocationObjects;
	}
}
