package org.sheepy.lily.vulkan.common.process;

import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.vulkan.queue.EQueueType;

public interface IExecutionProcessAdapter extends IProcessAdapter
{
	EQueueType getExecutionQueueType();
	boolean needPresentQueue();
}
