package org.sheepy.lily.vulkan.process.graphic.process;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.concurrent.VkSemaphore;

public class PresentSemaphore implements IAllocable
{
	public final VkSemaphore presentSemaphore = new VkSemaphore();

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		presentSemaphore.allocate(stack, context);
	}

	@Override
	public void free(IAllocationContext context)
	{
		presentSemaphore.free(context);
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return ((GraphicContext) context).surfaceManager.isAllocationDirty(context);
	}

}
