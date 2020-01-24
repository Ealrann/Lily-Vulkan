package org.sheepy.lily.vulkan.common.pipeline;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.common.execution.IRecordable;

public interface IPipelineAdapter extends IAdapter, IRecordable
{
	default void update(int index)
	{}

	default void prepareExecution(IExecutionContext context)
	{}
}
