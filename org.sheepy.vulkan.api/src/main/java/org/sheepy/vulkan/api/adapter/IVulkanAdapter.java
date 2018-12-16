package org.sheepy.vulkan.api.adapter;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.sheepy.common.api.adapter.IAdapter;

public interface IVulkanAdapter extends IAdapter
{
	static Iterator<IVulkanAdapter> getServices()
	{
		return ServiceLoader.load(IVulkanAdapter.class).iterator();
	}
}
