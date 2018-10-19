package org.sheepy.vulkan.allocation.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.common.api.adapter.impl.AbstractSheepyAdapter;
import org.sheepy.vulkan.allocation.IBasicAllocable;
import org.sheepy.vulkan.allocation.adapter.IAllocableAdapter;

public abstract class AbstractAllocableAdapter extends AbstractSheepyAdapter
		implements IAllocableAdapter
{
	protected List<IBasicAllocable> childAllocables = new ArrayList<>();
	
	@Override
	public List<IBasicAllocable> getChildAllocables()
	{
		return childAllocables;
	}
}
