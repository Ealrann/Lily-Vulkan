package org.sheepy.lily.vulkan.api.execution;

import org.sheepy.lily.vulkan.api.concurrent.IFenceView;

public interface IExecutionPlayer
{
	IFenceView play();

	void waitIdle();
	boolean checkFence();
}
