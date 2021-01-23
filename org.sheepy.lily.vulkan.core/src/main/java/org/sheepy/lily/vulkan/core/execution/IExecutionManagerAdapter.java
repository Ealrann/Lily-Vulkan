package org.sheepy.lily.vulkan.core.execution;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;

public interface IExecutionManagerAdapter extends IAdapter
{
	IExecutionPlayer acquire();
	void waitIdle();
	int getExecutionCount();
}
