package org.sheepy.lily.vulkan.api.engine;

import org.sheepy.lily.core.api.engine.IEngineAllocation;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.api.concurrent.IFence;

public interface IVulkanEngineAllocation extends IEngineAllocation
{
	IWindow getWindow();

	IFence newFence();

	IFence newFence(boolean signaled);
}
