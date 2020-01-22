package org.sheepy.lily.vulkan.common.execution;

import java.util.List;

import org.sheepy.lily.vulkan.common.process.IProcessContext;

public interface IExecutionRecorders<T extends IProcessContext>
{
	List<IExecutionRecorder<? super T>> getRecorders();
}
