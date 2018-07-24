package org.sheepy.vulkan.pipeline;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.device.LogicalDevice;

/**
 * Ceci n'est pas un allocationNode, car ses fils (le SwapPipeline par exemple)
 * va être libéré et réalloué. Un AllocationNode ne supporte pas un reload
 * partiel de ses fils.
 * 
 * @author ealrann
 *
 */
public abstract class AbstractProcessPool extends AllocationNode
{
	public final LogicalDevice logicalDevice;
	public final CommandPool commandPool;

	public AbstractProcessPool(LogicalDevice logicalDevice, int queueIndex)
	{
		this(logicalDevice, queueIndex, false);
	}
	
	public AbstractProcessPool(LogicalDevice logicalDevice, int queueIndex, boolean allowReset)
	{
		this.logicalDevice = logicalDevice; 
		commandPool = new CommandPool(logicalDevice,
				queueIndex, allowReset);
		
		allocationObjects.add(commandPool);
		
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			// Allocate the pool early, because it's practical
			commandPool.allocate(stack);
		}
	}
	
	public final CommandPool getCommandPool()
	{
		return commandPool;
	}
	
	public abstract void execute();

}
