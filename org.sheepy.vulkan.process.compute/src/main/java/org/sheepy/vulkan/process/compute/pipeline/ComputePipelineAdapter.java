package org.sheepy.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkComputePipelineCreateInfo;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.process.IPipelineUnit;
import org.sheepy.vulkan.model.process.compute.ComputePackage;
import org.sheepy.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.vulkan.model.process.compute.Computer;
import org.sheepy.vulkan.model.resource.AbstractConstants;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.process.compute.execution.ComputeCommandBuffer;
import org.sheepy.vulkan.process.compute.process.IComputeContextAdapter;
import org.sheepy.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.vulkan.process.pipeline.IPipelineUnitAdapter;
import org.sheepy.vulkan.resource.shader.ShaderAdapter;

public class ComputePipelineAdapter extends AbstractPipelineAdapter<ComputeCommandBuffer>
{
	private int groupCountX;
	private int groupCountY;
	private int groupCountZ;

	private long[] pipelines;

	protected ComputePipeline pipeline;

	@Override
	public void setTarget(Notifier target)
	{
		pipeline = (ComputePipeline) target;
		super.setTarget(target);
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		super.deepAllocate(stack);

		var context = IComputeContextAdapter.adapt(target).getComputeContext(target);
		var device = context.getVkDevice();
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
				() -> vkCreateComputePipelines(device, 0, pipelineCreateInfos, null, pipelines));

		groupCountX = (int) Math.ceil((float) pipeline.getWidth() / pipeline.getWorkgroupSizeX());
		groupCountY = (int) Math.ceil((float) pipeline.getHeight() / pipeline.getWorkgroupSizeY());
		groupCountZ = (int) Math.ceil((float) pipeline.getDepth() / pipeline.getWorkgroupSizeZ());
	}

	@Override
	public void free()
	{
		final var vkDevice = ILogicalDeviceAdapter.adapt(target).getVkDevice(target);

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
		recordDescriptors(commandBuffer, bindPoint);
		recordComputers(commandBuffer, bindPoint);
	}

	protected void recordComputers(ComputeCommandBuffer commandBuffer, int bindPoint)
	{
		for (final IPipelineUnit computer : pipeline.getUnits())
		{
			final var adapter = IPipelineUnitAdapter.adapt(computer);
			adapter.record(commandBuffer, bindPoint);
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
	protected AbstractConstants getConstants()
	{
		return ((ComputePipeline) target).getConstants();
	}

	@Override
	protected DescriptorSet getDescriptorSet()
	{
		return ((ComputePipeline) target).getDescriptorSet();
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ComputePackage.Literals.COMPUTE_PIPELINE == eClass;
	}

	public static ComputePipelineAdapter adapt(ComputePipeline object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, ComputePipelineAdapter.class);
	}
}
