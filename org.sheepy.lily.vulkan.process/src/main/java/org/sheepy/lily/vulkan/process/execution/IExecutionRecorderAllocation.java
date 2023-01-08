package org.sheepy.lily.vulkan.process.execution;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.process.execution.util.FenceManager;

import java.util.List;

public interface IExecutionRecorderAllocation extends IExecutionPlayer, IAdapter
{
	FenceManager getFenceManager();
	VkSemaphore borrowSemaphore();
	void prepare(List<WaitData> waitSemaphores, List<VkSemaphore> signalSemaphores, int executionSemaphoreCount);
}
