package org.sheepy.lily.vulkan.core.execution;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;

public interface IExecutionManagerAdapter extends IAdapter
{
	IExecutionPlayer acquireNextPlayer();

	void waitIdle();
}
