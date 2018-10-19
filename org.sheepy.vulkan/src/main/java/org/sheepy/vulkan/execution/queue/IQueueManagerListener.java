package org.sheepy.vulkan.execution.queue;

import java.util.EventListener;

public interface IQueueManagerListener extends EventListener
{
	void onQueueManagerReload();
}
