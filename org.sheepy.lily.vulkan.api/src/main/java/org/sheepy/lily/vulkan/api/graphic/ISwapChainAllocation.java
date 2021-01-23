package org.sheepy.lily.vulkan.api.graphic;

import org.logoce.extender.api.IAdapter;

public interface ISwapChainAllocation extends IAdapter
{
	long getPtr();
	long getImagePtr(int index);
	int getImageCount();
}
