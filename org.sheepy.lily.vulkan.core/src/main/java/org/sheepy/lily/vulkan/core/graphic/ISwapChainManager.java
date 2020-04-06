package org.sheepy.lily.vulkan.core.graphic;

import java.util.List;

public interface ISwapChainManager
{
	List<Long> getSwapChainImages();

	long getAddress();

	int getImageCount();
}
