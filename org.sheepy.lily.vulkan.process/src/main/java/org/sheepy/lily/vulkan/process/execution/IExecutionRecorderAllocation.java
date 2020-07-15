package org.sheepy.lily.vulkan.process.execution;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;

import java.util.List;

public interface IExecutionRecorderAllocation extends IExecutionPlayer, IExtender
{
	VkSemaphore borrowSemaphore();
	void prepare(List<WaitData> waitSemaphores, int executionSemaphoreCount);
}
