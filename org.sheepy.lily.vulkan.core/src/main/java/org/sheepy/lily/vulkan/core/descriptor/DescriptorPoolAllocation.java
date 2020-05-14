package org.sheepy.lily.vulkan.core.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.core.api.allocation.up.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.resource.DescriptorPool;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

@ModelExtender(scope = DescriptorPool.class)
@Allocation(context = ExecutionContext.class)
@AllocationChild(features = VulkanResourcePackage.DESCRIPTOR_POOL__DESCRIPTOR_SETS, type = IDescriptorSetAllocation.class)
@AllocationDependency(features = VulkanResourcePackage.DESCRIPTOR_POOL__DESCRIPTOR_SETS, type = IDescriptorSetAllocation.class)
public final class DescriptorPoolAllocation implements IAllocation
{
	private static final String FAILED_TO_CREATE_DESCRIPTOR_POOL = "Failed to create descriptor pool";

	private final List<IDescriptorSetAllocation> descriptorSets;
	private final long ptr;
	private boolean hasChanged = false;

	public DescriptorPoolAllocation(ExecutionContext context,
									@InjectDependency(index = 0) List<IDescriptorSetAllocation> descriptorSets)
	{
		final var vkDevice = context.getVkDevice();
		final int descriptorSetCount = descriptorSets.size();
		int poolSize = 0;
		for (int i = 0; i < descriptorSetCount; i++)
		{
			final var descriptorSet = descriptorSets.get(i);
			poolSize += descriptorSet.descriptorCount();
		}

		if (poolSize > 0)
		{
			final var poolSizes = VkDescriptorPoolSize.callocStack(poolSize);
			for (int i = 0; i < descriptorSetCount; i++)
			{
				final var descriptorSet = descriptorSets.get(i);
				descriptorSet.fillPoolSizes(poolSizes);
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

			for (int i = 0; i < descriptorSetCount; i++)
			{
				final var descriptorSet = descriptorSets.get(i);
				descriptorSet.allocate(context, ptr);
			}
		}
		else
		{
			ptr = 0;
		}

		this.descriptorSets = List.copyOf(descriptorSets);
	}

	public void prepare()
	{
		for (int i = 0; i < descriptorSets.size(); i++)
		{
			final var descriptorSet = descriptorSets.get(i);
			descriptorSet.prepare();
			hasChanged |= descriptorSet.hasChanged();
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
			for (int i = 0; i < descriptorSets.size(); i++)
			{
				final var descriptorSet = descriptorSets.get(i);
				descriptorSet.updateDescriptorSet(stack);
			}
			hasChanged = false;
		}
	}

	@Free
	public void free(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();

		for (int i = 0; i < descriptorSets.size(); i++)
		{
			final var descriptorSet = descriptorSets.get(i);
			descriptorSet.free(context);
		}

		vkDestroyDescriptorPool(vkDevice, ptr, null);
	}

	public long getPtr()
	{
		return ptr;
	}
}
