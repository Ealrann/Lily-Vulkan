package org.sheepy.lily.vulkan.process.pipeline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.resource.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.pipeline.VkPipelineLayout;

@Statefull
public abstract class AbstractPipelineAdapter<T extends IProcessContext>
		implements IAllocableAdapter<T>, IPipelineAdapter<T>
{

	protected final IPipeline pipeline;

	private final TaskPkg taskPkg;

	private List<TaskWrapper<?>> taskWrappers;
	private VkPipelineLayout<? super T> vkPipelineLayout;

	protected boolean recordNeeded = false;

	private final Adapter taskListener = new AdapterImpl()
	{
		@Override
		public void notifyChanged(Notification notification)
		{
			if (notification.getFeature() == ProcessPackage.Literals.TASK_PKG__TASKS)
			{
				reloadTasks();
				reloadAllocables();
			}
		}
	};

	private IAllocationConfiguration allocationConfig;

	public AbstractPipelineAdapter(IPipeline pipeline)
	{
		this.pipeline = pipeline;
		taskPkg = pipeline.getTaskPkg();
		if (taskPkg != null)
		{
			taskPkg.eAdapters().add(taskListener);
		}

		reloadTasks();
	}

	private void reloadTasks()
	{
		taskWrappers = List.copyOf(collectTasks());
	}

	@Dispose
	public void dispose()
	{
		if (taskPkg != null)
		{
			taskPkg.eAdapters().remove(taskListener);
		}
	}

	private List<IAllocable<?>> collectAllocables()
	{
		final List<IAllocable<?>> res = new ArrayList<>();

		for (final var taskWrapper : taskWrappers)
		{
			final var adapter = IAllocableAdapter.adapt(taskWrapper.task);
			if (adapter != null)
			{
				res.add(adapter);
			}
		}

		return res;
	}

	private List<TaskWrapper<?>> collectTasks()
	{
		final List<TaskWrapper<?>> res = new ArrayList<>();

		if (taskPkg != null)
		{
			final var tasks = taskPkg.getTasks();
			for (int i = 0; i < tasks.size(); i++)
			{
				final var task = tasks.get(i);

				res.add(new TaskWrapper<>(task));
			}
		}

		return res;
	}

	@NotifyChanged
	public void notifyChanged(Notification notification)
	{
		if (notification.getFeature() == ProcessPackage.Literals.IPIPELINE__ENABLED
				&& notification.getOldBooleanValue() != notification.getNewBooleanValue())
		{
			recordNeeded = true;
		}
	}

	@Override
	public void configureAllocation(IAllocationConfiguration config, T context)
	{
		this.allocationConfig = config;
		reloadAllocables();
	}

	private void reloadAllocables()
	{
		allocationConfig.clearChildren();
		allocationConfig.addChildren(collectAllocables());
		allocationConfig.setDirty();
	}

	@Override
	public void allocate(T context)
	{
		vkPipelineLayout = createVkPipelineLayout();
		vkPipelineLayout.allocate(context);

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			System.out.print("Pipeline Layout: ");
			System.out.println(vkPipelineLayout.toString());
		}
	}

	protected VkPipelineLayout<T> createVkPipelineLayout()
	{
		final List<IVkDescriptorSet> descriptorSets = new ArrayList<>();
		collectDescriptorSets(descriptorSets);

		final var pushConstantRanges = pipeline.getPushConstantRanges();
		return new VkPipelineLayout<>(descriptorSets, pushConstantRanges);
	}

	@Override
	public void free(T context)
	{
		vkPipelineLayout.free(context);
	}

	@Override
	public void update()
	{
		for (int i = 0; i < taskWrappers.size(); i++)
		{
			final var wrapper = taskWrappers.get(i);
			if (wrapper.isEnabled())
			{
				wrapper.update();
			}
		}
	}

	@Override
	public boolean isRecordNeeded(int index)
	{
		boolean res = recordNeeded;

		for (int i = 0; i < taskWrappers.size(); i++)
		{
			final var wrapper = taskWrappers.get(i);
			if (wrapper.isEnabled())
			{
				res |= wrapper.needRecord(index);
			}
		}

		return res;
	}

	@Override
	public final void record(RecordContext context)
	{
		final var pipelineStage = pipeline.getStage();
		final var vkPipelines = getVkPipelines();
		final var currentStage = context.stage;

		if (vkPipelines.size() == 1)
		{
			final var vkPipeline = vkPipelines.get(0);
			vkPipeline.bindPipeline(context.commandBuffer);
		}

		for (int i = 0; i < taskWrappers.size(); i++)
		{
			final var wrapper = taskWrappers.get(i);
			if (wrapper.isEnabled())
			{
				final var taskStage = wrapper.getStage();

				if ((taskStage == null && currentStage == pipelineStage)
						|| (taskStage == currentStage))
				{
					wrapper.record(context);
				}
			}
		}

		recordNeeded = false;
	}

	@Override
	public void collectResources(List<IAllocable<? super IExecutionContext>> collectIn)
	{
		final var resourcePkg = pipeline.getResourcePkg();
		if (resourcePkg != null)
		{
			for (final var resource : resourcePkg.getResources())
			{
				final var adapter = IResourceAdapter.adapt(resource);
				if (adapter != null)
				{
					collectIn.add(adapter);
				}
			}
		}
	}

	@Override
	public void collectDescriptorSets(List<IVkDescriptorSet> collectIn)
	{
		final var descriptorSetPkg = pipeline.getDescriptorSetPkg();
		if (descriptorSetPkg != null)
		{
			for (final var descriptorSet : descriptorSetPkg.getDescriptorSets())
			{
				final var adapter = IDescriptorSetAdapter.adapt(descriptorSet);
				collectIn.add(adapter);
			}
		}
	}

	@Override
	public VkPipelineLayout<? super T> getVkPipelineLayout()
	{
		return vkPipelineLayout;
	}

	@Override
	public boolean isActive()
	{
		return pipeline.isEnabled();
	}

	@Override
	public boolean shouldRecord(ECommandStage stage)
	{
		boolean res = pipeline.getStage() == stage;
		if (!res)
		{
			for (int i = 0; i < taskWrappers.size(); i++)
			{
				final var wrapper = taskWrappers.get(i);
				if (wrapper.isEnabled())
				{
					if (wrapper.getStage() == stage)
					{
						res = true;
						break;
					}
				}
			}
		}

		return res;
	}

	private static final class TaskWrapper<T extends IPipelineTask>
	{
		private final T task;
		private final IPipelineTaskAdapter<T> adapter;

		public TaskWrapper(T task)
		{
			this.task = task;
			adapter = IPipelineTaskAdapter.adapt(task);
		}

		public void record(RecordContext context)
		{
			adapter.record(task, context);
		}

		public ECommandStage getStage()
		{
			return adapter.getStage(task);
		}

		public boolean needRecord(int index)
		{
			return adapter.needRecord(task, index);
		}

		public boolean isEnabled()
		{
			return task.isEnabled();
		}

		public void update()
		{
			adapter.update(task);
		}
	}
}
