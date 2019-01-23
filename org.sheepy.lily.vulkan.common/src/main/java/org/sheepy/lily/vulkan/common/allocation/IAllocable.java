package org.sheepy.lily.vulkan.common.allocation;

import java.util.Collections;
import java.util.List;

public interface IAllocable
{
	void free();
	
	boolean isAllocationDirty();
	
	default List<IBasicAllocable> getChildAllocables()
	{
		return Collections.emptyList();
	}
}
