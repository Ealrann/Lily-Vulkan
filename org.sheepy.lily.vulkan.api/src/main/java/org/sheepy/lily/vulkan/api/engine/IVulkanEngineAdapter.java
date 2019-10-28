package org.sheepy.lily.vulkan.api.engine;

import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.input.IVulkanInputManager;
import org.sheepy.vulkan.concurrent.VkFence;
import org.sheepy.vulkan.window.Window;

public interface IVulkanEngineAdapter extends IEngineAdapter, IVulkanAdapter
{
	Window getWindow();

	VkFence newFence();

	VkFence newFence(boolean signaled);

	@Override
	IVulkanInputManager getInputManager();
}
