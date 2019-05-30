package org.sheepy.lily.vulkan.process.pipeline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.allocation.IAllocationAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationNode;
import org.sheepy.vulkan.allocation.IAllocationObject;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.pipeline.VkPipelineLayout;

@Statefull
public abstract class AbstractPipelineAdapter<T extends IProcessContext>
		implements IAllocableAdapter<T>, IPipelineAdapter<T>, IAllocationNode<T>
{

	protected final IPipeline pipeline;

	protected boolean recordNeeded = false;
	protected List<IAllocable<? super T>> allocationDependencies = new ArrayList<>();

	private final List<IAllocationObject<? super T>> allocationList = new ArrayList<>();
	private final List<TaskWrapper<?>> taskWrappers = new ArrayList<>();
	private VkPipelineLayout<? super T> vkPipelineLayout;
	private final TaskPkg taskPkg;
	private boolean taskListDirty = true;

	private final Adapter taskListener = new AdapterImpl()
	{
		@Override
		public void notifyChanged(Notification notification)
		{
			if (notification.getFeature() == ProcessPackage.Literals.TASK_PKG__TASKS)
			{
				taskListDirty = true;
			}
		}
	};

	public AbstractPipelineAdapter(IPipeline pipeline)
	{
		this.pipeline = pipeline;
		taskPkg = pipeline.getTaskPkg();
		taskPkg.eAdapters().add(taskListener);

		collectTasks();
	}

	@Dispose
	public void dispose()
	{
		taskPkg.eAdapters().remove(taskListener);
	}

	@SuppressWarnings("unchecked")
	private void collectTasks()
	{
		allocationList.clear();
		taskWrappers.clear();

		final var tasks = taskPkg.getTasks();
		for (int i = 0; i < tasks.size(); i++)
		{
			final var task = tasks.get(i);
			final var adapter = IAllocationAdapter.adapt(task);
			if (adapter != null)
			{
				allocationList.add((IAllocationObject<? super T>) adapter);
			}

			taskWrappers.add(new TaskWrapper<>(task));
		}

		taskListDirty = false;
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
	public void allocate(MemoryStack stack, T context)
	{
		vkPipelineLayout = createVkPipelineLayout();
		vkPipelineLayout.allocate(stack, context);
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
		allocationDependencies.clear();
	}

	@Override
	public boolean isAllocationDirty(T context)
	{
		boolean res = false;

		for (int i = 0; i < allocationDependencies.size(); i++)
		{
			final var dependency = allocationDependencies.get(i);
			if (dependency.isAllocationDirty(context))
			{
				res = true;
				break;
			}
		}

		return res;
	}

	@Override
	public void update()
	{
		if (taskListDirty)
		{
			collectTasks();
		}

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
			vkPipelines.get(0).bindPipeline(context.commandBuffer, context.bindPoint);
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
				collectIn.add(adapter);
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

	@Override
	public List<? extends IAllocationObject<? super T>> getAllocationChildren()
	{
		return allocationList;
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
