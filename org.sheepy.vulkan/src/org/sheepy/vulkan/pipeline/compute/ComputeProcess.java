package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.vulkan.command.compute.ComputeCommandBuffer;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.DescriptorSet;
import org.sheepy.vulkan.descriptor.IDescriptorSetConfiguration;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.compute.ComputePipeline.ComputePipelineId;
import org.sheepy.vulkan.pipeline.compute.ComputePipeline.IComputePipelineExecutableUnit;

/**
 * A set of ComputePipeline.
 * 
 * @author ealrann
 *
 */
public class ComputeProcess extends AllocationNode
{
	protected List<IComputeProcessUnit> computePipelines = new ArrayList<>();
	protected List<IAllocable> children = new ArrayList<>();

	protected DescriptorPool descriptorPool;

	public ComputeProcess(LogicalDevice logicalDevice, List<IComputeProcessUnit> units)
	{
		this.computePipelines.addAll(units);

		descriptorPool = new DescriptorPool(logicalDevice);
		children.add(descriptorPool);

		for (IComputeProcessUnit unit : units)
		{
			if (unit instanceof IDescriptorSetConfiguration)
			{
				descriptorPool.addConfiguration((IDescriptorSetConfiguration) unit);
			}
			if (unit instanceof IAllocable)
			{
				children.add((IAllocable) unit);
			}
		}
	}

	public ComputeProcess(LogicalDevice logicalDevice)
	{
		this(logicalDevice, Collections.emptyList());
	}

	public void addProcessUnit(IComputeProcessUnit unit)
	{
		computePipelines.add(unit);

		if (unit instanceof IDescriptorSetConfiguration)
		{
			descriptorPool.addConfiguration((IDescriptorSetConfiguration) unit);
		}
		if (unit instanceof IAllocable)
		{
			children.add((IAllocable) unit);
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
			}
			else if (unit instanceof PipelineBarrier)
			{
				recordBarrier(commandBuffer, (PipelineBarrier) unit);
			}
		}
	}

	private void recordBarrier(ComputeCommandBuffer commandBuffer, PipelineBarrier unit)
	{
		VkBufferMemoryBarrier.Buffer barrierInfo = VkBufferMemoryBarrier.calloc(1);

		barrierInfo.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		barrierInfo.buffer(unit.getBuffer().getId());
		barrierInfo.srcAccessMask(unit.getSrcAccessMask());
		barrierInfo.dstAccessMask(unit.getDstAccessMask());
		barrierInfo.offset(0);
		barrierInfo.size(VK_WHOLE_SIZE);

		vkCmdPipelineBarrier(commandBuffer.getVkCommandBuffer(),
				VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT, VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT, 0, null,
				barrierInfo, null);
		
		barrierInfo.free();
	}

	private void recordComputePipeline(ComputeCommandBuffer commandBuffer,
			ComputePipeline pipeline)
	{
		LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(1);
		long pipelineLayout = pipeline.getPipelineLayout();

		float workgroupSize = pipeline.getWorkgroupSize();

		int groupCountX = (int) Math.ceil(pipeline.getDataWidth() / workgroupSize);
		int groupCountY = (int) Math.ceil(pipeline.getDataHeight() / workgroupSize);
		int groupCountZ = (int) Math.ceil(pipeline.getDataDepth() / workgroupSize);

		if (descriptorPool != null)
		{
			DescriptorSet descriptorSet = descriptorPool.getDescriptorSet(pipeline);

			bDescriptorSet.put(descriptorSet.getId());
			bDescriptorSet.flip();

			vkCmdBindDescriptorSets(commandBuffer.getVkCommandBuffer(),
					VK_PIPELINE_BIND_POINT_COMPUTE, pipelineLayout, 0, bDescriptorSet, null);
		}

		List<IComputePipelineExecutableUnit> executables = pipeline.getExecutablesUnit();
		for (IComputePipelineExecutableUnit executable : executables)
		{
			if (executable instanceof ComputePipelineId)
			{
				vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(),
						VK_PIPELINE_BIND_POINT_COMPUTE, ((ComputePipelineId) executable).id);

				vkCmdDispatch(commandBuffer.getVkCommandBuffer(), groupCountX, groupCountY,
						groupCountZ);
			}
			else if (executable instanceof PipelineBarrier)
			{
				recordBarrier(commandBuffer, (PipelineBarrier) executable);
			}
		}
		MemoryUtil.memFree(bDescriptorSet);
	}

	public DescriptorPool getDescriptorPool()
	{
		return descriptorPool;
	}

	@Override
	protected Collection<? extends IAllocationObject> getSubAllocables()
	{
		return children;
	}

}
