package org.sheepy.vulkan.common.queue;

import java.util.EventListener;

public interface IQueueManagerListener extends EventListener
{
	void onQueueManagerReload();
}
