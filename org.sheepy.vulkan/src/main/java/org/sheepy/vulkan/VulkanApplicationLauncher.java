package org.sheepy.vulkan;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.adapter.IVulkanApplicationAdapter;
import org.sheepy.vulkan.application.VulkanApplicationAdapter;
import org.sheepy.vulkan.model.VulkanApplication;

public class VulkanApplicationLauncher
{
	private static final Class<VulkanApplicationAdapter> ADAPTER_CLASSIFIER = VulkanApplicationAdapter.class;

	public static final IVulkanApplicationAdapter launch(VulkanApplication application)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(application, ADAPTER_CLASSIFIER);
	}
}
