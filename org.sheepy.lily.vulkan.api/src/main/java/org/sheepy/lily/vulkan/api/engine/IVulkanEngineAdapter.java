package org.sheepy.lily.vulkan.api.engine;

import org.sheepy.lily.core.api.engine.IInputEngineAdapter;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.input.IVulkanInputManager;

public interface IVulkanEngineAdapter extends IInputEngineAdapter
{
	IWindow getWindow();

	IFence newFence();

	IFence newFence(boolean signaled);

	@Override
	IVulkanInputManager getInputManager();
}
