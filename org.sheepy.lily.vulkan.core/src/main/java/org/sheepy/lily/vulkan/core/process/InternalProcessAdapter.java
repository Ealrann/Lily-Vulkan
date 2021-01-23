package org.sheepy.lily.vulkan.core.process;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;

public interface InternalProcessAdapter extends IAdapter
{
	EQueueType getExecutionQueueType();
	boolean needPresentQueue();
	int getExecutionCount();
}
