package org.sheepy.vulkan.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;
import org.sheepy.vulkan.util.VkModelUtil;

public final class VkPipelineLayout<T extends IExecutionContext> implements IAllocable<T>
{
	private final List<IVkDescriptorSet> descriptorSets;
	private final List<PushConstantRange> constantRanges;

	private LongBuffer descriptorSetAddressBuffer;

	protected long pipelineLayout = -1;

	public VkPipelineLayout(List<IVkDescriptorSet> descriptorSets,
							List<PushConstantRange> constantRanges)
	{
		this.descriptorSets = List.copyOf(descriptorSets);
		this.constantRanges = List.copyOf(constantRanges);
	}

	@Override
	public void allocate(MemoryStack stack, T context)
	{
		final var vkDevice = context.getVkDevice();

		final LongBuffer layouts = allocLayouts(stack);

		descriptorSetAddressBuffer = MemoryUtil.memAllocLong(descriptorSets.size());
		for (final var descriptorSet : descriptorSets)
		{
			final var descriptorId = descriptorSet.getId();
			descriptorSetAddressBuffer.put(descriptorId);
		}
		descriptorSetAddressBuffer.flip();

		// Create compute pipeline
		final long[] aLayout = new long[1];
		final VkPipelineLayoutCreateInfo info = VkPipelineLayoutCreateInfo.callocStack(stack);
		info.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		info.pSetLayouts(layouts);
		preparePushConstant(stack, info);

		Logger.check("Failed to create pipeline layout",
				() -> vkCreatePipelineLayout(vkDevice, info, null, aLayout));
		pipelineLayout = aLayout[0];
	}

	public LongBuffer allocLayouts(MemoryStack stack)
	{
		LongBuffer layouts = null;

		if (descriptorSets.isEmpty() == false)
		{
			layouts = stack.mallocLong(descriptorSets.size());
			for (final IVkDescriptorSet vkDescriptorSet : descriptorSets)
			{
				if (vkDescriptorSet.size() > 0)
				{
					layouts.put(vkDescriptorSet.getLayoutId());
				}
			}
			layouts.flip();
		}

		return layouts;
	}

	public void bindDescriptors(VkCommandBuffer commandBuffer, int bindPoint)
	{
		if (descriptorSetAddressBuffer.limit() > 0)
		{
			vkCmdBindDescriptorSets(commandBuffer, bindPoint, pipelineLayout, 0,
					descriptorSetAddressBuffer, null);
		}
	}

	private void preparePushConstant(MemoryStack stack, VkPipelineLayoutCreateInfo info)
	{
		VkPushConstantRange.Buffer ranges = null;

		if (constantRanges.isEmpty() == false)
		{
			ranges = VkPushConstantRange.callocStack(constantRanges.size(), stack);
			for (final var constantRange : constantRanges)
			{
				final var range = ranges.get();
				final int offset = constantRange.getOffset();
				final int size = constantRange.getSize();
				final var stages = VkModelUtil.getEnumeratedFlag(constantRange.getStages());

				range.stageFlags(stages);
				range.offset(offset);
				range.size(size);
			}
			ranges.flip();
		}

		info.pPushConstantRanges(ranges);
	}

	@Override
	public void free(T context)
	{
		final var vkDevice = context.getVkDevice();
		vkDestroyPipelineLayout(vkDevice, pipelineLayout, null);
		MemoryUtil.memFree(descriptorSetAddressBuffer);

		pipelineLayout = -1;
	}

	@Override
	public boolean isAllocationDirty(T context)
	{
		return false;
	}

	public long getId()
	{
		return pipelineLayout;
	}
}
