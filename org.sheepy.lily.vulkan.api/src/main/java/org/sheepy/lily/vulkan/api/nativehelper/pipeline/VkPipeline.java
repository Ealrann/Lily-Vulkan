package org.sheepy.lily.vulkan.api.nativehelper.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.resource.IConstantsAdapter;
import org.sheepy.lily.vulkan.api.resource.IVkDescriptorSet;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;

public class VkPipeline implements IAllocable
{
	private final List<AbstractConstants> constants;
	private final List<IVkDescriptorSet> descriptorSets;

	private LongBuffer descriptorSetAddressBuffer;
	protected long pipelineLayout = -1;

	public VkPipeline(List<IVkDescriptorSet> descriptorSets, List<AbstractConstants> constants)
	{
		this.constants = constants;
		this.descriptorSets = List.copyOf(descriptorSets);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var vkDevice = ((IExecutionContext) context).getVkDevice();

		descriptorSetAddressBuffer = MemoryUtil.memAllocLong(descriptorSets.size());

		LongBuffer bDescriptorSetLayouts = null;
		if (descriptorSets.isEmpty() == false)
		{
			bDescriptorSetLayouts = stack.mallocLong(descriptorSets.size());
			for (final IVkDescriptorSet vkDescriptorSet : descriptorSets)
			{
				if (vkDescriptorSet.getDescriptors().isEmpty() == false)
				{
					bDescriptorSetLayouts.put(vkDescriptorSet.getLayoutId());
				}
			}
			bDescriptorSetLayouts.flip();
		}

		// Create compute pipeline
		final long[] aLayout = new long[1];
		final VkPipelineLayoutCreateInfo info = VkPipelineLayoutCreateInfo.callocStack(stack);
		info.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		info.pSetLayouts(bDescriptorSetLayouts);

		preparePushConstant(stack, info);

		Logger.check("Failed to create pipeline layout",
				() -> vkCreatePipelineLayout(vkDevice, info, null, aLayout));
		pipelineLayout = aLayout[0];
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
				final var adapter = IConstantsAdapter.adapt(constant);
				adapter.fillRange(range, constant);
			}
			ranges.flip();
		}

		info.pPushConstantRanges(ranges);
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var vkDevice = ((IExecutionContext) context).getVkDevice();
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
