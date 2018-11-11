package org.sheepy.vulkan.common.allocation;

import java.util.Collections;
import java.util.List;

public interface IAllocable
{
	void free();
	
	boolean isDirty();
	
	default List<IBasicAllocable> getChildAllocables()
	{
		return Collections.emptyList();
	}
}