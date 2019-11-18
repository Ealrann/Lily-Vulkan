package org.sheepy.lily.vulkan.process.compute.pipeline;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.core.api.util.ModelSetObserver;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.Computer;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;

@Statefull
@Adapter(scope = ComputePipeline.class)
public final class ComputePipelineAdapter extends AbstractPipelineAdapter<IProcessContext>
{
	private static final List<EStructuralFeature> TASK_FEATURES = List.of(	ProcessPackage.Literals.IPIPELINE__TASK_PKG,
																			ProcessPackage.Literals.TASK_PKG__TASKS);
	private final ComputePipeline pipeline;
	private final List<VkComputePipeline> vkPipelines = new ArrayList<>();
	private final ModelSetObserver taskObserver;
	private final INotificationListener taskListener = this::taskChanged;

	private IAllocationConfiguration config;

	public ComputePipelineAdapter(ComputePipeline pipeline)
	{
		super(pipeline);
		this.pipeline = pipeline;
		taskObserver = new ModelSetObserver(taskListener, TASK_FEATURES);
	}

	@Override
	public void dispose()
	{
		super.dispose();
		taskObserver.stopObserve(pipeline);
	}

	private void taskChanged(Notification notification)
	{
		config.setDirty();
	}

	@Override
	public void configureAllocation(IAllocationConfiguration config, IProcessContext context)
	{
		this.config = config;
		taskObserver.startObserve(pipeline);
		super.configureAllocation(config, context);
	}

	@Override
	public void allocate(IProcessContext context)
	{
		super.allocate(context);

		final var tasks = pipeline.getTaskPkg().getTasks();

		final Deque<IPipelineTask> course = new ArrayDeque<>();
		course.addAll(tasks);
		while (course.isEmpty() == false)
		{
			final IPipelineTask task = course.removeFirst();
			if (task instanceof Computer)
			{
				final var computer = (Computer) task;
				final var shader = computer.getShader();
				final var shaderAdapter = shader.adaptNotNull(IShaderAdapter.class);
				final var shaderStage = shaderAdapter.getVkShaderStage();
				final var specializationData = pipeline.getSpecializationData();
				final var specializationBuffer = specializationData != null
						? specializationData.getData()
						: null;

				final var vkPipeline = new VkComputePipeline(	getVkPipelineLayout(),
																shaderStage,
																specializationBuffer);
				vkPipeline.allocate(context);
				vkPipelines.add(vkPipeline);
			}
			else if (task instanceof CompositeTask)
			{
				final var subTasks = ((CompositeTask) task).getTasks();
				for (int i = subTasks.size(); i > 0; i--)
				{
					final var subTask = subTasks.get(i - 1);
					course.addFirst(subTask);
				}
			}
		}
	}

	@Override
	public void free(IProcessContext context)
	{
		for (final var pipeline : vkPipelines)
		{
			pipeline.free(context);
		}
		vkPipelines.clear();

		super.free(context);
	}

	public long getPipelineId(int index)
	{
		return vkPipelines.get(index).getPipelineId();
	}

	@Override
	public List<VkComputePipeline> getVkPipelines()
	{
		return vkPipelines;
	}
}
