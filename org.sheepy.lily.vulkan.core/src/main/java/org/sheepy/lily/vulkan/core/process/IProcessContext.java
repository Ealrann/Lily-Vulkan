package org.sheepy.lily.vulkan.core.process;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.core.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.core.execution.InternalExecutionContext;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;

public interface IProcessContext extends IExecutionContext, InternalExecutionContext
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
