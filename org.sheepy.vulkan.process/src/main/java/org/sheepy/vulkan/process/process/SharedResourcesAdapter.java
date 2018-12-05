package org.sheepy.vulkan.process.process;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.queue.EQueueType;
import org.sheepy.vulkan.common.engine.AbstractEnginePartAdapter;
import org.sheepy.vulkan.model.SharedResources;
import org.sheepy.vulkan.model.VulkanPackage;

public class SharedResourcesAdapter extends AbstractEnginePartAdapter
{
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VulkanPackage.Literals.SHARED_RESOURCES == eClass;
	}

	public static SharedResourcesAdapter adapt(SharedResources object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, SharedResourcesAdapter.class);
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
}
