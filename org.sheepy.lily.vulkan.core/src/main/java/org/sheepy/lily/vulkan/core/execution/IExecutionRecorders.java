package org.sheepy.lily.vulkan.core.execution;

import org.sheepy.lily.core.api.extender.IExtender;

public interface IExecutionRecorders extends IExtender
{
	Integer acquire();
	IExecutionRecorder prepare(int index);
	void checkFence();
	void waitIdle();
	void invalidate();
}
