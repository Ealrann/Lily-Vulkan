package org.sheepy.lily.vulkan.common.application;

import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.vulkan.window.Window;

public class VulkanApplicationUtil
{
	public static IVulkanEngineAdapter getEngineAdapter(Application application)
	{
		final VulkanEngine vulkanEngine = getEngine(application);

		return vulkanEngine.adapt(IVulkanEngineAdapter.class);
	}

	public static VulkanEngine getEngine(Application application)
	{
		VulkanEngine vulkanEngine = null;
		for (final IEngine engine : application.getEngines())
		{
			if (engine instanceof VulkanEngine)
			{
				vulkanEngine = (VulkanEngine) engine;
				break;
			}
		}
		return vulkanEngine;
	}

	public static Window getWindow(Application application)
	{
		final var engineAdapter = getEngineAdapter(application);
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
