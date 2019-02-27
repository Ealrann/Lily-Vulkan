package org.sheepy.lily.vulkan.common.resource;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocationDescriptorAdapter;
import org.sheepy.lily.vulkan.model.ResourcePkg;

public interface IResourcePkgAdapter extends IAllocationDescriptorAdapter
{
	static IResourcePkgAdapter adapt(ResourcePkg pkg)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(pkg, IResourcePkgAdapter.class);
	}
}
