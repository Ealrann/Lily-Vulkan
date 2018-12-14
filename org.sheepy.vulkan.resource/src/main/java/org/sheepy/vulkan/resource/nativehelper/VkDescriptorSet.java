package org.sheepy.vulkan.resource.nativehelper;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorSetAllocateInfo;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkDescriptorSetLayoutCreateInfo;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.resource.descriptor.DescriptorPool;
import org.sheepy.vulkan.resource.descriptor.IVkDescriptor;
import org.sheepy.vulkan.resource.descriptor.IVkDescriptorSet;

public class VkDescriptorSet implements IVkDescriptorSet
{
	private long descriptorSetId;
	private long layoutId;
	private DescriptorPool pool;
	private final List<IVkDescriptor> descriptors;

	public VkDescriptorSet(List<IVkDescriptor> descriptors)
	{
		this.descriptors = List.copyOf(descriptors);
	}
	
	@Override
	public void allocate(MemoryStack stack, DescriptorPool pool)
	{
		this.pool = pool;
		var device = pool.getVkDevice();
		var layoutBindings = createLayoutBinding(stack);

		final var layoutInfo = VkDescriptorSetLayoutCreateInfo.callocStack(stack);
		layoutInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO);
		layoutInfo.pBindings(layoutBindings);

		final long[] aDescriptorSetLayout = new long[1];
		Logger.check("Failed to create descriptor set layout!",
				() -> vkCreateDescriptorSetLayout(device, layoutInfo, null, aDescriptorSetLayout));
		layoutId = aDescriptorSetLayout[0];

		final LongBuffer layouts = MemoryUtil.memAllocLong(1);
		layouts.put(layoutId);
		layouts.flip();

		final var allocInfo = VkDescriptorSetAllocateInfo.callocStack(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO);
		allocInfo.descriptorPool(pool.getId());
		allocInfo.pSetLayouts(layouts);

		final long[] aDescriptorSet = new long[1];
		Logger.check("Failed to allocate descriptor set.",
				() -> vkAllocateDescriptorSets(device, allocInfo, aDescriptorSet));
		descriptorSetId = aDescriptorSet[0];

		updateDescriptorSet(stack);
	}

	@Override
	public void free()
	{
		var device = pool.getVkDevice();
		vkDestroyDescriptorSetLayout(device, layoutId, null);
		layoutId = -1;
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

	private void updateDescriptorSet(MemoryStack stack)
	{
		final VkWriteDescriptorSet.Buffer descriptorWrites = VkWriteDescriptorSet
				.callocStack(descriptors.size(), stack);
		int index = 0;

		for (final IVkDescriptor descriptor : descriptors)
		{
			var allocWriteDescriptor = descriptor.allocWriteDescriptor(stack);
			allocWriteDescriptor.dstSet(descriptorSetId);
			allocWriteDescriptor.dstBinding(index++);
			descriptorWrites.put(allocWriteDescriptor);
		}
		descriptorWrites.flip();

		vkUpdateDescriptorSets(pool.getVkDevice(), descriptorWrites, null);
	}

	@Override
	public void bindDescriptorSet(	AbstractCommandBuffer commandBuffer,
									int bindPoint,
									long pipelineLayoutId)
	{
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
		final var bDescriptorSet = MemoryUtil.memAllocLong(1);
		bDescriptorSet.put(descriptorSetId);
		bDescriptorSet.flip();
		vkCmdBindDescriptorSets(vkCommandBuffer, bindPoint, pipelineLayoutId, 0, bDescriptorSet,
				null);
		MemoryUtil.memFree(bDescriptorSet);
	}

	@Override
	public long getId()
	{
		return layoutId;
	}

	@Override
	public long getLayoutId()
	{
		return layoutId;
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		return descriptors;
	}
}
