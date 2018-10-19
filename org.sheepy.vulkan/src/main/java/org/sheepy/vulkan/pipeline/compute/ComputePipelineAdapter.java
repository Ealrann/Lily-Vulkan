package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.execution.compute.ComputeCommandBuffer;
import org.sheepy.vulkan.model.process.ComputePipeline;
import org.sheepy.vulkan.model.process.Computer;
import org.sheepy.vulkan.pipeline.AbstractPipelineAdapter;
import org.sheepy.vulkan.processpool.compute.IComputeContextAdapter;
import org.sheepy.vulkan.resource.shader.ShaderAdapter;
import org.sheepy.vulkan.util.Logger;

public class ComputePipelineAdapter extends AbstractPipelineAdapter<ComputeCommandBuffer>
{
	private int groupCountX;
	private int groupCountY;
	private int groupCountZ;

	private boolean dirty = false;
	private long[] pipelines;

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		super.deepAllocate(stack);

		var context = IComputeContextAdapter.adapt(target).getComputeContext();
		var device = context.getVkDevice();
		var computePipeline = (ComputePipeline) target;
		var computers = computePipeline.getComputers();
		int size = computers.size();

		var pipelineCreateInfos = VkComputePipelineCreateInfo.callocStack(size, stack);
		var shaderInfo = VkPipelineShaderStageCreateInfo.calloc();
		
		for (Computer computer : computers)
		{
			var shader = computer.getShader();
			var shaderAdapter = ShaderAdapter.adapt(shader);
			
			shaderAdapter.fillInfo(shaderInfo);

			var pipelineCreateInfo = pipelineCreateInfos.get();
			pipelineCreateInfo.sType(VK_STRUCTURE_TYPE_COMPUTE_PIPELINE_CREATE_INFO);
			pipelineCreateInfo.stage(shaderInfo);
			pipelineCreateInfo.layout(pipelineLayout);
		}
		shaderInfo.free();
		
		pipelineCreateInfos.flip();

		pipelines = new long[size];
		Logger.check("Failed to create compute pipeline!",
				() -> vkCreateComputePipelines(device, 0, pipelineCreateInfos, null, pipelines));

		groupCountX = (int) Math.ceil((float) computePipeline.getWidth() / computePipeline.getWorkgroupSizeX());
		groupCountY = (int) Math.ceil((float) computePipeline.getHeight() / computePipeline.getWorkgroupSizeY());
		groupCountZ = (int) Math.ceil((float) computePipeline.getDepth() / computePipeline.getWorkgroupSizeZ());
	}

	@Override
	public void free()
	{
		final var vkDevice = ILogicalDeviceAdapter.adapt(target).getVkDevice();

		for (long id : pipelines)
		{
			vkDestroyPipeline(vkDevice, id, null);
		}

		super.free();
	}

	public long getPipelineId(int index)
	{
		return pipelines[index];
	}

	@Override
	public void record(ComputeCommandBuffer commandBuffer, int bindPoint)
	{
		super.record(commandBuffer, bindPoint);
		
		var computePipeline = (ComputePipeline) target;

		if (computePipeline.isEnabled())
		{
			for (final Computer computer : computePipeline.getComputers())
			{
				final var adapter = ComputerAdapter.adapt(computer);
				adapter.record(commandBuffer, bindPoint);
			}
			dirty = false;
		}
	}

	@Override
	public boolean isDirty()
	{
		return dirty;
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

	public static ComputePipelineAdapter adapt(ComputePipeline object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, ComputePipelineAdapter.class);
	}
}
