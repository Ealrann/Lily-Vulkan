package org.sheepy.lily.vulkan.api.process;

import org.sheepy.lily.vulkan.api.execution.IExecutionContext;

public interface IProcessContext extends IExecutionContext
{
	int getSwapCount();
}
