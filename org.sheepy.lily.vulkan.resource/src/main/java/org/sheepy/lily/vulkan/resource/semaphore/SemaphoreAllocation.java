package org.sheepy.lily.vulkan.resource.semaphore;

import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.up.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.ISemaphoreAllocation;
import org.sheepy.lily.vulkan.model.resource.Semaphore;

@ModelExtender(scope = Semaphore.class)
@Allocation(context = ExecutionContext.class)
public class SemaphoreAllocation implements ISemaphoreAllocation
{
	private final VkSemaphore vkSemaphore;

	public SemaphoreAllocation(Semaphore semaphore, ExecutionContext context)
	{
		vkSemaphore = new VkSemaphore(context.getVkDevice());

		if (semaphore.isSignalizedAtInit())
		{
			vkSemaphore.signalSemaphore(context);
		}
	}

	@Free
	public void free(ExecutionContext context)
	{
		vkSemaphore.free(context.getVkDevice());
	}

	@Override
	public VkSemaphore getVkSemaphore()
	{
		return vkSemaphore;
	}
}
