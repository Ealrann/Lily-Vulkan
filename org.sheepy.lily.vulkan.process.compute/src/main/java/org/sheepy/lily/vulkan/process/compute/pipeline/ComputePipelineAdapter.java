package org.sheepy.lily.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3i;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.model.process.IPipelineUnit;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.Computer;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineUnitAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.resource.shader.ShaderAdapter;

@Statefull
@Adapter(scope = ComputePipeline.class)
public class ComputePipelineAdapter extends AbstractPipelineAdapter<ComputeCommandBuffer>
{
	protected final ComputePipeline pipeline;

	private final List<IPipelineUnitAdapter<ComputeCommandBuffer>> pipelinesAdapters = new ArrayList<>();

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

		var processContext = (ProcessContext) context;
		var vkDevice = processContext.getVkDevice();
		var units = pipeline.getUnits();
		int size = 0;

		groupCount.x = (int) Math.ceil((float) pipeline.getWidth() / pipeline.getWorkgroupSizeX());
		groupCount.y = (int) Math.ceil((float) pipeline.getHeight() / pipeline.getWorkgroupSizeY());
		groupCount.z = (int) Math.ceil((float) pipeline.getDepth() / pipeline.getWorkgroupSizeZ());

		for (int i = 0; i < units.size(); i++)
		{
			IPipelineUnit unit = units.get(i);
			if (unit instanceof Computer)
			{
				size++;
			}

			pipelinesAdapters.add(IPipelineUnitAdapter.adapt(unit));
		}

		var pipelineCreateInfos = VkComputePipelineCreateInfo.callocStack(size, stack);
		var shaderInfo = VkPipelineShaderStageCreateInfo.calloc();

		int index = 0;
		for (int i = 0; i < units.size(); i++)
		{
			IPipelineUnit unit = units.get(i);
			if (unit instanceof Computer)
			{
				var computer = (Computer) unit;
				var shader = computer.getShader();
				var shaderAdapter = ShaderAdapter.adapt(shader);

				shaderAdapter.fillInfo(shaderInfo);

				final var adapter = (ComputerAdapter) pipelinesAdapters.get(i);

				adapter.setIndex(index);
				adapter.setGroupCount(groupCount);
				index++;

				var pipelineCreateInfo = pipelineCreateInfos.get();
				pipelineCreateInfo.sType(VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO);
				pipelineCreateInfo.stage(shaderInfo);
				pipelineCreateInfo.layout(pipelineLayout);
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
		var processContext = (ProcessContext) context;
		var vkDevice = processContext.getVkDevice();
		for (long id : pipelines)
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
	public void record(ComputeCommandBuffer commandBuffer, int bindPoint)
	{
		bindDescriptor(commandBuffer, bindPoint, 0);
		recordComputers(commandBuffer, bindPoint);
	}

	protected void recordComputers(ComputeCommandBuffer commandBuffer, int bindPoint)
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

	@Override
	public List<IVkDescriptorSet> getDescriptorSets()
	{
		List<IVkDescriptorSet> res = new ArrayList<>();
		var ds = pipeline.getDescriptorSet();
		if (ds != null)
		{
			var adapter = IDescriptorSetAdapter.adapt(ds);
			res.add(adapter);
		}
		return res;
	}

	public static ComputePipelineAdapter adapt(ComputePipeline object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, ComputePipelineAdapter.class);
	}
}
