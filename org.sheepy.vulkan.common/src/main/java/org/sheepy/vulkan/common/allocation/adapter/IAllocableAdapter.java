package org.sheepy.vulkan.common.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.common.allocation.IAllocable;

public interface IAllocableAdapter extends IVulkanAdapter, IAllocable
{
	static IAllocableAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IAllocableAdapter.class);
	}
}
