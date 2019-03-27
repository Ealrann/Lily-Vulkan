package org.sheepy.lily.vulkan.process.graphic.api;

import java.util.List;

import org.sheepy.lily.vulkan.api.allocation.IAllocable;

public interface ISwapChainManager extends IAllocable
{
	List<Long> getSwapChainImages();

	long getAddress();

	int getImageCount();
}
