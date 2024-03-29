package org.sheepy.lily.vulkan.resource.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorSetAllocateInfo;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.core.api.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetLayoutAllocation;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;

import java.nio.LongBuffer;
import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO;
import static org.lwjgl.vulkan.VK10.vkAllocateDescriptorSets;

@ModelExtender(scope = DescriptorSet.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(features = VulkanResourcePackage.DESCRIPTOR_SET__DESCRIPTORS, type = IDescriptorAllocation.class)
@AllocationDependency(type = IDescriptorSetLayoutAllocation.class)
@AllocationDependency(parent = DescriptorPool.class, type = DescriptorPoolAllocation.class)
public class DescriptorSetAllocation implements IDescriptorSetAllocation
{
	private static final String FAILED_TO_ALLOCATE_DESCRIPTOR_SET = "Failed to allocate descriptor set";

	private final long descriptorSetPtr;
	private final long layoutPtr;
	private final VkDevice device;

	private final List<IDescriptorAllocation> allocations;
	private final DescriptorPoolAllocation descriptorPool;

	public DescriptorSetAllocation(final DescriptorSet dSet,
								   final ExecutionContext context,
								   final IAllocationState allocationState,
								   final @InjectDependency(index = 0) List<IDescriptorAllocation> descriptorAllocations,
								   final @InjectDependency(index = 1) IDescriptorSetLayoutAllocation layoutAllocation,
								   final @InjectDependency(index = 2) DescriptorPoolAllocation descriptorPool)
	{
		this.descriptorPool = descriptorPool;
		final var descriptorPoolPtr = descriptorPool.getPtr();

		final var stack = context.stack();
		device = context.getVkDevice();
		layoutPtr = layoutAllocation.getLayoutPtr();
		descriptorSetPtr = allocateDescriptorSet(descriptorPoolPtr, stack);
		allocations = descriptorAllocations;

		allocationState.listenStatus(this::statusChanged);
	}

	private void statusChanged(final EAllocationStatus allocationStatus)
	{
		if (allocationStatus == EAllocationStatus.Obsolete)
		{
			descriptorPool.setObsolete();
		}
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		for (final var allocation : allocations)
		{
			allocation.attach(recordContext);
		}
		descriptorPool.lock(recordContext);
	}

	public void updateDescriptorSet(VkWriteDescriptorSet.Buffer descriptorWrites, MemoryStack stack)
	{
		final int size = allocations.size();
		for (int i = 0; i < size; i++)
		{
			final var descriptor = allocations.get(i);
			final var vkDescriptor = descriptor.getVkDescriptor();
			if (vkDescriptor.isEmpty() == false)
			{
				final var descriptorWrite = descriptorWrites.get();
				vkDescriptor.fillWriteDescriptor(stack, descriptorWrite);
				descriptorWrite.dstSet(descriptorSetPtr);
				descriptorWrite.dstBinding(i);
			}
		}
	}

	private long allocateDescriptorSet(final long descriptorPoolPtr, final MemoryStack stack)
	{
		final LongBuffer layouts = stack.callocLong(1);
		layouts.put(layoutPtr);
		layouts.flip();

		final var allocInfo = VkDescriptorSetAllocateInfo.calloc(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO);
		allocInfo.descriptorPool(descriptorPoolPtr);
		allocInfo.pSetLayouts(layouts);

		final var bDescriptorSet = stack.mallocLong(1);
		Logger.check(vkAllocateDescriptorSets(device, allocInfo, bDescriptorSet), FAILED_TO_ALLOCATE_DESCRIPTOR_SET);
		return bDescriptorSet.get(0);
	}

	@Override
	public long getPtr()
	{
		return descriptorSetPtr;
	}
}
