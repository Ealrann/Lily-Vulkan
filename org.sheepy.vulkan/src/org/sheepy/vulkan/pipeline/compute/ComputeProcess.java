package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.VK_PIPELINE_BIND_POINT_COMPUTE;
import static org.lwjgl.vulkan.VK10.vkCmdBindDescriptorSets;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.vulkan.command.compute.ComputeCommandBuffer;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.DescriptorSet;
import org.sheepy.vulkan.descriptor.IDescriptorSetConfiguration;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.IPipelineExecutable;
import org.sheepy.vulkan.pipeline.PipelineBarrier;

/**
 * A set of ComputePipelines.
 * 
 * @author ealrann
 *
 */
public class ComputeProcess extends AllocationNode
{
	protected final List<IComputeProcessUnit> computePipelines = new ArrayList<>();

	protected DescriptorPool descriptorPool;

	public ComputeProcess(LogicalDevice logicalDevice)
	{
		this(logicalDevice, Collections.emptyList());
	}

	public ComputeProcess(LogicalDevice logicalDevice, List<IComputeProcessUnit> units)
	{
		this.computePipelines.addAll(units);

		descriptorPool = new DescriptorPool(logicalDevice);
		allocationObjects.add(descriptorPool);

		for (IComputeProcessUnit unit : units)
		{
			if (unit instanceof IDescriptorSetConfiguration)
			{
				descriptorPool.addConfiguration((IDescriptorSetConfiguration) unit);
			}
			if (unit instanceof IAllocationObject)
			{
				allocationObjects.add((IAllocationObject) unit);
			}
		}
	}

	public void addProcessUnit(IComputeProcessUnit unit)
	{
		computePipelines.add(unit);

		if (unit instanceof IDescriptorSetConfiguration)
		{
			descriptorPool.addConfiguration((IDescriptorSetConfiguration) unit);
		}
		if (unit instanceof IAllocationObject)
		{
			allocationObjects.add((IAllocationObject) unit);
		}
	}

	public void recordCommand(ComputeCommandBuffer commandBuffer)
	{
		for (IComputeProcessUnit unit : computePipelines)
		{
			if (unit instanceof ComputePipeline)
			{
				ComputePipeline pipeline = (ComputePipeline) unit;
				if (pipeline.isEnabled())
				{
					recordComputePipeline(commandBuffer, pipeline);
				}
				pipeline.setDirty(false);
			}
			else if (unit instanceof PipelineBarrier)
			{
				((PipelineBarrier) unit).execute(commandBuffer.getVkCommandBuffer());
			}
		}
	}

	private void recordComputePipeline(ComputeCommandBuffer commandBuffer, ComputePipeline pipeline)
	{
		LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(1);
		long pipelineLayout = pipeline.getLayoutId();

		if (descriptorPool != null)
		{
			DescriptorSet descriptorSet = descriptorPool.getDescriptorSet(pipeline);

			bDescriptorSet.put(descriptorSet.getId());
			bDescriptorSet.flip();

			vkCmdBindDescriptorSets(commandBuffer.getVkCommandBuffer(),
					VK_PIPELINE_BIND_POINT_COMPUTE, pipelineLayout, 0, bDescriptorSet, null);
		}

		List<IPipelineExecutable> executables = pipeline.getExecutables();
		for (int i = 0; i < executables.size(); i++)
		{
			IPipelineExecutable executable = executables.get(i);

			executable.execute(commandBuffer.getVkCommandBuffer());
		}

		MemoryUtil.memFree(bDescriptorSet);
	}

	public DescriptorPool getDescriptorPool()
	{
		return descriptorPool;
	}

	public boolean isDirty()
	{
		for (IComputeProcessUnit unit : computePipelines)
		{
			if (unit instanceof ComputePipeline && ((ComputePipeline) unit).isDirty())
			{
				return true;
			}
		}

		return false;
	}

}
