package org.sheepy.lily.vulkan.common.queue;

import java.util.EventListener;

public interface IQueueManagerListener extends EventListener
{
	void onQueueManagerReload();
}
