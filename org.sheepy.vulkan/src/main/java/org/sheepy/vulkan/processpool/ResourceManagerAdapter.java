package org.sheepy.vulkan.processpool;

import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapter;
import org.sheepy.vulkan.model.process.AbstractProcessPool;
import org.sheepy.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.resource.IResourceManagerAdapter;
import org.sheepy.vulkan.resource.ResourceManager;

public class ResourceManagerAdapter extends AbstractSheepyAdapter implements IResourceManagerAdapter
{
	@Override
	public ResourceManager getResourceManager()
	{
		var current = target;
		while (!ProcessPackage.Literals.ABSTRACT_PROCESS_POOL.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return AbstractProcessPoolAdapter.adapt((AbstractProcessPool<?>) current).resourceManager;
	}
}
