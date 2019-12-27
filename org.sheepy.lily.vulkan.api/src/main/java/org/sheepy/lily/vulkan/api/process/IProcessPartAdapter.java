package org.sheepy.lily.vulkan.api.process;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.execution.IRecordable;

public interface IProcessPartAdapter extends IAdapter, IRecordable
{
	default void update(int index)
	{}

	default void prepareExecution(IExecutionContext context)
	{}

	void collectDescriptorSets(List<IVkDescriptorSet> collectIn);
}
