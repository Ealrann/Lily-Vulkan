package org.sheepy.vulkan.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.vulkan.buffer.PushConstant;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.descriptor.DescriptorSet;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.descriptor.IDescriptorSetContext;

public abstract class AbstractPipeline extends AllocationNode
		implements IAllocable, IDescriptorSetContext
{
	protected Context context;

	private List<IDescriptor> descriptors;
	private PushConstant pushConstant = null;
	protected long pipelineLayout = 1;
	protected boolean lock = false;

	public AbstractPipeline(Context context, List<IDescriptor> descriptors)
	{
		this.context = context;
		this.descriptors = Collections.unmodifiableList(new ArrayList<>(descriptors));
	}

	public void setPushConstant(PushConstant pushConstant)
	{
		if (lock)
		{
			throw new AssertionError(
					"You cannot set PushConstant after the allocation of the pipeline.");
		}
		if (this.pushConstant != null)
		{
			throw new AssertionError("PushConstant is already defined in this pipeline.");
		}

		this.pushConstant = pushConstant;
		allocationObjects.add(pushConstant);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		pipelineLayout = allocatePipelineLayout(stack);
	}

	protected long allocatePipelineLayout(MemoryStack stack)
	{
		// Create Pipeline Layout
		// -----------------------
		DescriptorSet descriptorSet = context.descriptorPool.getDescriptorSet(this);
		LongBuffer bDescriptorSet = null;
		if (descriptorSet != null)
		{
			bDescriptorSet = stack.mallocLong(1);
			bDescriptorSet.put(descriptorSet.getLayoutId());
			bDescriptorSet.flip();
		}

		// Create compute pipeline
		long[] aLayout = new long[1];
		VkPipelineLayoutCreateInfo pipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo
				.callocStack(stack);
		pipelineLayoutCreateInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		pipelineLayoutCreateInfo.pSetLayouts(bDescriptorSet);
		if (pushConstant != null)
		{
			pipelineLayoutCreateInfo.pPushConstantRanges(pushConstant.alloPushConstantRange(stack));
		}
		if (vkCreatePipelineLayout(context.logicalDevice.getVkDevice(), pipelineLayoutCreateInfo,
				null, aLayout) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create compute pipeline layout!");
		}
		return aLayout[0];
	}

	@Override
	public void free()
	{
		vkDestroyPipelineLayout(context.logicalDevice.getVkDevice(), pipelineLayout, null);

		pipelineLayout = -1;
	}

	@Override
	public long getLayoutId()
	{
		return pipelineLayout;
	}

	public PushConstant getPushConstant()
	{
		return pushConstant;
	}

	@Override
	public List<IDescriptor> getDescriptors()
	{
		return descriptors;
	}
}
