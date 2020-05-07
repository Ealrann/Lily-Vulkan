package org.sheepy.lily.vulkan.core.execution;

import org.sheepy.lily.core.api.allocation.IAllocation;

import java.util.List;

public interface IExecutionRecorders extends IAllocation
{
	List<? extends IExecutionRecorder> getRecorders();
	Integer prepareNextExecution();
}
