package org.sheepy.lily.vulkan.api.execution;

import org.sheepy.vulkan.concurrent.IFenceView;

public interface IExecutionPlayer
{
	IFenceView play();

	void waitIdle();
}
