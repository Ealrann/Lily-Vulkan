package org.sheepy.lily.vulkan.common.allocation.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocationDescriptorAdapter;

public abstract class AbstractAllocationDescriptorAdapter extends AbstractStatefullAdapter
		implements IAllocationDescriptorAdapter
{
	protected List<Object> allocationList = new ArrayList<>();

	@Override
	public List<Object> getAllocationChildren()
	{
		return allocationList;
	}
}
