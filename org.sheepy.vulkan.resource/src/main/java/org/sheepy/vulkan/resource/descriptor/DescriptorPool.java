package org.sheepy.vulkan.resource.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.device.LogicalDeviceContext;
import org.sheepy.vulkan.common.util.Logger;

public class DescriptorPool extends LogicalDeviceContext implements IBasicAllocable
{
	private List<IVkDescriptorSet> descriptorSets = null;

	private long id;

	public DescriptorPool(LogicalDevice logicalDevice, List<IVkDescriptorSet> descriptorSets)
	{
		super(logicalDevice);
		this.descriptorSets = List.copyOf(descriptorSets);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
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

			final var vkDevice = getVkDevice();
			final long[] aDescriptor = new long[1];
			Logger.check("Failed to create descriptor pool",
					() -> vkCreateDescriptorPool(vkDevice, poolInfo, null, aDescriptor));
			id = aDescriptor[0];
		}

		for (var descriptorSet : descriptorSets)
		{
			descriptorSet.allocate(stack, this);
		}
	}

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}

	@Override
	public void free()
	{
		for (var descriptorSet : descriptorSets)
		{
			descriptorSet.free();
		}
		descriptorSets = null;

		vkDestroyDescriptorPool(getVkDevice(), id, null);
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
