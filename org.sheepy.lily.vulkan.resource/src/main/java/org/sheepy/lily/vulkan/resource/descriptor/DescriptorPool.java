package org.sheepy.lily.vulkan.resource.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;

public class DescriptorPool implements IAllocable
{
	private List<IVkDescriptorSet> descriptorSets = null;
	private long id;

	public DescriptorPool(List<IVkDescriptorSet> descriptorSets)
	{
		this.descriptorSets = List.copyOf(descriptorSets);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		var vkDevice = ((ExecutionContext) context).getVkDevice();
		int poolSize = 0;
		for (final IVkDescriptorSet descriptorSet : descriptorSets)
		{
			poolSize += descriptorSet.getDescriptors().size();
		}

		if (poolSize > 0)
		{
			final var poolSizes = VkDescriptorPoolSize.callocStack(poolSize);
			for (var descriptorSet : descriptorSets)
			{
				for (var descriptor : descriptorSet.getDescriptors())
				{
					poolSizes.put(descriptor.allocPoolSize(stack));
				}
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

		for (var descriptorSet : descriptorSets)
		{
			descriptorSet.allocate(stack, context, this);
		}
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	@Override
	public void free(IAllocationContext context)
	{
		var vkDevice = ((ExecutionContext) context).getVkDevice();

		for (var descriptorSet : descriptorSets)
		{
			descriptorSet.free(context);
		}
		descriptorSets = null;

		vkDestroyDescriptorPool(vkDevice, id, null);
		id = -1;
	}

	public long getId()
	{
		return id;
	}

	public LongBuffer allocLayoutBuffer()
	{
		LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(descriptorSets.size());

		for (var descriptorSet : descriptorSets)
		{
			bDescriptorSet.put(descriptorSet.getLayoutId());
		}

		bDescriptorSet.flip();
		return bDescriptorSet;
	}
}
