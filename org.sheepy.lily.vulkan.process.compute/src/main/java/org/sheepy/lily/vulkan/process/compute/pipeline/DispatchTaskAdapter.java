package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;

import java.util.List;

import static org.lwjgl.vulkan.VK10.vkCmdDispatch;

@ModelExtender(scope = DispatchTask.class)
@Adapter
public final class DispatchTaskAdapter implements IRecordableAdapter
{
	private final DispatchTask task;
	private boolean loggedOnce = false;

	private DispatchTaskAdapter(DispatchTask task)
	{
		this.task = task;
	}

	@Override
	public void record(RecordContext context)
	{
		if (DebugUtil.DEBUG_VERBOSE_ENABLED && !loggedOnce)
		{
			logDispatchInfo();
			loggedOnce = true;
		}

		final var commandBuffer = context.commandBuffer;
		final int groupCountX = task.workgroupCountX();
		final int groupCountY = task.workgroupCountY();
		final int groupCountZ = task.workgroupCountZ();

		vkCmdDispatch(commandBuffer, groupCountX, groupCountY, groupCountZ);
	}

	private void logDispatchInfo()
	{
		final var pipeline = ModelUtil.findParent(task, AbstractPipeline.class);
		final var pipelineName = pipeline != null ? pipeline.name() : "<no-pipeline>";
		final var pipelineRanges = pipeline instanceof VkPipeline vkPipeline ? vkPipeline.pushConstantRanges().size() : -1;
		final var container = task.lmContainer();
		final var rawTaskName = task.name();
		final var taskName = rawTaskName == null || rawTaskName.isEmpty() ? "<unnamed>" : rawTaskName;

		final var details = resolveContainerDetails(container, task);
		Logger.log(String.format("[Dispatch] pipeline=%s task=%s container=%s tasks=%d index=%d pushConstants=%d pushBefore=%s ranges=%d",
								 pipelineName,
								 taskName,
								 details.containerType(),
								 details.taskCount(),
								 details.taskIndex(),
								 details.pushConstantCount(),
								 details.pushBefore(),
								 pipelineRanges),
				   true);
	}

	private static ContainerDetails resolveContainerDetails(Object container, DispatchTask dispatchTask)
	{
		if (container instanceof TaskPkg taskPkg)
		{
			return analyzeTasks("TaskPkg", taskPkg.tasks(), taskPkg.tasks().indexOf(dispatchTask));
		}
		if (container instanceof CompositeTask compositeTask)
		{
			final var tasks = compositeTask.tasks();
			return analyzeTasks("CompositeTask", tasks, tasks.indexOf(dispatchTask));
		}

		return new ContainerDetails(container != null ? container.getClass().getSimpleName() : "<no-container>",
									-1,
									-1,
									0,
									false);
	}

	private static ContainerDetails analyzeTasks(String containerType, List<IPipelineTask> tasks, int taskIndex)
	{
		int pushConstantCount = 0;
		boolean pushBefore = false;
		for (int i = 0; i < tasks.size(); i++)
		{
			final var task = tasks.get(i);
			if (task instanceof PushConstantBuffer)
			{
				pushConstantCount++;
				if (taskIndex >= 0 && i < taskIndex)
				{
					pushBefore = true;
				}
			}
		}
		return new ContainerDetails(containerType, tasks.size(), taskIndex, pushConstantCount, pushBefore);
	}

	private record ContainerDetails(String containerType,
									int taskCount,
									int taskIndex,
									int pushConstantCount,
									boolean pushBefore)
	{
	}
}
