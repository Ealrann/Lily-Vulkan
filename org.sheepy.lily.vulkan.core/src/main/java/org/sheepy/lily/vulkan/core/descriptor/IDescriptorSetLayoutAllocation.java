package org.sheepy.lily.vulkan.core.descriptor;

import org.logoce.extender.api.IAdapter;

public interface IDescriptorSetLayoutAllocation extends IAdapter
{
	long getLayoutPtr();
	int descriptorCount();
}
