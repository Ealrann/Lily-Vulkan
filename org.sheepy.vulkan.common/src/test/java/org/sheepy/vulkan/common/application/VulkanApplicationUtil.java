package org.sheepy.vulkan.common.application;

import org.sheepy.vulkan.api.adapter.IVulkanEngineAdapter;
import org.sheepy.vulkan.api.window.IWindow;
import org.sheepy.vulkan.model.VulkanApplication;

public class VulkanApplicationUtil
{
	public static IVulkanEngineAdapter getEngineAdapter(VulkanApplication application)
	{
		return IVulkanEngineAdapter.adapt(application.getEngine());
	}

	public static IWindow getWindow(VulkanApplication application)
	{
		var engineAdapter = getEngineAdapter(application);
		if (engineAdapter != null)
		{
			return engineAdapter.getWindow();
		}
		else
		{
			return null;
		}
	}
}
