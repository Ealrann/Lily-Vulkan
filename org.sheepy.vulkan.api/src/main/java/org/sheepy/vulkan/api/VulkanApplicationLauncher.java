package org.sheepy.vulkan.api;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanApplicationAdapter;
import org.sheepy.vulkan.model.VulkanApplication;

public class VulkanApplicationLauncher
{
	private static final Class<IVulkanApplicationAdapter> ADAPTER_CLASSIFIER = IVulkanApplicationAdapter.class;

	public static final IVulkanApplicationAdapter launch(VulkanApplication application)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(application, ADAPTER_CLASSIFIER);
	}
}