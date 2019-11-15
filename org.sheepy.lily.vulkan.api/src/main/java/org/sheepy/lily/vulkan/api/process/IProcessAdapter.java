package org.sheepy.lily.vulkan.api.process;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.device.IVulkanContext;

public interface IProcessAdapter extends IVulkanAdapter
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
