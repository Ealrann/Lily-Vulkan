package org.sheepy.lily.vulkan.process.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.*;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.nio.LongBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

@ModelExtender(scope = DescriptorSet.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.DESCRIPTOR_SET__DESCRIPTORS, type = IDescriptorAllocation.class)
public final class DescriptorSetAllocation implements IDescriptorSetAllocation
{
	private static final String FAILED_TO_CREATE_DESCRIPTOR_SET_LAYOUT = "Failed to create descriptor set layout";
	private static final String FAILED_TO_ALLOCATE_DESCRIPTOR_SET = "Failed to allocate descriptor set";

	private final DescriptorSet descriptorSet;
	private final List<IDescriptorAllocation> descriptors;
	private final Deque<IDescriptorAllocation> dirtyDescriptors = new ArrayDeque<>();

	private long descriptorSetPtr;
	private long layoutPtr;
	private VkDevice device;
	private LongBuffer bDescriptorSet;

	public DescriptorSetAllocation(DescriptorSet descriptorSet,
								   @InjectDependency(index = 0) List<IDescriptorAllocation> descriptorAllocations)
	{
		this.descriptorSet = descriptorSet;
		descriptors = List.copyOf(descriptorAllocations);
	}

	@Override
	public void allocate(ExecutionContext context, long descriptorPoolPtr)
	{
		final var stack = context.stack();
		device = context.getVkDevice();

		final var layoutBindings = createLayoutBinding(stack);

		final var layoutInfo = VkDescriptorSetLayoutCreateInfo.callocStack(stack);
		layoutInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO);
		layoutInfo.pBindings(layoutBindings);

		final long[] aDescriptorSetLayout = new long[1];
		Logger.check(FAILED_TO_CREATE_DESCRIPTOR_SET_LAYOUT,
					 () -> vkCreateDescriptorSetLayout(device, layoutInfo, null, aDescriptorSetLayout));
		layoutPtr = aDescriptorSetLayout[0];

		final LongBuffer layouts = stack.callocLong(1);
		layouts.put(layoutPtr);
		layouts.flip();

		final var allocInfo = VkDescriptorSetAllocateInfo.callocStack(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO);
		allocInfo.descriptorPool(descriptorPoolPtr);
		allocInfo.pSetLayouts(layouts);

		bDescriptorSet = MemoryUtil.memAllocLong(1);
		Logger.check(FAILED_TO_ALLOCATE_DESCRIPTOR_SET,
					 () -> vkAllocateDescriptorSets(device, allocInfo, bDescriptorSet));
		descriptorSetPtr = bDescriptorSet.get(0);

		bDescriptorSet.put(descriptorSetPtr);
		bDescriptorSet.flip();

		updateDescriptorSet(stack, true);
	}

	@Override
	public void free(ExecutionContext context)
	{
		final var device = context.getVkDevice();
		vkDestroyDescriptorSetLayout(device, layoutPtr, null);
		MemoryUtil.memFree(bDescriptorSet);
	}

	@Override
	public void updateDescriptorSet(MemoryStack stack)
	{
		updateDescriptorSet(stack, false);
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
				descriptorWrite.dstSet(descriptorSetPtr);
				descriptorWrite.dstBinding(index);
			}
		}
		descriptorWrites.flip();

		vkUpdateDescriptorSets(device, descriptorWrites, null);
	}

	@Override
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

	@Override
	public long getPtr()
	{
		return descriptorSetPtr;
	}

	@Override
	public long getLayoutPtr()
	{
		return layoutPtr;
	}

	@Override
	public boolean hasChanged()
	{
		return dirtyDescriptors.isEmpty() == false;
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

	@Override
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
	public void fillPoolSizes(final VkDescriptorPoolSize.Buffer poolSizes)
	{
		for (final var descriptor : descriptorSet.getDescriptors())
		{
			final var adapter = descriptor.adapt(IDescriptorAdapter.class);
			final int sizeInPool = adapter.sizeInPool();
			if (sizeInPool > 0)
			{
				final var poolSize = poolSizes.get();
				poolSize.descriptorCount(sizeInPool);
				poolSize.type(descriptor.getType().getValue());
			}
		}
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
