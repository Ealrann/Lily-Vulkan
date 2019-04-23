package org.sheepy.lily.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3i;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.model.process.IPipelineUnit;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.Computer;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineUnitAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.log.Logger;

@Statefull
@Adapter(scope = ComputePipeline.class)
public class ComputePipelineAdapter extends AbstractPipelineAdapter
{
	protected final ComputePipeline pipeline;

	private final List<IPipelineUnitAdapter> pipelinesAdapters = new ArrayList<>();

	private final Vector3i groupCount = new Vector3i();

	private long[] pipelines;

	public ComputePipelineAdapter(ComputePipeline pipeline)
	{
		super(pipeline);
		this.pipeline = pipeline;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		super.allocate(stack, context);

		final var processContext = (ProcessContext) context;
		final var vkDevice = processContext.getVkDevice();
		final var units = pipeline.getUnits();
		int size = 0;

		groupCount.x = (int) Math.ceil((float) pipeline.getWidth() / pipeline.getWorkgroupSizeX());
		groupCount.y = (int) Math.ceil((float) pipeline.getHeight() / pipeline.getWorkgroupSizeY());
		groupCount.z = (int) Math.ceil((float) pipeline.getDepth() / pipeline.getWorkgroupSizeZ());

		for (int i = 0; i < units.size(); i++)
		{
			final IPipelineUnit unit = units.get(i);
			if (unit instanceof Computer)
			{
				size++;
			}

			pipelinesAdapters.add(IPipelineUnitAdapter.adapt(unit));
		}

		final var pipelineCreateInfos = VkComputePipelineCreateInfo.callocStack(size, stack);
		final var shaderInfo = VkPipelineShaderStageCreateInfo.calloc();

		int index = 0;
		for (int i = 0; i < units.size(); i++)
		{
			final IPipelineUnit unit = units.get(i);
			if (unit instanceof Computer)
			{
				final var computer = (Computer) unit;
				final var shader = computer.getShader();
				final IShaderAdapter shaderAdapter = IShaderAdapter.adapt(shader);

				shaderAdapter.fillInfo(shaderInfo);

				final var adapter = (ComputerAdapter) pipelinesAdapters.get(i);

				adapter.setIndex(index);
				adapter.setGroupCount(groupCount);
				index++;

				final var pipelineCreateInfo = pipelineCreateInfos.get();
				pipelineCreateInfo.sType(VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO);
				pipelineCreateInfo.stage(shaderInfo);
				pipelineCreateInfo.layout(getPipelineLayout());
			}
		}
		shaderInfo.free();

		pipelineCreateInfos.flip();

		pipelines = new long[size];
		Logger.check("Failed to create compute pipeline!",
				() -> vkCreateComputePipelines(vkDevice, 0, pipelineCreateInfos, null, pipelines));
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var processContext = (ProcessContext) context;
		final var vkDevice = processContext.getVkDevice();
		for (final long id : pipelines)
		{
			vkDestroyPipeline(vkDevice, id, null);
		}

		pipelines = null;

		pipelinesAdapters.clear();

		super.free(context);
	}

	public long getPipelineId(int index)
	{
		return pipelines[index];
	}

	@Override
	public void record(VkCommandBuffer commandBuffer, int bindPoint, int index)
	{
		bindDescriptor(commandBuffer, bindPoint, new Integer[] {
				0
		});
		recordComputers(commandBuffer, bindPoint);
	}

	protected void recordComputers(VkCommandBuffer commandBuffer, int bindPoint)
	{
		final var units = pipeline.getUnits();
		for (int i = 0; i < units.size(); i++)
		{
			final IPipelineUnit unit = units.get(i);
			final var adapter = pipelinesAdapters.get(i);
			adapter.record(unit, commandBuffer, bindPoint);
		}
	}

	public Vector3i getGroupCount()
	{
		return groupCount;
	}

	@Override
	public AbstractConstants getConstants()
	{
		return pipeline.getConstants();
	}

	public static ComputePipelineAdapter adapt(ComputePipeline object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, ComputePipelineAdapter.class);
	}
}
