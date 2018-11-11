package org.sheepy.vulkan.api.adapter;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.sheepy.common.api.adapter.IServiceAdapter;

public interface IVulkanAdapter extends IServiceAdapter
{
	static Iterator<IVulkanAdapter> getServices()
	{
		return ServiceLoader.load(IVulkanAdapter.class).iterator();
	}
}
