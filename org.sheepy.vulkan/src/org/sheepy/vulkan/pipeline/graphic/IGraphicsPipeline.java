package org.sheepy.vulkan.pipeline.graphic;

import org.sheepy.vulkan.common.IAllocable;

public interface IGraphicsPipeline extends IAllocable
{
	long getId();

	long getLayoutId();
}
