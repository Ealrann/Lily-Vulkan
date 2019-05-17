package org.sheepy.lily.vulkan.api.execution;

import java.util.List;

import org.sheepy.lily.vulkan.api.process.IProcessContext;

public interface IExecutionRecorders<T extends IProcessContext>
{
	List<IExecutionRecorder<? super T>> getRecorders();
	
	boolean isAllocationDirty(T context);
}
