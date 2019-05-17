package org.sheepy.vulkan.allocation;

import java.util.List;

public interface IAllocationObject<T extends IAllocationContext>
{
	interface IAllocationContainer<T extends IAllocationContext>
	{
		List<? extends IAllocationObject<? super T>> getAllocationChildren();
	}
}
