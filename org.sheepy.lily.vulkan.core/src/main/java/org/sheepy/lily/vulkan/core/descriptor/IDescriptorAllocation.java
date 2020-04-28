package org.sheepy.lily.vulkan.core.descriptor;

import org.sheepy.lily.core.api.allocation.IAllocation;

public interface IDescriptorAllocation extends IAllocation
{
	IVkDescriptor getVkDescriptor();
}
