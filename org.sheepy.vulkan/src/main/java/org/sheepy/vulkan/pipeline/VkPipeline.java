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
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.log.Logger;

public class VkPipeline implements IAllocable
{
	private final List<IConstantsFiller> constants;
	private final List<IVkDescriptorSet> descriptorSets;

	private LongBuffer descriptorSetAddressBuffer;

	protected long pipelineLayout = -1;

	public VkPipeline(	List<IVkDescriptorSet> descriptorSets,
						List<? extends IConstantsFiller> constants)
	{
		this.constants = List.copyOf(constants);
		this.descriptorSets = List.copyOf(descriptorSets);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var executionContext = (IExecutionContext) context;
		final var vkDevice = executionContext.getVkDevice();

		final LongBuffer layouts = allocLayouts(stack);

		descriptorSetAddressBuffer = MemoryUtil.memAllocLong(descriptorSets.size());

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

	public void bindDescriptor(	VkCommandBuffer commandBuffer,
								int bindPoint,
								Integer[] descriptorSetIndexes)
	{
		descriptorSetAddressBuffer.clear();

		for (final Integer index : descriptorSetIndexes)
		{
			if (index < descriptorSets.size())
			{
				final var descriptorSet = descriptorSets.get(index);
				final var descriptorId = descriptorSet.getId();
				descriptorSetAddressBuffer.put(descriptorId);
			}
		}
		descriptorSetAddressBuffer.flip();

		if (descriptorSetAddressBuffer.limit() > 0)
		{
			vkCmdBindDescriptorSets(commandBuffer, bindPoint, pipelineLayout, 0,
					descriptorSetAddressBuffer, null);
		}
	}

	private void preparePushConstant(MemoryStack stack, VkPipelineLayoutCreateInfo info)
	{
		VkPushConstantRange.Buffer ranges = null;

		if (constants.isEmpty() == false)
		{
			ranges = VkPushConstantRange.callocStack(constants.size(), stack);
			for (final var constant : constants)
			{
				final var range = ranges.get();
				constant.fillRange(range);
			}
			ranges.flip();
		}

		info.pPushConstantRanges(ranges);
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var vkDevice = ((ExecutionContext) context).getVkDevice();
		vkDestroyPipelineLayout(vkDevice, pipelineLayout, null);
		MemoryUtil.memFree(descriptorSetAddressBuffer);

		pipelineLayout = -1;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	public long getPipelineLayout()
	{
		return pipelineLayout;
	}

	public long getPipelineId()
	{
		return -1;
	}
}
