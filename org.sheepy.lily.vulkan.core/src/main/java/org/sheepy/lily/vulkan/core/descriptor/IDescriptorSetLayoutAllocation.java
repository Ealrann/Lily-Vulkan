package org.sheepy.lily.vulkan.core.descriptor;

import org.sheepy.lily.core.api.extender.IExtender;

public interface IDescriptorSetLayoutAllocation extends IExtender
{
	long getLayoutPtr();
	int descriptorCount();
}
