package org.sheepy.vulkan.pipeline.swap;

import org.sheepy.vulkan.common.IAllocable;

public interface IGraphicsPipeline extends IAllocable
{
	long getId();

	long getLayoutId();
}
