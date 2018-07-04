package org.sheepy.lily.game.vulkan.command.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joml.Vector3i;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.game.vulkan.command.AbstractCommandBuffers;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorSet;
import org.sheepy.lily.game.vulkan.pipeline.compute.ComputePipeline;
import org.sheepy.lily.game.vulkan.pipeline.compute.ComputeProcess;

public class ComputeCommandBuffers extends AbstractCommandBuffers<ComputeCommandBuffer>
{
	private static final float WORKGROUP_SIZE = 32f;

	private ComputeProcess[] computeProcesses;

	private Map<ComputeProcess, ComputeCommandBuffer> mapBuffers = new HashMap<>();

	public ComputeCommandBuffers(CommandPool commandPool, List<ComputeProcess> computeProcesses)
	{
		super(commandPool);
		this.computeProcesses = computeProcesses.toArray(new ComputeProcess[0]);
	}

	@Override
	protected List<ComputeCommandBuffer> allocCommandBuffers()
	{

		List<ComputeCommandBuffer> res = new ArrayList<>();
		long commandPoolId = commandPool.getId();

		long[] commandBufferIds = allocCommandBuffers(commandPoolId, computeProcesses.length);

		for (int i = 0; i < computeProcesses.length; i++)
		{
			ComputeProcess computeprocess = computeProcesses[i];
			long commandBufferId = commandBufferIds[i];

			DescriptorPool descriptorPool = computeprocess.getDescriptorPool();
			Collection<ComputePipeline> pipelines = computeprocess.getPipelines();

			ComputeCommandBuffer commandBuffer = new ComputeCommandBuffer(
					commandPool.getLogicalDevice(), commandBufferId);

			commandBuffer.start();

			for (ComputePipeline pipeline : pipelines)
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
							VK_PIPELINE_BIND_POINT_COMPUTE, pipelineLayout, 0, bDescriptorSet,
							null);

					MemoryUtil.memFree(bDescriptorSet);
				}

				vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(),
						VK_PIPELINE_BIND_POINT_COMPUTE, pipeline.getId());

				vkCmdDispatch(commandBuffer.getVkCommandBuffer(), groupCount.x, groupCount.y,
						groupCount.z);
			}

			commandBuffer.end();

			res.add(commandBuffer);
			mapBuffers.put(computeprocess, commandBuffer);
		}

		return res;
	}

	public ComputeCommandBuffer getCommandBuffer(ComputeProcess computerPool)
	{
		return mapBuffers.get(computerPool);
	}
}
