package org.sheepy.lily.vulkan.resource.nativehelper;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDescriptorSetAllocateInfo;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkDescriptorSetLayoutCreateInfo;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;

public class VkDescriptorSet implements IVkDescriptorSet
{
	private static final String FAILED_TO_CREATE_DESCRIPTOR_SET_LAYOUT = "Failed to create descriptor set layout";
	private static final String FAILED_TO_ALLOCATE_DESCRIPTOR_SET = "Failed to allocate descriptor set";
	private static final String UNALLOCATED_DESCRIPTOR_SET = "Unallocated DescriptorSet";
	private static final int UNINITIALIZED = -1;

	private final List<IVkDescriptor> descriptors;

	private long descriptorSetId;
	private long layoutId = UNINITIALIZED;

	private LongBuffer bDescriptorSet;

	public VkDescriptorSet(List<IVkDescriptor> descriptors)
	{
		this.descriptors = List.copyOf(descriptors);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context, DescriptorPool pool)
	{
		final var device = ((IExecutionContext) context).getVkDevice();
		final var layoutBindings = createLayoutBinding(stack);

		final var layoutInfo = VkDescriptorSetLayoutCreateInfo.callocStack(stack);
		layoutInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO);
		layoutInfo.pBindings(layoutBindings);

		final long[] aDescriptorSetLayout = new long[1];
		Logger.check(FAILED_TO_CREATE_DESCRIPTOR_SET_LAYOUT,
				() -> vkCreateDescriptorSetLayout(device, layoutInfo, null, aDescriptorSetLayout));
		layoutId = aDescriptorSetLayout[0];

		final LongBuffer layouts = stack.callocLong(1);
		layouts.put(layoutId);
		layouts.flip();

		final var allocInfo = VkDescriptorSetAllocateInfo.callocStack(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO);
		allocInfo.descriptorPool(pool.getId());
		allocInfo.pSetLayouts(layouts);

		bDescriptorSet = MemoryUtil.memAllocLong(1);
		Logger.check(FAILED_TO_ALLOCATE_DESCRIPTOR_SET,
				() -> vkAllocateDescriptorSets(device, allocInfo, bDescriptorSet));
		descriptorSetId = bDescriptorSet.get(0);

		bDescriptorSet.put(descriptorSetId);
		bDescriptorSet.flip();

		updateDescriptorSet(stack, device);
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var device = ((IExecutionContext) context).getVkDevice();
		vkDestroyDescriptorSetLayout(device, layoutId, null);
		layoutId = UNINITIALIZED;
		MemoryUtil.memFree(bDescriptorSet);
		bDescriptorSet = null;
	}

	private VkDescriptorSetLayoutBinding.Buffer createLayoutBinding(MemoryStack stack)
	{
		final int size = descriptors.size();
		final var layoutBindings = VkDescriptorSetLayoutBinding.callocStack(size, stack);

		int index = 0;
		for (final IVkDescriptor descriptor : descriptors)
		{
			final var layoutBinding = descriptor.allocLayoutBinding(stack);
			layoutBinding.binding(index++);
			layoutBindings.put(layoutBinding);
		}
		layoutBindings.flip();
		return layoutBindings;
	}

	private void updateDescriptorSet(MemoryStack stack, VkDevice device)
	{
		final VkWriteDescriptorSet.Buffer descriptorWrites = VkWriteDescriptorSet
				.callocStack(descriptors.size(), stack);
		int index = 0;

		for (final IVkDescriptor descriptor : descriptors)
		{
			final var allocWriteDescriptor = descriptor.allocWriteDescriptor(stack);
			allocWriteDescriptor.dstSet(descriptorSetId);
			allocWriteDescriptor.dstBinding(index++);
			descriptorWrites.put(allocWriteDescriptor);
		}
		descriptorWrites.flip();

		vkUpdateDescriptorSets(device, descriptorWrites, null);
	}

	@Override
	public void bindDescriptorSet(	VkCommandBuffer commandBuffer,
									int bindPoint,
									long pipelineLayoutId)
	{
		vkCmdBindDescriptorSets(commandBuffer, bindPoint, pipelineLayoutId, 0, bDescriptorSet,
				null);
	}

	@Override
	public long getId()
	{
		if (layoutId == UNINITIALIZED)
		{
			throw new AssertionError(UNALLOCATED_DESCRIPTOR_SET);
		}

		return layoutId;
	}

	@Override
	public long getLayoutId()
	{
		return getId();
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		return descriptors;
	}
}
