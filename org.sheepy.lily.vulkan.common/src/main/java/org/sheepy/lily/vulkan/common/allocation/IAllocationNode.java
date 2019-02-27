package org.sheepy.lily.vulkan.common.allocation;

import java.util.List;

public interface IAllocationNode extends IAllocationObject
{
	List<IAllocationObject> getAllocationList();
}
