package org.sheepy.lily.vulkan.resource.semaphore;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.InternalExecutionContext;
import org.sheepy.lily.vulkan.core.resource.ISemaphoreAdapter;
import org.sheepy.lily.vulkan.model.resource.Semaphore;

@Statefull
@Adapter(scope = Semaphore.class)
public class SemaphoreAdapter implements ISemaphoreAdapter
{
	private final Semaphore semaphore;
	private final VkSemaphore vkSemaphore = new VkSemaphore();

	public SemaphoreAdapter(Semaphore semaphore)
	{
		this.semaphore = semaphore;
	}

	@Override
	public void allocate(InternalExecutionContext context)
	{
		vkSemaphore.allocate(context);

		if (semaphore.isSignalizedAtInit())
		{
			vkSemaphore.signalSemaphore(context);
		}
	}

	@Override
	public void free(InternalExecutionContext context)
	{
		vkSemaphore.free(context);
	}

	@Override
	public VkSemaphore getVkSemaphore()
	{
		return vkSemaphore;
	}
}
