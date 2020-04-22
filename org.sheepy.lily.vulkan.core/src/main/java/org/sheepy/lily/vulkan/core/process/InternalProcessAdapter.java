package org.sheepy.lily.vulkan.core.process;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;

public interface InternalProcessAdapter extends IExtender
{
	EQueueType getExecutionQueueType();
	boolean needPresentQueue();
}
