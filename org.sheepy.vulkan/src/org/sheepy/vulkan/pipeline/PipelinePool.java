package org.sheepy.vulkan.pipeline;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.device.LogicalDevice;

/**
 * 
 * Ceci n'est pas un allocationNode, car ses fils (le SwapPipeline par exemple)
 * va être libéré et réalloué. Un AllocationNode ne supporte pas un reload
 * partiel de ses fils.
 * 
 * @author ealrann
 *
 */
public abstract class PipelinePool implements IAllocable
{
	protected CommandPool commandPool;
	protected List<IAllocationObject> subAllocationObjects = new ArrayList<>();

	public PipelinePool(LogicalDevice logicalDevice, int queueIndex)
	{
		this(logicalDevice, queueIndex, false);
	}
	
	public PipelinePool(LogicalDevice logicalDevice, int queueIndex, boolean allowReset)
	{
		commandPool = new CommandPool(logicalDevice,
				queueIndex, allowReset);
		
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			// Allocate the pool early, becaus it's practical
			commandPool.allocate(stack);
		}
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		for (IAllocationObject allocation : subAllocationObjects)
		{
			if (allocation instanceof AllocationNode)
			{
				((AllocationNode) allocation).allocateNode(stack);
			}
			else if (allocation instanceof IAllocable)
			{
				((IAllocable) allocation).allocate(stack);
			}
		}
	}

	@Override
	public void free()
	{
		for (int i = subAllocationObjects.size() - 1; i >= 0; i--)
		{
			IAllocationObject allocation = subAllocationObjects.get(i);

			if (allocation instanceof AllocationNode)
			{
				((AllocationNode) allocation).freeNode();
			}
			else if (allocation instanceof IAllocable)
			{
				((IAllocable) allocation).free();
			}
		}
		
		commandPool.free();
	}

	public abstract void execute();

	public final CommandPool getCommandPool()
	{
		return commandPool;
	}
}
