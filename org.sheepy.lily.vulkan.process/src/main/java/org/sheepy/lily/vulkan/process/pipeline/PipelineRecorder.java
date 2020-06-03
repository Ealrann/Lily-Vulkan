package org.sheepy.lily.vulkan.process.pipeline;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineRecordable;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = Pipeline.class)
@Allocation
@AllocationChild(features = {ProcessPackage.PIPELINE__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {ProcessPackage.PIPELINE__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = {ProcessPackage.PIPELINE__TASK_PKG, ProcessPackage.TASK_PKG__TASKS})
@AllocationDependency(features = {ProcessPackage.PIPELINE__TASK_PKG, ProcessPackage.TASK_PKG__TASKS}, type = IPipelineTaskRecorder.class)
public final class PipelineRecorder implements IPipelineRecordable
{
	private final TaskPipelineManager taskManager;
	private final AbstractPipeline pipeline;
	private boolean recordNeeded = false;

	private PipelineRecorder(AbstractPipeline pipeline,
							 IObservatoryBuilder observatory,
							 @InjectDependency(index = 0) List<IPipelineTaskRecorder> tasks)
	{
		this.pipeline = pipeline;
		taskManager = new TaskPipelineManager(pipeline, tasks);
		observatory.listen(this::pipelineEnabledChange, ProcessPackage.ABSTRACT_PIPELINE__ENABLED);
	}

	private void pipelineEnabledChange(Notification notification)
	{
		if (notification.getOldBooleanValue() != notification.getNewBooleanValue())
		{
			recordNeeded = true;
		}
	}

	@UpdateDependency(index = 0)
	private void updateTasks(List<IPipelineTaskRecorder> tasks)
	{
		taskManager.updateTasks(tasks);
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
