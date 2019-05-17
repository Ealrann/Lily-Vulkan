package org.sheepy.lily.vulkan.api.graphic;

import java.util.List;

import org.sheepy.vulkan.allocation.IAllocable;

public interface IFramebufferManager extends IAllocable<IGraphicContext>
{
	List<ClearInfo> getClearInfos();

	List<Long> getFramebufferAddresses();

	boolean hasDepthAttachment();
}
