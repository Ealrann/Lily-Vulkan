package org.sheepy.lily.vulkan.api.graphic;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;

public interface ISwapChainManager extends IAllocable<IGraphicContext>
{
	List<Long> getSwapChainImages();

	long getAddress();

	int getImageCount();
}
