package org.sheepy.lily.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

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

	private int groupCountX;
	private int groupCountY;
	private int groupCountZ;

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

		for (IPipelineUnit unit : units)
		{
			if (unit instanceof Computer)
			{
				size++;
			}
		}

		var pipelineCreateInfos = VkComputePipelineCreateInfo.callocStack(size, stack);
		var shaderInfo = VkPipelineShaderStageCreateInfo.calloc();

		int index = 0;
		for (IPipelineUnit unit : units)
		{
			if (unit instanceof Computer)
			{
				var computer = (Computer) unit;
				var shader = computer.getShader();
				var shaderAdapter = ShaderAdapter.adapt(shader);

				shaderAdapter.fillInfo(shaderInfo);

				final var adapter = ComputerAdapter.adapt(computer);

				adapter.setIndex(index);
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

		groupCountX = (int) Math.ceil((float) pipeline.getWidth() / pipeline.getWorkgroupSizeX());
		groupCountY = (int) Math.ceil((float) pipeline.getHeight() / pipeline.getWorkgroupSizeY());
		groupCountZ = (int) Math.ceil((float) pipeline.getDepth() / pipeline.getWorkgroupSizeZ());
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
		for (final IPipelineUnit computer : pipeline.getUnits())
		{
			final var adapter = IPipelineUnitAdapter.adapt(computer);
			adapter.record(computer, commandBuffer, bindPoint);
		}
	}

	public int getGroupCountX()
	{
		return groupCountX;
	}

	public int getGroupCountY()
	{
		return groupCountY;
	}

	public int getGroupCountZ()
	{
		return groupCountZ;
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
