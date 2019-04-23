package org.sheepy.lily.vulkan.api.engine;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.input.IVulkanInputManager;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.vulkan.concurrent.VkFence;
import org.sheepy.vulkan.window.Window;

public interface IVulkanEngineAdapter extends IEngineAdapter, IVulkanAdapter
{
	Window getWindow();

	VkFence newFence();

	VkFence newFence(boolean signaled);

	@Override
	IVulkanInputManager getInputManager();

	static IVulkanEngineAdapter adapt(VulkanEngine engine)
	{
		return IAdapterFactoryService.INSTANCE.adapt(engine, IVulkanEngineAdapter.class);
	}
}
