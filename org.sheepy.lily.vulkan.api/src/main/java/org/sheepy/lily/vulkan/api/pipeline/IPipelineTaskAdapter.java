package org.sheepy.lily.vulkan.api.pipeline;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface IPipelineTaskAdapter<T extends IPipelineTask> extends IAdapter
{
	default void update(T task, int index)
	{}

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

	public static interface IRecordContext
	{
		MemoryStack stack();
		int index();
	}
}
