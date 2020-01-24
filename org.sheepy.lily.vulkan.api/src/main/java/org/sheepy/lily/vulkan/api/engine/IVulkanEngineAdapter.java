package org.sheepy.lily.vulkan.api.engine;

import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.input.IVulkanInputManager;
import org.sheepy.lily.vulkan.api.window.IWindow;

public interface IVulkanEngineAdapter extends IEngineAdapter
{
	IWindow getWindow();

	IFence newFence();

	IFence newFence(boolean signaled);

	@Override
	IVulkanInputManager getInputManager();
}
