package org.sheepy.lily.vulkan.api.graphic;

import org.sheepy.lily.core.api.allocation.IAllocation;

import java.util.List;

public interface ISwapChainAllocation extends IAllocation
{
	List<Long> getSwapChainImages();
	long getPtr();
	int getImageCount();
}
