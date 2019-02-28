package org.sheepy.lily.vulkan.resource.semaphore;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.Semaphore;
import org.sheepy.lily.vulkan.resource.ResourceAdapter;

public class SemaphoreAdapter extends ResourceAdapter
{
	private final VkSemaphore vkSemaphore = new VkSemaphore();

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		vkSemaphore.allocate(stack, context);
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

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.SEMAPHORE == eClass;
	}

	public static SemaphoreAdapter adapt(Semaphore semaphore)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(semaphore, SemaphoreAdapter.class);
	}
}
