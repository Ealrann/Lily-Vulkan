package org.sheepy.vulkan.resource;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.adapter.IVulkanAdapter;

public interface IResourceManagerAdapter extends IVulkanAdapter
{
	ResourceManager getResourceManager(EObject target);

	static IResourceManagerAdapter adapt(EObject object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IResourceManagerAdapter.class);
	}
}
