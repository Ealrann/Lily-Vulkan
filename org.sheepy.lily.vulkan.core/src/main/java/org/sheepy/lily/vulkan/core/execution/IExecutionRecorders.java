package org.sheepy.lily.vulkan.core.execution;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;

public interface IExecutionRecorders extends IExtender
{
	IExecutionPlayer acquire();
	void checkFence();
	void waitIdle();
	int getExecutionCount();
}
