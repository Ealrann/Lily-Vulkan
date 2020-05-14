package org.sheepy.lily.vulkan.api.pipeline;

import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.vulkan.api.execution.IRecordContext;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface IPipelineTaskAdapter<T extends IPipelineTask> extends IAllocation
{
	default void update(T task, int index)
	{
	}

	default boolean needRecord(T task, int index)
	{
		return false;
	}

	void record(T task, IRecordContext context);

	default ECommandStage getStage(T task)
	{
		// null means use the pipeline default stage
		return null;
	}
}
