package org.sheepy.lily.vulkan.process.execution;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;

import java.util.List;

public interface IExecutionRecorderAllocation extends IExecutionPlayer, IAdapter
{
	VkSemaphore borrowSemaphore();
	void prepare(List<WaitData> waitSemaphores, int executionSemaphoreCount);
}
