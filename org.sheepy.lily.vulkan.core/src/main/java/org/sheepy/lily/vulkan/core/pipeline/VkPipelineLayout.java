package org.sheepy.lily.vulkan.core.pipeline;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetLayoutAllocation;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

import java.nio.LongBuffer;
import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public final class VkPipelineLayout
{
	private static final String CREATION_ERROR = "Failed to create pipeline layout";

	private final List<IDescriptorSetLayoutAllocation> descriptorSets;
	private final List<PushConstantRange> constantRanges;

	private long pipelineLayout = -1;

	public VkPipelineLayout(List<IDescriptorSetLayoutAllocation> descriptorSets, List<PushConstantRange> constantRanges)
	{
		this.descriptorSets = List.copyOf(descriptorSets);
		this.constantRanges = List.copyOf(constantRanges);
	}

	public void allocate(IVulkanContext context)
	{
		final var stack = context.stack();
		final var vkDevice = context.getVkDevice();
		final var layouts = allocLayouts(stack);
		final var pPushConstantRanges = allocPushConstant(stack);

		// Create compute pipeline
		final long[] aLayout = new long[1];
		final var info = VkPipelineLayoutCreateInfo.calloc(stack)
												   .set(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO,
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
				final var descriptorSet = descriptorSets.get(i);
				if (descriptorSet.descriptorCount() > 0)
				{
					layouts.put(descriptorSet.getLayoutPtr());
				}
			}
			layouts.flip();
		}

		return layouts;
	}

	private VkPushConstantRange.Buffer allocPushConstant(MemoryStack stack)
	{
		VkPushConstantRange.Buffer ranges = null;

		if (constantRanges.isEmpty() == false)
		{
			final int rangeCount = constantRanges.size();
			ranges = VkPushConstantRange.calloc(rangeCount, stack);
			for (int i = 0; i < rangeCount; i++)
			{
				final var constantRange = constantRanges.get(i);
				final var range = ranges.get();
				final int offset = constantRange.getOffset();
				final int size = constantRange.getSize();
				final var stages = VulkanModelUtil.getEnumeratedFlag(constantRange.getStages());

				range.stageFlags(stages);
				range.offset(offset);
				range.size(size);
			}
			ranges.flip();
		}

		return ranges;
	}

	public void free(IVulkanContext context)
	{
		final var vkDevice = context.getVkDevice();
		vkDestroyPipelineLayout(vkDevice, pipelineLayout, null);

		pipelineLayout = -1;
	}

	public long getPtr()
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
