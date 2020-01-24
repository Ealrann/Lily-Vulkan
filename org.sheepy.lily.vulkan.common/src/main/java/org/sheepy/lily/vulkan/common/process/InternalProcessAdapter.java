package org.sheepy.lily.vulkan.common.process;

import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.common.device.VulkanContext;
import org.sheepy.lily.vulkan.common.execution.queue.EQueueType;

public interface InternalProcessAdapter extends IProcessAdapter
{
	void start(VulkanContext context);
	void stop(VulkanContext context);

	EQueueType getExecutionQueueType();
	boolean needPresentQueue();
}
