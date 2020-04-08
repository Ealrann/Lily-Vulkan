package org.sheepy.lily.vulkan.core.process;

import org.sheepy.lily.core.api.allocation.IRootAllocator;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;

public interface InternalProcessAdapter extends IProcessAdapter
{
	void start(IVulkanContext context, IRootAllocator<IVulkanContext> rootAllocator);
	void stop(IVulkanContext context);

	EQueueType getExecutionQueueType();
	boolean needPresentQueue();
}
