package org.sheepy.lily.vulkan.core.execution;

import org.sheepy.lily.core.api.allocation.IAllocation;

public interface IExecutionRecorders extends IAllocation
{
	Integer acquire();
	IExecutionRecorder prepare(int index);
	void checkFence();
	void waitIdle();
	void invalidate();
}
