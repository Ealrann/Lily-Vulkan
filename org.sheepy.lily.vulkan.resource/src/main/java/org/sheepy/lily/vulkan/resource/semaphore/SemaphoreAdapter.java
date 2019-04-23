package org.sheepy.lily.vulkan.resource.semaphore;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.resource.Semaphore;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.execution.IExecutionContext;

@Statefull
@Adapter(scope = Semaphore.class)
public class SemaphoreAdapter implements IResourceAdapter
{
	private final Semaphore semaphore;
	private final VkSemaphore vkSemaphore = new VkSemaphore();

	public SemaphoreAdapter(Semaphore semaphore)
	{
		this.semaphore = semaphore;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		vkSemaphore.allocate(stack, context);

		if (semaphore.isSignalizedAtInit())
		{
			vkSemaphore.signalSemaphore((IExecutionContext) context);
		}
	}

	@Override
	public void free(IAllocationContext context)
	{
		vkSemaphore.free(context);
	}

	public VkSemaphore getVkSemaphore()
	{
		return vkSemaphore;
	}

	public static SemaphoreAdapter adapt(Semaphore semaphore)
	{
		return IAdapterFactoryService.INSTANCE.adapt(semaphore, SemaphoreAdapter.class);
	}
}
