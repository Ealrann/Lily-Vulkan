package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;

public interface ISemaphoreAdapter extends IAllocableAdapter<ExecutionContext>
{
	VkSemaphore getVkSemaphore();
}
