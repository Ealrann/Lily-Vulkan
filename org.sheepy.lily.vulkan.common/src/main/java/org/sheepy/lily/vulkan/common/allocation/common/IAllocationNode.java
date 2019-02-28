package org.sheepy.lily.vulkan.common.allocation.common;

import java.util.List;

public interface IAllocationNode extends IAllocationObject
{
	List<? extends Object> getAllocationChildren();
}
