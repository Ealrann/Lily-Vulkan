package org.sheepy.lily.vulkan.core.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.resource.DescriptorPool;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import static org.lwjgl.vulkan.VK10.*;

@ModelExtender(scope = DescriptorPool.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(features = VulkanResourcePackage.DESCRIPTOR_POOL__DESCRIPTOR_SETS)
public final class DescriptorPoolAllocation implements IExtender
{
	private static final String FAILED_TO_CREATE_DESCRIPTOR_POOL = "Failed to create descriptor pool";

	private final long ptr;
	private final DescriptorPool descriptorPool;
	private boolean hasChanged = false;

	public DescriptorPoolAllocation(DescriptorPool descriptorPool, ExecutionContext context)
	{
		this.descriptorPool = descriptorPool;
		final var descriptorSets = descriptorPool.getDescriptorSets();
		final var vkDevice = context.getVkDevice();
		final int descriptorSetCount = descriptorSets.size();
		int poolSize = 0;
		for (int i = 0; i < descriptorSetCount; i++)
		{
			final var descriptorSet = descriptorSets.get(i);
			for (final var descriptor : descriptorSet.getDescriptors())
			{
				final var adapter = descriptor.adapt(IDescriptorAdapter.class);
				if (adapter.sizeInPool() >= 0)
				{
					poolSize++;
				}
			}
		}

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

	public void prepare()
	{
		final var descriptorSets = descriptorPool.getDescriptorSets();
		for (int i = 0; i < descriptorSets.size(); i++)
		{
			final var descriptorSet = descriptorSets.get(i);
			final var descriptorSetAllocation = descriptorSet.adapt(IDescriptorSetAllocation.class);
			descriptorSetAllocation.prepare();
			hasChanged |= descriptorSetAllocation.hasChanged();
		}
	}

	public boolean hasChanged()
	{
		return hasChanged;
	}

	public void update(MemoryStack stack)
	{
		if (hasChanged)
		{
			final var descriptorSets = descriptorPool.getDescriptorSets();
			for (int i = 0; i < descriptorSets.size(); i++)
			{
				final var descriptorSet = descriptorSets.get(i);
				final var descriptorSetAllocation = descriptorSet.adapt(IDescriptorSetAllocation.class);
				descriptorSetAllocation.updateDescriptorSet(stack);
			}
			hasChanged = false;
		}
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
