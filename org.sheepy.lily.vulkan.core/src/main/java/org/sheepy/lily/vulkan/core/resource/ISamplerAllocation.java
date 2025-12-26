package org.sheepy.lily.vulkan.core.resource;

import org.logoce.lmf.core.api.extender.IAdapter;

public interface ISamplerAllocation extends IAdapter
{
	long getSamplerPtr();

	long getViewPtr();
}
