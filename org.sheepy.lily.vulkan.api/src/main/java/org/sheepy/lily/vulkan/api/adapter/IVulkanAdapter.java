package org.sheepy.lily.vulkan.api.adapter;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.sheepy.lily.core.api.adapter.IAdapter;

public interface IVulkanAdapter extends IAdapter
{
	static Iterator<IVulkanAdapter> getServices()
	{
		return ServiceLoader.load(IVulkanAdapter.class).iterator();
	}
}
