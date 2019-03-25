package org.sheepy.lily.vulkan.api.allocation;

import java.util.List;

public interface IAllocationNode extends IAllocationObject
{
	List<? extends Object> getAllocationChildren();
}
