package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.model.process.SetCompositeBufferFlushMode;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Adapter(scope = SetCompositeBufferFlushMode.class)
public class SetCompositeBufferFlushModeAdapter
		implements IPipelineTaskAdapter<SetCompositeBufferFlushMode>
{
	@Override
	public void record(SetCompositeBufferFlushMode task, RecordContext context)
	{
		task.getCompositeBuffer().setMode(task.getMode());
	}

	@Override
	public ECommandStage getStage(SetCompositeBufferFlushMode task)
	{
		return task.isSetStage() ? task.getStage() : null;
	}
}
