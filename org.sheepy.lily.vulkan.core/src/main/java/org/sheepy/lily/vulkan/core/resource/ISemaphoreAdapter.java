package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.InternalExecutionContext;

public interface ISemaphoreAdapter extends IAllocableAdapter<InternalExecutionContext>
{
	VkSemaphore getVkSemaphore();
}
