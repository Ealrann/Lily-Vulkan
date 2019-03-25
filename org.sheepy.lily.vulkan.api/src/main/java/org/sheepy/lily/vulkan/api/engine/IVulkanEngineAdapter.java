package org.sheepy.lily.vulkan.api.engine;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.engine.IEngineAdapter;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.input.IVulkanInputManager;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;
import org.sheepy.lily.vulkan.model.VulkanEngine;

public interface IVulkanEngineAdapter extends IEngineAdapter, IVulkanAdapter
{
	Window getWindow();

	IFence newFence();

	IFence newFence(boolean signaled);

	@Override
	IVulkanInputManager getInputManager();

	static IVulkanEngineAdapter adapt(VulkanEngine engine)
	{
		return IAdapterFactoryService.INSTANCE.adapt(engine, IVulkanEngineAdapter.class);
	}
}
