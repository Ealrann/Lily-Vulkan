package org.sheepy.lily.vulkan.core.test.application;

import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAllocation;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;

public class VulkanApplicationUtil
{
	public static IVulkanEngineAllocation getEngineAdapter(Application application)
	{
		final VulkanEngine vulkanEngine = getEngine(application);
		return vulkanEngine != null ? vulkanEngine.adapt(IVulkanEngineAllocation.class) : null;
	}

	public static VulkanEngine getEngine(Application application)
	{
		for (final IEngine engine : application.engines())
		{
			if (engine instanceof VulkanEngine vulkanEngine)
			{
				return vulkanEngine;
			}
		}
		return null;
	}

	public static IWindow getWindow(Application application)
	{
		final var engineAdapter = getEngineAdapter(application);
		return engineAdapter != null ? engineAdapter.getWindow() : null;
	}
}

