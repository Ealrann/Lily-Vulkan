package org.sheepy.lily.game.vulkan.command.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joml.Vector3i;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.game.vulkan.command.AbstractCommandBuffers;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorSet;
import org.sheepy.lily.game.vulkan.pipeline.compute.ComputePipeline;
import org.sheepy.lily.game.vulkan.pipeline.compute.ComputerPool;

public class ComputeCommandBuffers extends AbstractCommandBuffers<ComputeCommandBuffer>
{
	private static final float WORKGROUP_SIZE = 32f;

	private CommandPool commandPool;
	private ComputePipeline computePipeline;
	private ComputerPool[] computerPools;

	public ComputeCommandBuffers(ComputePipeline computePipeline, CommandPool commandPool,
			Collection<ComputerPool> computerPools)
	{
		super(commandPool);
		this.computerPools = computerPools.toArray(new ComputerPool[computerPools.size()]);
		this.computePipeline = computePipeline;
	}

	@Override
	protected List<ComputeCommandBuffer> allocCommandBuffers()
	{
		DescriptorPool descriptorPool = computePipeline.getDescriptorPool();
		long pipelineLayout = computePipeline.getPipelineLayout();

		List<ComputeCommandBuffer> res = new ArrayList<>();
		long commandPoolId = commandPool.getId();

		long[] commandBufferIds = allocCommandBuffers(commandPoolId, computerPools.length);

		for (int i = 0; i < computerPools.length; i++)
		{
			long commandBufferId = commandBufferIds[i];
			ComputerPool computerPool = computerPools[i];
			ComputeCommandBuffer commandBuffer = new ComputeCommandBuffer(
					commandPool.getLogicalDevice(), commandBufferId);

			commandBuffer.start();

			if (descriptorPool != null)
			{
				DescriptorSet descriptorSet = descriptorPool.getDescriptorSet(computerPool);

				LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(1);
				bDescriptorSet.put(descriptorSet.getId());
				bDescriptorSet.flip();
				
				vkCmdBindDescriptorSets(commandBuffer.getVkCommandBuffer(),
						VK_PIPELINE_BIND_POINT_COMPUTE, pipelineLayout, 0, bDescriptorSet, null);
				MemoryUtil.memFree(bDescriptorSet);
			}

			int dataWidth = computerPool.getDataWidth();
			int dataHeight = computerPool.getDataHeight();
			int dataDepth = computerPool.getDataDepth();

			Vector3i groupCount = new Vector3i((int) Math.ceil(dataWidth / WORKGROUP_SIZE),
					(int) Math.ceil(dataHeight / WORKGROUP_SIZE),
					(int) Math.ceil(dataDepth / WORKGROUP_SIZE));

			vkCmdDispatch(commandBuffer.getVkCommandBuffer(), groupCount.x, groupCount.y,
					groupCount.z);

			commandBuffer.end();

			res.add(commandBuffer);

		}

		return res;
	}
}
