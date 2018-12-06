package org.sheepy.vulkan.resource;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;

public interface IResourceManagerAdapter extends IVulkanAdapter
{
	ResourceManager getResourceManager(EObject target);

	static IResourceManagerAdapter adapt(EObject object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IResourceManagerAdapter.class);
	}
}
