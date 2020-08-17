package org.sheepy.lily.vulkan.core.test.application;

import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAllocation;
import org.sheepy.lily.vulkan.model.VulkanEngine;

public class VulkanApplicationUtil
{
	public static IVulkanEngineAllocation getEngineAdapter(Application application)
	{
		final VulkanEngine vulkanEngine = getEngine(application);

		return vulkanEngine.adapt(IVulkanEngineAllocation.class);
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

	public static IWindow getWindow(Application application)
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
