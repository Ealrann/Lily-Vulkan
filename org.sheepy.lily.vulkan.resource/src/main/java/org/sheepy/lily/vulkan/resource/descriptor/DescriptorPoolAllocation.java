package org.sheepy.lily.vulkan.resource.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.resource.DescriptorPool;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

@ModelExtender(scope = DescriptorPool.class)
@Allocation(context = ExecutionContext.class, reuseDirtyAllocations = true)
@AllocationChild(reportStateToParent = true, features = VulkanResourcePackage.DESCRIPTOR_POOL__DESCRIPTOR_SETS)
public final class DescriptorPoolAllocation implements IExtender
{
	private static final String FAILED_TO_CREATE_DESCRIPTOR_POOL = "Failed to create descriptor pool";

	private final long ptr;
	private final int poolSize;
	private final VkDevice vkDevice;
	private final IAllocationState allocationState;

	public DescriptorPoolAllocation(DescriptorPool descriptorPool,
									ExecutionContext context,
									IAllocationState allocationState)
	{
		this.allocationState = allocationState;
		final var descriptorSets = descriptorPool.getDescriptorSets();
		vkDevice = context.getVkDevice();
		final int descriptorSetCount = descriptorSets.size();
		int poolSizeCounter = 0;
		for (int i = 0; i < descriptorSetCount; i++)
		{
			final var descriptorSet = descriptorSets.get(i);
			for (final var descriptor : descriptorSet.getDescriptors())
			{
				final var adapter = descriptor.adapt(IDescriptorAdapter.class);
				if (adapter.sizeInPool() >= 0)
				{
					poolSizeCounter++;
				}
			}
		}

		poolSize = poolSizeCounter;
		if (poolSize > 0)
		{
			final var poolSizes = VkDescriptorPoolSize.callocStack(poolSize);
			for (int i = 0; i < descriptorSetCount; i++)
			{
				final var descriptorSet = descriptorSets.get(i);
				for (final var descriptor : descriptorSet.getDescriptors())
				{
					final var adapter = descriptor.adapt(IDescriptorAdapter.class);
					final int sizeInPool = adapter.sizeInPool();
					if (sizeInPool >= 0)
					{
						final var p = poolSizes.get();
						p.type(descriptor.getType().getValue());
						p.descriptorCount(sizeInPool);
					}
				}
			}
			poolSizes.flip();

			final var poolInfo = VkDescriptorPoolCreateInfo.callocStack();
			poolInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO);
			poolInfo.pPoolSizes(poolSizes);
			poolInfo.maxSets(descriptorSetCount);

			final long[] aDescriptor = new long[1];
			Logger.check(FAILED_TO_CREATE_DESCRIPTOR_POOL,
						 () -> vkCreateDescriptorPool(vkDevice, poolInfo, null, aDescriptor));
			ptr = aDescriptor[0];
		}
		else
		{
			ptr = 0;
		}
	}

	@InjectChildren(index = 0, type = DescriptorSetAllocation.class)
	private void updateDescriptorSets(List<DescriptorSetAllocation> setAllocations)
	{
		try (final var stack = MemoryStack.stackPush())
		{
			final var descriptorWrites = VkWriteDescriptorSet.callocStack(poolSize, stack);
			for (final var setAllocation : setAllocations)
			{
				setAllocation.updateDescriptorSet(descriptorWrites, stack);
			}
			descriptorWrites.flip();
			vkUpdateDescriptorSets(vkDevice, descriptorWrites, null);
		}
	}

	public void lock(IRecordContext recordContext)
	{
		recordContext.lockAllocationDuringExecution(allocationState);
	}

	@Free
	public void free(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		vkDestroyDescriptorPool(vkDevice, ptr, null);
	}

	public long getPtr()
	{
		return ptr;
	}
}
