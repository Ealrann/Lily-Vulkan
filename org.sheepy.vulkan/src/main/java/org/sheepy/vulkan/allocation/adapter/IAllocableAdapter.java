package org.sheepy.vulkan.allocation.adapter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.adapter.IVulkanAdapter;
import org.sheepy.vulkan.allocation.IAllocable;

public interface IAllocableAdapter extends IVulkanAdapter, IAllocable
{
	static IAllocableAdapter adapt(EObject object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IAllocableAdapter.class);
	}
}
