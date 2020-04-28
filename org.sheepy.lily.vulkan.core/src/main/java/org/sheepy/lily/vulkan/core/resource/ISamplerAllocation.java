package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.allocation.IAllocation;

public interface ISamplerAllocation extends IAllocation
{
	long getSamplerPtr();
	long getViewPtr();
}
