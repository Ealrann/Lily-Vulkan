package org.sheepy.lily.game.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.joml.Vector3i;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.game.vulkan.command.compute.ComputeCommandBuffer;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorSet;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

/**
 * A set of ComputePipeline.
 * 
 * @author ealrann
 *
 */
public class ComputeProcess
{
	private static final float WORKGROUP_SIZE = 32f;

	private LogicalDevice logicalDevice;
	private List<ComputePipeline> computePipelines = new ArrayList<>();

	protected DescriptorPool descriptorPool;

	public ComputeProcess(LogicalDevice logicalDevice, List<ComputePipeline> computePipeline)
	{
		this.logicalDevice = logicalDevice;
		this.computePipelines.addAll(computePipeline);

		descriptorPool = new DescriptorPool(logicalDevice);
	}

	public ComputeProcess(LogicalDevice logicalDevice)
	{
		this(logicalDevice, Collections.emptyList());
	}

	public void addPipeline(ComputePipeline pipeline)
	{
		computePipelines.add(pipeline);
	}

	public void addNewPipeline(IComputer computer)
	{
		addPipeline(new ComputePipeline(logicalDevice, computer));
	}

	public void load(MemoryStack stack)
	{
		descriptorPool.load(stack, computePipelines);

		for (ComputePipeline pipeline : computePipelines)
		{
			pipeline.load(descriptorPool.getDescriptorSet(pipeline));
		}
	}

	public void free()
	{
		if (descriptorPool != null) descriptorPool.destroy();

		for (ComputePipeline pipeline : computePipelines)
		{
			pipeline.free();
		}
	}

	public void recordCommand(ComputeCommandBuffer commandBuffer)
	{
		for (ComputePipeline pipeline : computePipelines)
		{
			long pipelineLayout = pipeline.getPipelineLayout();

			int dataWidth = pipeline.getDataWidth();
			int dataHeight = pipeline.getDataHeight();
			int dataDepth = pipeline.getDataDepth();

			Vector3i groupCount = new Vector3i((int) Math.ceil(dataWidth / WORKGROUP_SIZE),
					(int) Math.ceil(dataHeight / WORKGROUP_SIZE),
					(int) Math.ceil(dataDepth / WORKGROUP_SIZE));

			if (descriptorPool != null)
			{
				DescriptorSet descriptorSet = descriptorPool.getDescriptorSet(pipeline);

				LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(1);
				bDescriptorSet.put(descriptorSet.getId());
				bDescriptorSet.flip();

				vkCmdBindDescriptorSets(commandBuffer.getVkCommandBuffer(),
						VK_PIPELINE_BIND_POINT_COMPUTE, pipelineLayout, 0, bDescriptorSet, null);

				MemoryUtil.memFree(bDescriptorSet);
			}

			vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(), VK_PIPELINE_BIND_POINT_COMPUTE,
					pipeline.getId());

			vkCmdDispatch(commandBuffer.getVkCommandBuffer(), groupCount.x, groupCount.y,
					groupCount.z);
		}
	}

	public List<ComputePipeline> getPipelines()
	{
		return computePipelines;
	}

	public DescriptorPool getDescriptorPool()
	{
		return descriptorPool;
	}

}
