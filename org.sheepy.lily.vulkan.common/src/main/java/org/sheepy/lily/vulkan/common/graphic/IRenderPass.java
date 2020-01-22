package org.sheepy.lily.vulkan.common.graphic;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;

public interface IRenderPass extends IAllocable<IGraphicContext>
{
	long getPtr();

	List<ClearInfo> getClearInfos();
}
