package org.sheepy.vulkan.common.application;

import org.sheepy.common.model.application.Application;
import org.sheepy.common.model.application.IEngine;
import org.sheepy.vulkan.api.adapter.IVulkanEngineAdapter;
import org.sheepy.vulkan.api.window.IWindow;
import org.sheepy.vulkan.model.VulkanEngine;

public class VulkanApplicationUtil
{
	public static IVulkanEngineAdapter getEngineAdapter(Application application)
	{
		VulkanEngine vulkanEngine = getEngine(application);

		return IVulkanEngineAdapter.adapt(vulkanEngine);
	}

	public static VulkanEngine getEngine(Application application)
	{
		VulkanEngine vulkanEngine = null;
		for (IEngine engine : application.getEngines())
		{
			if (engine instanceof VulkanEngine)
			{
				vulkanEngine = (VulkanEngine) engine;
				break;
			}
		}
		return vulkanEngine;
	}

	public static IWindow getWindow(Application application)
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
