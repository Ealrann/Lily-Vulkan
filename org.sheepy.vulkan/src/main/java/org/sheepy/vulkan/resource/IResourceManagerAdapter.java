package org.sheepy.vulkan.resource;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.vulkan.adapter.IVulkanAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;

public interface IResourceManagerAdapter extends IVulkanAdapter
{
	ResourceManager getResourceManager();

	static IResourceManagerAdapter adapt(EObject object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, IResourceManagerAdapter.class);
	}
}
