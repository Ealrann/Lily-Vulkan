package org.sheepy.lily.vulkan.process.compute.pipeline;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.Computer;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;

@Statefull
@Adapter(scope = ComputePipeline.class)
public final class ComputePipelineAdapter extends AbstractPipelineAdapter<IProcessContext>
{
	protected final ComputePipeline pipeline;

	private final List<VkComputePipeline> vkPipelines = new ArrayList<>();

	public ComputePipelineAdapter(ComputePipeline pipeline)
	{
		super(pipeline);
		this.pipeline = pipeline;
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
				final ByteBuffer specializationData = pipeline.getSpecializationData();

				final var vkPipeline = new VkComputePipeline(	getVkPipelineLayout(),
																shaderStage,
																specializationData);
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
