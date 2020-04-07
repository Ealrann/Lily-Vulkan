package org.sheepy.lily.vulkan.core.execution;

import org.sheepy.lily.vulkan.api.process.IProcessContext;

import java.util.List;

public interface IExecutionRecorders<T extends ExecutionContext>
{
	List<IExecutionRecorder<? super T>> getRecorders();
}
