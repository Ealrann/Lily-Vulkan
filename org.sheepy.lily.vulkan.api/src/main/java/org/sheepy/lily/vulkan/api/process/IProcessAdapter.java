package org.sheepy.lily.vulkan.api.process;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.device.IVulkanContext;

public interface IProcessAdapter extends IAdapter
{
	void start(IVulkanContext context);
	void stop(IVulkanContext context);

	IFenceView run();

	void waitIdle();
	
	// Can fire the fence listeners (for TransferBuffer Fetch).
	// TODO really sad that the client need to call that...
	void checkFence();

	boolean isMultithreadAllowed();
}
