package org.sheepy.lily.vulkan.core.descriptor;

import org.logoce.lmf.core.api.extender.IAdapter;

public interface IDescriptorSetLayoutAllocation extends IAdapter
{
	long getLayoutPtr();

	int descriptorCount();
}
