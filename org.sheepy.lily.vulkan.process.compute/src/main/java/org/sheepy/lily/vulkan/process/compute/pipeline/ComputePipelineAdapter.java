package org.sheepy.lily.vulkan.process.compute.pipeline;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.process.IComputeContext;
import org.sheepy.lily.vulkan.api.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.Computer;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;

@Statefull
@Adapter(scope = ComputePipeline.class)
public final class ComputePipelineAdapter extends AbstractPipelineAdapter<IComputeContext>
{
	protected final ComputePipeline pipeline;

	private final List<VkComputePipeline> vkPipelines = new ArrayList<>();

	public ComputePipelineAdapter(ComputePipeline pipeline)
	{
		super(pipeline);
		this.pipeline = pipeline;
	}

	@Override
	public void allocate(MemoryStack stack, IComputeContext context)
	{
		super.allocate(stack, context);

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
				final var shaderAdapter = IShaderAdapter.adapt(shader);
				final var computerAdapter = (ComputerAdapter) IPipelineTaskAdapter.adapt(computer);

				final var vkPipeline = new VkComputePipeline(getVkPipelineLayout(), shaderAdapter);
				vkPipeline.allocate(stack, context);
				vkPipelines.add(vkPipeline);

				computerAdapter.setVkPipeline(vkPipeline);
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
	public void free(IComputeContext context)
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

	public static ComputePipelineAdapter adapt(ComputePipeline object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, ComputePipelineAdapter.class);
	}

	@Override
	public List<VkComputePipeline> getVkPipelines()
	{
		return vkPipelines;
	}
}
