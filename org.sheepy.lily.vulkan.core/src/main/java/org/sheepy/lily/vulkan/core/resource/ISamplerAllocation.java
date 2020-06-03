package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.extender.IExtender;

public interface ISamplerAllocation extends IExtender
{
	long getSamplerPtr();
	long getViewPtr();
}
