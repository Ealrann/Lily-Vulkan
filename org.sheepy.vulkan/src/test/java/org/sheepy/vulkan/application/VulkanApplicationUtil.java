package org.sheepy.vulkan.application;

import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.window.Window;

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
