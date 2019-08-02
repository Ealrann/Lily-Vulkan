package org.sheepy.vulkan.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorPoolSize.Buffer;
import org.lwjgl.vulkan.VkDescriptorSetAllocateInfo;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkDescriptorSetLayoutCreateInfo;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.log.Logger;

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
	private VkDevice device;

	public VkDescriptorSet(List<IVkDescriptor> descriptors)
	{
		this.descriptors = List.copyOf(descriptors);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context, long poolAddress)
	{
		if (layoutId != UNINITIALIZED)
		{
			return;
		}

		device = ((ExecutionContext) context).getVkDevice();

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

	@Override
	public void free(IAllocationContext context)
	{
		if (layoutId == UNINITIALIZED)
		{
			return;
		}

		final var device = ((ExecutionContext) context).getVkDevice();
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

	@Override
	public void fillPoolSizes(Buffer poolSizes)
	{
		for (final var descriptor : descriptors)
		{
			final var poolSize = poolSizes.get();
			descriptor.fillPoolSize(poolSize);
		}
	}

	@Override
	public void updateDescriptorSet(MemoryStack stack)
	{
		updateDescriptorSet(stack, false);
	}

	private void updateDescriptorSet(MemoryStack stack, boolean all)
	{
		final int size = descriptors.size();
		final var descriptorWrites = VkWriteDescriptorSet.callocStack(size, stack);

		for (int i = 0; i < size; i++)
		{
			final var descriptor = descriptors.get(i);
			if (all || descriptor.hasChanged())
			{
				final var descriptorWrite = descriptorWrites.get();

				descriptor.fillWriteDescriptor(stack, descriptorWrite);
				descriptorWrite.dstSet(descriptorSetId);
				descriptorWrite.dstBinding(i);
			}
		}
		descriptorWrites.flip();

		vkUpdateDescriptorSets(device, descriptorWrites, null);
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		return descriptors;
	}

	@Override
	public long getId()
	{
		return descriptorSetId;
	}

	@Override
	public long getLayoutId()
	{
		if (layoutId == UNINITIALIZED)
		{
			throw new AssertionError(UNALLOCATED_DESCRIPTOR_SET);
		}

		return layoutId;
	}

	@Override
	public int descriptorCount()
	{
		return descriptors.size();
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
