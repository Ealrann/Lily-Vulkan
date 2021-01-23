package org.sheepy.lily.vulkan.core.resource;

import org.logoce.extender.api.IAdapter;

public interface ISamplerAllocation extends IAdapter
{
	long getSamplerPtr();
	long getViewPtr();
}
