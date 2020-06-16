package org.sheepy.lily.vulkan.process.pipeline;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineRecordable;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@ModelExtender(scope = Pipeline.class)
@Adapter
public final class PipelineRecorder implements IPipelineRecordable
{
	private final TaskPipelineManager taskManager;
	private final Pipeline pipeline;

	private boolean recordNeeded = true;

	private PipelineRecorder(Pipeline pipeline, IObservatoryBuilder observatory)
	{
		this.pipeline = pipeline;
		taskManager = new TaskPipelineManager(pipeline, observatory);
		observatory.listen(this::pipelineEnabledChange, ProcessPackage.PIPELINE__ENABLED);
	}

	private void pipelineEnabledChange(Notification notification)
	{
		if (notification.getOldBooleanValue() != notification.getNewBooleanValue())
		{
			recordNeeded = true;
		}
	}

	@Override
	public void update(final int index)
	{
		taskManager.update(index);
	}

	@Override
	public void record(final RecordContext context)
	{
		if (isActive())
		{
			taskManager.record(context);
		}
		recordNeeded = false;
	}

	@Override
	public boolean shouldRecord(final ECommandStage stage)
	{
		return pipeline.getStage() == stage || taskManager.shouldRecord(stage);
	}

	@Override
	public boolean isActive()
	{
		return pipeline.isEnabled();
	}

	@Override
	public boolean isRecordDirty(final int index)
	{
		return recordNeeded || taskManager.isRecordDirty(index);
	}
}
