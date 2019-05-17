package org.sheepy.lily.vulkan.process.graphic.process;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.concurrent.VkSemaphore;

public class PresentSemaphore implements IAllocable<IGraphicContext>
{
	public final VkSemaphore presentSemaphore = new VkSemaphore();

	@Override
	public void allocate(MemoryStack stack, IGraphicContext context)
	{
		presentSemaphore.allocate(stack, context);
	}

	@Override
	public void free(IGraphicContext context)
	{
		presentSemaphore.free(context);
	}

	@Override
	public boolean isAllocationDirty(IGraphicContext context)
	{
		return context.getSurfaceManager().isAllocationDirty(context);
	}
}
