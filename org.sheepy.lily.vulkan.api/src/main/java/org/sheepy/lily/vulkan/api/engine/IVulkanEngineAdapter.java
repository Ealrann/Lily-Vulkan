package org.sheepy.lily.vulkan.api.engine;

import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.api.concurrent.IFence;

public interface IVulkanEngineAdapter extends IEngineAdapter
{
	IWindow getWindow();

	IFence newFence();

	IFence newFence(boolean signaled);
}
