package org.sheepy.vulkan;

import org.sheepy.vulkan.adapter.IVulkanApplicationAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.application.VulkanApplicationAdapter;
import org.sheepy.vulkan.model.VulkanApplication;

public class VulkanApplicationLauncher
{
	private final static VulkanAdapterFactoryImpl adapterFactory = new VulkanAdapterFactoryImpl();

	public static final IVulkanApplicationAdapter launch(VulkanApplication application)
	{
		return (IVulkanApplicationAdapter) adapterFactory.adapt(application,
				VulkanApplicationAdapter.class);
	}
}
