package org.sheepy.lily.vulkan.api.graphic;

import org.sheepy.lily.core.api.allocation.IAllocable;

public interface IRenderPass extends IAllocable<IGraphicContext>
{
	long getAddress();
}
