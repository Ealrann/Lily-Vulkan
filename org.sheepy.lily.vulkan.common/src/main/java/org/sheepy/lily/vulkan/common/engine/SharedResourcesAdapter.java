package org.sheepy.lily.vulkan.common.engine;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.model.SharedResources;
import org.sheepy.lily.vulkan.model.VulkanPackage;

public class SharedResourcesAdapter extends AbstractEnginePartAdapter
{
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VulkanPackage.Literals.SHARED_RESOURCES == eClass;
	}

	@Override
	protected boolean isResetAllowed()
	{
		return false;
	}

	@Override
	protected EQueueType getQueueType()
	{
		return EQueueType.Graphic;
	}

	public static SharedResourcesAdapter adapt(SharedResources object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, SharedResourcesAdapter.class);
	}
}
