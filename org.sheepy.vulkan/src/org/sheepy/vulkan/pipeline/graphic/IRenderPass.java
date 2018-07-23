package org.sheepy.vulkan.pipeline.graphic;

import org.sheepy.vulkan.common.IAllocable;

public interface IRenderPass extends IAllocable
{
	long getId();

	void bindContext(GraphicContext context);
}
