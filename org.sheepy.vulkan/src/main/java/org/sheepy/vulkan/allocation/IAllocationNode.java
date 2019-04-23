package org.sheepy.vulkan.allocation;

import java.util.List;

public interface IAllocationNode extends IAllocationObject
{
	List<? extends Object> getAllocationChildren();
}
