package org.sheepy.vulkan.processpool;

import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapter;
import org.sheepy.vulkan.model.AbstractProcessPool;
import org.sheepy.vulkan.model.VulkanPackage;
import org.sheepy.vulkan.resource.IResourceManagerAdapter;
import org.sheepy.vulkan.resource.ResourceManager;

public class ResourceManagerAdapter extends AbstractSheepyAdapter
		implements IResourceManagerAdapter
{
	@Override
	public ResourceManager getResourceManager()
	{
		var current = target;
		while (!VulkanPackage.Literals.ABSTRACT_PROCESS_POOL.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return AbstractProcessPoolAdapter.adapt((AbstractProcessPool<?>) current).resourceManager;
	}
}
