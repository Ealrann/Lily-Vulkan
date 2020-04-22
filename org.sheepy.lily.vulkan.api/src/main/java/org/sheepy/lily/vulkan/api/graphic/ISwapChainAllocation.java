package org.sheepy.lily.vulkan.api.graphic;

import org.sheepy.lily.core.api.extender.IExtender;

public interface ISwapChainAllocation extends IExtender
{
	long getPtr();
	long getImagePtr(int index);
	int getImageCount();
}
