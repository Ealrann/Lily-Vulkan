package org.sheepy.lily.vulkan.api.graphic;

import org.logoce.lmf.core.api.extender.IAdapter;

public interface ISwapChainAllocation extends IAdapter
{
	long getPtr();
	long getImagePtr(int index);
	int getImageCount();
}
