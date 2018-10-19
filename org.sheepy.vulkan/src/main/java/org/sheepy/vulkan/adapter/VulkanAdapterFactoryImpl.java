package org.sheepy.vulkan.adapter;

import org.sheepy.common.api.adapter.ISheepyAdapterRegistry;
import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapterFactory;

public class VulkanAdapterFactoryImpl extends AbstractSheepyAdapterFactory
{
	public static final VulkanAdapterFactoryImpl INSTANCE = new VulkanAdapterFactoryImpl();

	@Override
	protected ISheepyAdapterRegistry getRegistry()
	{
		return VulkanAdapterRegistry.INSTANCE;
	}
}
