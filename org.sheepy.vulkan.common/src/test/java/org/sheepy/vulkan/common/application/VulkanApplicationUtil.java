package org.sheepy.vulkan.common.application;

import org.sheepy.vulkan.common.window.Window;
import org.sheepy.vulkan.model.VulkanApplication;

public class VulkanApplicationUtil
{
	public static VulkanApplicationManager getApplicationManager(VulkanApplication application)
	{
		var adapter = VulkanApplicationAdapter.adapt(application);
		return adapter.getManager();
	}

	public static Window getWindow(VulkanApplication application)
	{
		var manager = getApplicationManager(application);
		if (manager != null)
		{
			return manager.window;
		}
		else
		{
			return null;
		}
	}
}
