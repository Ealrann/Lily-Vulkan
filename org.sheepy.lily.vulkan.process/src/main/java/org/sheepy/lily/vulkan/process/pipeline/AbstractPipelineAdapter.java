package org.sheepy.lily.vulkan.process.pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.core.api.util.AbstractModelSetRegistry;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelExplorer;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.resource.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.pipeline.VkPipelineLayout;

@Statefull
public abstract class AbstractPipelineAdapter<T extends IProcessContext>
		implements IAllocableAdapter<T>, IPipelineAdapter<T>
{
	private static final ModelExplorer RESOURCE_EXPLORER = new ModelExplorer(List.of(	VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																						VulkanPackage.Literals.RESOURCE_PKG__RESOURCES));
	private static final ModelExplorer DERSCRIPTOR_SET_EXPLORER = new ModelExplorer(List.of(ProcessPackage.Literals.IPIPELINE__DESCRIPTOR_SET_PKG,
																							ResourcePackage.Literals.DESCRIPTOR_SET_PKG__DESCRIPTOR_SETS));

	private final TaskObserver taskRegister = new TaskObserver(List.of(	ProcessPackage.Literals.IPIPELINE__TASK_PKG,
																		ProcessPackage.Literals.TASK_PKG__TASKS));

	protected final IPipeline pipeline;

	private final List<TaskWrapper<?>> taskWrappers = new ArrayList<>();
	private VkPipelineLayout<? super T> vkPipelineLayout;
	private boolean recordNeeded = false;

	private IAllocationConfiguration allocationConfig;

	public AbstractPipelineAdapter(IPipeline pipeline)
	{
		this.pipeline = pipeline;
	}

	@Override
	public void configureAllocation(IAllocationConfiguration config, T context)
	{
		this.allocationConfig = config;
		taskRegister.startRegister(pipeline);
	}

	@Dispose
	public void dispose()
	{
		taskRegister.stopRegister(pipeline);
	}

	@NotifyChanged(featureIds = ProcessPackage.IPIPELINE__ENABLED)
	public void notifyChanged(Notification notification)
	{
		if (notification.getOldBooleanValue() != notification.getNewBooleanValue())
		{
			recordNeeded = true;
		}
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
	public final void record(RecordContext context, ECommandStage stage)
	{
		if (isActive() && shouldRecord(stage))
		{
			recordInternal(context);
		}
	}

	private final void recordInternal(RecordContext context)
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
		RESOURCE_EXPLORER	.streamAdapt(pipeline, IResourceAdapter.class)
							.collect(Collectors.toCollection(() -> collectIn));
	}

	@Override
	public void collectDescriptorSets(List<IVkDescriptorSet> collectIn)
	{
		DERSCRIPTOR_SET_EXPLORER.streamAdaptNotNull(pipeline, IDescriptorSetAdapter.class)
								.collect(Collectors.toCollection(() -> collectIn));
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

	private final class TaskObserver extends AbstractModelSetRegistry
	{
		public TaskObserver(List<EStructuralFeature> features)
		{
			super(features);
		}

		@Override
		protected void add(LilyEObject newValue)
		{
			final var task = (IPipelineTask) newValue;
			taskWrappers.add(new TaskWrapper<>(task));

			final var adapter = task.<IAllocableAdapter<?>> adaptGeneric(IAllocableAdapter.class);
			if (adapter != null)
			{
				allocationConfig.addChildren(List.of(adapter));
				allocationConfig.setDirty();
			}
		}

		@SuppressWarnings("unlikely-arg-type")
		@Override
		protected void remove(LilyEObject oldValue)
		{
			final var task = (IPipelineTask) oldValue;
			taskWrappers.remove(task);

			final var adapter = task.<IAllocableAdapter<?>> adaptGeneric(IAllocableAdapter.class);
			if (adapter != null)
			{
				allocationConfig.removeChildren(List.of(adapter));
				allocationConfig.setDirty();
			}
		}
	}

	private static final class TaskWrapper<T extends IPipelineTask>
	{
		private final T task;
		private final IPipelineTaskAdapter<T> adapter;

		public TaskWrapper(T task)
		{
			this.task = task;
			adapter = task.<IPipelineTaskAdapter<T>> adaptNotNullGeneric(IPipelineTaskAdapter.class);
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

		@Override
		public boolean equals(Object o)
		{
			return task == o || super.equals(o);
		}
	}
}
