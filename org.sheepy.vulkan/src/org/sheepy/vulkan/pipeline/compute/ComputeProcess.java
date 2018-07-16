package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.vulkan.command.compute.ComputeCommandBuffer;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.DescriptorSet;
import org.sheepy.vulkan.device.LogicalDevice;

/**
 * A set of ComputePipeline.
 * 
 * @author ealrann
 *
 */
public class ComputeProcess extends AllocationNode
{
	protected List<ComputePipeline> computePipelines = new ArrayList<>();
	private List<IAllocable> children = new ArrayList<>();

	protected DescriptorPool descriptorPool;

	public ComputeProcess(LogicalDevice logicalDevice, List<ComputePipeline> computePipeline)
	{
		this.computePipelines.addAll(computePipeline);

		descriptorPool = new DescriptorPool(logicalDevice, computePipelines);

		children.add(descriptorPool);
		children.addAll(computePipelines);
	}

	public ComputeProcess(LogicalDevice logicalDevice)
	{
		this(logicalDevice, Collections.emptyList());
	}

	public void addPipeline(ComputePipeline pipeline)
	{
		computePipelines.add(pipeline);
		descriptorPool.addConfiguration(pipeline);
		children.add(pipeline);
	}

	public void recordCommand(ComputeCommandBuffer commandBuffer)
	{
		LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(1);
		for (ComputePipeline pipeline : computePipelines)
		{
			if (pipeline.isEnabled())
			{
				long pipelineLayout = pipeline.getPipelineLayout();

				int dataWidth = pipeline.getDataWidth();
				int dataHeight = pipeline.getDataHeight();
				int dataDepth = pipeline.getDataDepth();

				float workgroupSize = pipeline.getWorkgroupSize();

				if (descriptorPool != null)
				{
					DescriptorSet descriptorSet = descriptorPool.getDescriptorSet(pipeline);

					bDescriptorSet.put(descriptorSet.getId());
					bDescriptorSet.flip();

					vkCmdBindDescriptorSets(commandBuffer.getVkCommandBuffer(),
							VK_PIPELINE_BIND_POINT_COMPUTE, pipelineLayout, 0, bDescriptorSet,
							null);
				}

				long[] pipelines = pipeline.getId();
				for (long pipelineId : pipelines)
				{
					vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(),
							VK_PIPELINE_BIND_POINT_COMPUTE, pipelineId);
					
					vkCmdDispatch(commandBuffer.getVkCommandBuffer(),
							(int) Math.ceil(dataWidth / workgroupSize),
							(int) Math.ceil(dataHeight / workgroupSize),
							(int) Math.ceil(dataDepth / workgroupSize));
				}
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
