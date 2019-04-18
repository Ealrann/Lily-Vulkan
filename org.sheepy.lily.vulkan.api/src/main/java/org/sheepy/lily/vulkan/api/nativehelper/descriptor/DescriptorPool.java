package org.sheepy.lily.vulkan.api.nativehelper.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.util.Logger;

public class DescriptorPool implements IAllocable
{
	private final List<IVkDescriptor> descriptors;
	private final List<IVkDescriptorSet> descriptorSets;

	private long id;
	private boolean hasChanged = false;

	public DescriptorPool(List<IVkDescriptorSet> descriptorSets)
	{
		this.descriptorSets = List.copyOf(descriptorSets);
		descriptors = List.copyOf(gatherDescriptors());
	}

	private Collection<IVkDescriptor> gatherDescriptors()
	{
		final Set<IVkDescriptor> res = new HashSet<>();

		for (final IVkDescriptorSet descriptorSet : descriptorSets)
		{
			res.addAll(descriptorSet.getDescriptors());
		}

		return res;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var vkDevice = ((IExecutionContext) context).getVkDevice();
		int poolSize = 0;
		for (final var descriptorSet : descriptorSets)
		{
			poolSize += descriptorSet.size();
		}

		if (poolSize > 0)
		{
			final var poolSizes = VkDescriptorPoolSize.callocStack(poolSize);
			for (final var descriptorSet : descriptorSets)
			{
				descriptorSet.fillPoolSizes(poolSizes);
			}
			poolSizes.flip();

			final var poolInfo = VkDescriptorPoolCreateInfo.callocStack();
			poolInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO);
			poolInfo.pPoolSizes(poolSizes);
			poolInfo.maxSets(descriptorSets.size());

			final long[] aDescriptor = new long[1];
			Logger.check("Failed to create descriptor pool",
					() -> vkCreateDescriptorPool(vkDevice, poolInfo, null, aDescriptor));
			id = aDescriptor[0];
		}

		for (final var descriptorSet : descriptorSets)
		{
			descriptorSet.allocate(stack, context, id);
		}
	}

	public void prepare(MemoryStack stack)
	{
		hasChanged = false;

		for (final IVkDescriptor descriptor : descriptors)
		{
			descriptor.update();
			hasChanged |= descriptor.hasChanged();
		}

		if (hasChanged)
		{
			for (final IVkDescriptorSet descriptorSet : descriptorSets)
			{
				descriptorSet.updateDescriptorSet(stack);
			}
		}
	}

	public boolean hasChanged()
	{
		return hasChanged;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var vkDevice = ((IExecutionContext) context).getVkDevice();

		for (final var descriptorSet : descriptorSets)
		{
			descriptorSet.free(context);
		}

		vkDestroyDescriptorPool(vkDevice, id, null);
		id = -1;
	}

	public long getId()
	{
		return id;
	}
}