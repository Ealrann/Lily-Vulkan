package org.sheepy.lily.vulkan.api.graphic;

import java.util.List;

public interface ISwapChainManager
{
	List<Long> getSwapChainImages();

	long getAddress();

	int getImageCount();
}
