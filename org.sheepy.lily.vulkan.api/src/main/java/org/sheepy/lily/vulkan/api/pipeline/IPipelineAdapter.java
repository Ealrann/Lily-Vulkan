package org.sheepy.lily.vulkan.api.pipeline;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.execution.IRecordable;

public interface IPipelineAdapter extends IAdapter, IRecordable
{
	default void update(int index)
	{}

	default void prepareExecution(IExecutionContext context)
	{}
}
