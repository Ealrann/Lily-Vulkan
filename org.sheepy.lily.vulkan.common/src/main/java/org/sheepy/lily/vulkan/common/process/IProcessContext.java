package org.sheepy.lily.vulkan.common.process;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.common.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.common.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.execution.IExecutionContext;

public interface IProcessContext extends IExecutionContext
{
	DescriptorPool getDescriptorPool();
	int getSwapCount();
	AbstractProcess getProcess();

	interface IRecorderContext<T extends IRecorderContext<T>> extends IProcessContext
	{
		IExecutionRecorders<? super T> getExecutionRecorders();
		List<IExecutionRecorder<? super T>> getRecorders();
		List<IAllocable<? super T>> getAllocationChildren();
	}
}
