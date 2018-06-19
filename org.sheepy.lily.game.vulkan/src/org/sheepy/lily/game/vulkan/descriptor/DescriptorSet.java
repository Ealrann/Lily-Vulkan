package org.sheepy.lily.game.vulkan.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorSetAllocateInfo;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkDescriptorSetLayoutCreateInfo;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class DescriptorSet
{
	private LogicalDevice logicalDevice;

	private long descriptorSetId;
	private long descriptorSetLayout;

	public static final DescriptorSet alloc(MemoryStack stack,
			LogicalDevice logicalDevice,
			DescriptorPool pool,
			IDescriptorSetConfiguration<?> configuration)
	{
		DescriptorSet res = new DescriptorSet(logicalDevice);
		res.load(stack, pool, configuration);
		return res;
	}

	private DescriptorSet(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	private void load(MemoryStack stack, DescriptorPool pool, IDescriptorSetConfiguration<?> configuration)
	{
		VkDescriptorSetLayoutBinding.Buffer layoutBindings = createLayoutBinding(stack,
				configuration);

		VkDescriptorSetLayoutCreateInfo layoutInfo = VkDescriptorSetLayoutCreateInfo
				.callocStack(stack);
		layoutInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO);
		layoutInfo.pBindings(layoutBindings);

		long[] aDescriptorSetLayout = new long[1];
		if (vkCreateDescriptorSetLayout(logicalDevice.getVkDevice(), layoutInfo, null,
				aDescriptorSetLayout) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create descriptor set layout!");
		}
		descriptorSetLayout = aDescriptorSetLayout[0];

		LongBuffer layouts = MemoryUtil.memAllocLong(1);
		layouts.put(descriptorSetLayout);
		layouts.flip();

		VkDescriptorSetAllocateInfo allocInfo = VkDescriptorSetAllocateInfo.callocStack(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO);
		allocInfo.descriptorPool(pool.getId());
		allocInfo.pSetLayouts(layouts);

		long[] aDescriptorSet = new long[1];
		if (vkAllocateDescriptorSets(logicalDevice.getVkDevice(), allocInfo,
				aDescriptorSet) != VK_SUCCESS)
		{
			throw new AssertionError("failed to allocate descriptor set!");
		}
		descriptorSetId = aDescriptorSet[0];

		updateDescriptorSet(stack, configuration);
	}

	private VkDescriptorSetLayoutBinding.Buffer createLayoutBinding(MemoryStack stack,
			IDescriptorSetConfiguration<?> configuration)
	{
		VkDescriptorSetLayoutBinding.Buffer layoutBindings = VkDescriptorSetLayoutBinding
				.callocStack(configuration.size(), stack);

		int index = 0;

		for (IDescriptor provider : configuration)
		{
			VkDescriptorSetLayoutBinding layoutBinding = provider.allocLayoutBinding(stack);
			layoutBinding.binding(index++);
			layoutBindings.put(layoutBinding);
		}

		layoutBindings.flip();
		return layoutBindings;
	}

	private void updateDescriptorSet(MemoryStack stack, IDescriptorSetConfiguration<?> configuration)
	{
		VkWriteDescriptorSet.Buffer descriptorWrites = VkWriteDescriptorSet
				.callocStack(configuration.size(), stack);
		int index = 0;

		for (IDescriptor descriptor : configuration)
		{
			VkWriteDescriptorSet allocWriteDescriptor = descriptor.allocWriteDescriptor(stack);
			allocWriteDescriptor.dstSet(descriptorSetId);
			allocWriteDescriptor.dstBinding(index++);
			descriptorWrites.put(allocWriteDescriptor);
		}
		descriptorWrites.flip();

		vkUpdateDescriptorSets(logicalDevice.getVkDevice(), descriptorWrites, null);
	}

	public long getId()
	{
		return descriptorSetId;
	}

	public void destroy()
	{
		vkDestroyDescriptorSetLayout(logicalDevice.getVkDevice(), descriptorSetLayout, null);
	}

	public long getLayoutId()
	{
		return descriptorSetLayout;
	}
}
