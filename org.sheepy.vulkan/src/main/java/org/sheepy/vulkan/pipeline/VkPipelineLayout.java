package org.sheepy.vulkan.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;
import org.sheepy.vulkan.util.VkModelUtil;

public final class VkPipelineLayout<T extends IExecutionContext> implements IAllocable<T>
{
	private static final String CREATION_ERROR = "Failed to create pipeline layout";

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
	public void allocate(T context)
	{
		final var stack = context.stack();
		final var vkDevice = context.getVkDevice();
		final int size = descriptorSets.size();

		final var layouts = allocLayouts(stack);
		final var pPushConstantRanges = allocPushConstant(stack);

		descriptorSetAddressBuffer = MemoryUtil.memAllocLong(size);
		for (int i = 0; i < size; i++)
		{
			final var descriptorSet = descriptorSets.get(i);
			final var descriptorId = descriptorSet.getId();
			descriptorSetAddressBuffer.put(descriptorId);
		}
		descriptorSetAddressBuffer.flip();

		// Create compute pipeline
		final long[] aLayout = new long[1];
		final var info = VkPipelineLayoutCreateInfo	.callocStack(stack)
													.set(	VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO,
															VK_NULL_HANDLE,
															0,
															layouts,
															pPushConstantRanges);

		Logger.check(CREATION_ERROR, () -> vkCreatePipelineLayout(vkDevice, info, null, aLayout));
		pipelineLayout = aLayout[0];
	}

	public LongBuffer allocLayouts(MemoryStack stack)
	{
		LongBuffer layouts = null;

		if (descriptorSets.isEmpty() == false)
		{
			final int size = descriptorSets.size();
			layouts = stack.mallocLong(size);
			for (int i = 0; i < size; i++)
			{
				final var vkDescriptorSet = descriptorSets.get(i);
				if (vkDescriptorSet.descriptorCount() > 0)
				{
					layouts.put(vkDescriptorSet.getLayoutId());
				}
			}
			layouts.flip();
		}

		return layouts;
	}

	public void bindDescriptors(VkCommandBuffer commandBuffer,
								List<IVkDescriptorSet> sets,
								int bindPoint)
	{
		if (sets.size() > 0)
		{
			descriptorSetAddressBuffer.clear();

			for (int i = 0; i < sets.size(); i++)
			{
				final var set = sets.get(i);
				descriptorSetAddressBuffer.put(set.getId());
			}
			descriptorSetAddressBuffer.flip();

			vkCmdBindDescriptorSets(commandBuffer,
									bindPoint,
									pipelineLayout,
									0,
									descriptorSetAddressBuffer,
									null);
		}
	}

	private VkPushConstantRange.Buffer allocPushConstant(MemoryStack stack)
	{
		VkPushConstantRange.Buffer ranges = null;

		if (constantRanges.isEmpty() == false)
		{
			final int rangeCount = constantRanges.size();
			ranges = VkPushConstantRange.callocStack(rangeCount, stack);
			for (int i = 0; i < rangeCount; i++)
			{
				final var constantRange = constantRanges.get(i);
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

		return ranges;
	}

	@Override
	public void free(T context)
	{
		final var vkDevice = context.getVkDevice();
		vkDestroyPipelineLayout(vkDevice, pipelineLayout, null);
		MemoryUtil.memFree(descriptorSetAddressBuffer);

		pipelineLayout = -1;
	}

	public long getId()
	{
		return pipelineLayout;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder();

		sb.append("Pipeline Layout:\n");
		for (int i = 0; i < descriptorSets.size(); i++)
		{
			final var descriptorSet = descriptorSets.get(i);
			sb.append("Set ").append(i).append(":\n");
			sb.append(descriptorSet.toString());
			sb.append("\n");
		}

		for (int i = 0; i < constantRanges.size(); i++)
		{
			final var constantRange = constantRanges.get(i);
			sb.append("ConstantRange ").append(i).append(": ");
			sb.append(constantRange.getSize());
			sb.append("\n");
		}

		return sb.toString();
	}
}
