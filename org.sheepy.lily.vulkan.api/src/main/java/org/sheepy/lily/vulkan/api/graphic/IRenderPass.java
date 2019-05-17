package org.sheepy.lily.vulkan.api.graphic;

import org.sheepy.vulkan.allocation.IAllocable;

public interface IRenderPass extends IAllocable<IGraphicContext>
{
	long getAddress();
}
