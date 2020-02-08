package org.sheepy.lily.vulkan.core.execution;

import java.util.List;

import org.sheepy.lily.vulkan.core.process.IProcessContext;

public interface IExecutionRecorders<T extends IProcessContext>
{
	List<IExecutionRecorder<? super T>> getRecorders();
}
