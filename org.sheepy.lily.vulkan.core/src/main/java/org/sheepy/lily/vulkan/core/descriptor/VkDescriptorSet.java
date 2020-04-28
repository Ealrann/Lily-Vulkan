package org.sheepy.lily.vulkan.core.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.*;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.nio.LongBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public class VkDescriptorSet
{
	private static final String FAILED_TO_CREATE_DESCRIPTOR_SET_LAYOUT = "Failed to create descriptor set layout";
	private static final String FAILED_TO_ALLOCATE_DESCRIPTOR_SET = "Failed to allocate descriptor set";
	private static final String UNALLOCATED_DESCRIPTOR_SET = "Unallocated DescriptorSet";
	private static final int UNINITIALIZED = -1;

	private final List<IDescriptorAllocation> descriptors;
	private final Deque<IDescriptorAllocation> dirtyDescriptors = new ArrayDeque<>();

	private long descriptorSetId;
	private long layoutId = UNINITIALIZED;

	private LongBuffer bDescriptorSet;
	private VkDevice device;

	public VkDescriptorSet(List<IDescriptorAllocation> descriptors)
	{
		this.descriptors = List.copyOf(descriptors);
	}

	public void allocate(ExecutionContext context, long poolAddress)
	{
		if (layoutId != UNINITIALIZED)
		{
			return;
		}

		final var stack = context.stack();
		device = context.getVkDevice();

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
		allocInfo.descriptorPool(poolAddress);
		allocInfo.pSetLayouts(layouts);

		bDescriptorSet = MemoryUtil.memAllocLong(1);
		Logger.check(FAILED_TO_ALLOCATE_DESCRIPTOR_SET,
					 () -> vkAllocateDescriptorSets(device, allocInfo, bDescriptorSet));
		descriptorSetId = bDescriptorSet.get(0);

		bDescriptorSet.put(descriptorSetId);
		bDescriptorSet.flip();

		updateDescriptorSet(stack, true);
	}

	public void free(ExecutionContext context)
	{
		if (layoutId == UNINITIALIZED)
		{
			return;
		}

		final var device = context.getVkDevice();
		vkDestroyDescriptorSetLayout(device, layoutId, null);
		layoutId = UNINITIALIZED;
		MemoryUtil.memFree(bDescriptorSet);
		bDescriptorSet = null;
	}

	private VkDescriptorSetLayoutBinding.Buffer createLayoutBinding(MemoryStack stack)
	{
		final int size = descriptorCount();
		final var layoutBindings = VkDescriptorSetLayoutBinding.callocStack(size, stack);

		int index = 0;
		for (final var descriptor : descriptors)
		{
			final var vkDescriptor = descriptor.getVkDescriptor();
			if (vkDescriptor.isEmpty() == false)
			{
				final var layoutBinding = vkDescriptor.allocLayoutBinding(stack);
				layoutBinding.binding(index);
				layoutBindings.put(layoutBinding);
			}
			index++;
		}
		layoutBindings.flip();
		return layoutBindings;
	}

	public void updateDescriptorSet(MemoryStack stack)
	{
		updateDescriptorSet(stack, false);
	}

	public void prepare()
	{
		for (int i = 0; i < descriptors.size(); i++)
		{
			final var descriptor = descriptors.get(i);
			final var vkDescriptor = descriptor.getVkDescriptor();

			if (vkDescriptor.hasChanged())
			{
				dirtyDescriptors.add(descriptor);
			}
		}
	}

	public boolean hasChanged()
	{
		return dirtyDescriptors.isEmpty() == false;
	}

	private void updateDescriptorSet(MemoryStack stack, boolean all)
	{
		if (all)
		{
			dirtyDescriptors.clear();
			dirtyDescriptors.addAll(descriptors);
		}

		final int size = dirtyDescriptors.size();
		final var descriptorWrites = VkWriteDescriptorSet.callocStack(size, stack);

		while (dirtyDescriptors.isEmpty() == false)
		{
			final var descriptor = dirtyDescriptors.pop();
			final var vkDescriptor = descriptor.getVkDescriptor();
			final var index = descriptors.indexOf(descriptor);

			if (vkDescriptor.isEmpty() == false)
			{
				final var descriptorWrite = descriptorWrites.get();

				vkDescriptor.fillWriteDescriptor(stack, descriptorWrite);
				descriptorWrite.dstSet(descriptorSetId);
				descriptorWrite.dstBinding(index);
			}
		}
		descriptorWrites.flip();

		vkUpdateDescriptorSets(device, descriptorWrites, null);
	}

	public long getId()
	{
		return descriptorSetId;
	}

	public long getLayoutId()
	{
		if (layoutId == UNINITIALIZED)
		{
			throw new AssertionError(UNALLOCATED_DESCRIPTOR_SET);
		}

		return layoutId;
	}

	public int descriptorCount()
	{
		int res = 0;
		for (final var descriptor : descriptors)
		{
			final var vkDescriptor = descriptor.getVkDescriptor();
			if (vkDescriptor.isEmpty() == false)
			{
				res++;
			}
		}
		return res;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder();

		for (int i = 0; i < descriptors.size(); i++)
		{
			final var descriptor = descriptors.get(i);
			sb.append(descriptor.toString());
			sb.append("\n");
		}

		return sb.toString();
	}
}
