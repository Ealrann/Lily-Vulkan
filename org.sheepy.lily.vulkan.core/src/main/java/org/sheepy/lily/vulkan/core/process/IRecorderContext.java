package org.sheepy.lily.vulkan.core.process;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.core.execution.queue.VulkanQueue;

import java.util.List;

public interface IRecorderContext<T extends IRecorderContext<T>> extends IProcessContext
{
	VulkanQueue getQueue();
	IExecutionRecorders<? super T> getExecutionRecorders();
	List<IExecutionRecorder<? super T>> getRecorders();
	List<IAllocable<? super T>> getAllocationChildren();
}
