package org.sheepy.lily.vulkan.core.execution;

import java.util.List;

public interface IExecutionRecorders<T extends ExecutionContext>
{
	List<IExecutionRecorder<? super T>> getRecorders();
}
