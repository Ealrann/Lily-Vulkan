package org.sheepy.vulkan.resource.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.device.LogicalDeviceContext;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.resource.ResourceManager;

public class DescriptorPool extends LogicalDeviceContext implements IBasicAllocable
{
	private final ResourceManager resourceManager;

	private List<DescriptorSet> descriptorSets = null;

	private long id;

	public DescriptorPool(ResourceManager resourceManager)
	{
		super(resourceManager.logicalDevice);
		this.resourceManager = resourceManager;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		int poolSize = 0;
		descriptorSets = List.copyOf(resourceManager.getDescriptorLists());
		for (final DescriptorSet descriptorSet : descriptorSets)
		{
			final var adapter = IDescriptorSetAdapter.adapt(descriptorSet);
			poolSize += adapter.getDescriptors().size();
		}

		if (poolSize > 0)
		{
			final var poolSizes = VkDescriptorPoolSize.callocStack(poolSize);
			for (final DescriptorSet descriptorSet : descriptorSets)
			{
				final var descriptorSetAdapter = IDescriptorSetAdapter.adapt(descriptorSet);
				for (final IVkDescriptor descriptor : descriptorSetAdapter.getDescriptors())
				{
					poolSizes.put(descriptor.allocPoolSize(stack));
				}
			}
			poolSizes.flip();

			final var poolInfo = VkDescriptorPoolCreateInfo.callocStack();
			poolInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO);
			poolInfo.pPoolSizes(poolSizes);
			poolInfo.maxSets(descriptorSets.size());

			final var vkDevice = resourceManager.getVkDevice();
			final long[] aDescriptor = new long[1];
			Logger.check("Failed to create descriptor pool!",
					() -> vkCreateDescriptorPool(vkDevice, poolInfo, null, aDescriptor));
			id = aDescriptor[0];
		}
	}

	@Override
	public boolean isDirty()
	{
		return resourceManager.isDirty();
	}

	@Override
	public void free()
	{
		for (final DescriptorSet descriptorSet : descriptorSets)
		{
			final var adapter = IDescriptorSetAdapter.adapt(descriptorSet);
			adapter.free();
		}
		vkDestroyDescriptorPool(resourceManager.getVkDevice(), id, null);
		
		descriptorSets = null;
	}

	public long getId()
	{
		return id;
	}

	public DescriptorSet getDescriptorSet(int index)
	{
		return descriptorSets.get(index);
	}

	public LongBuffer allocLayoutBuffer()
	{
		final LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(descriptorSets.size());

		for (final DescriptorSet descriptorList : descriptorSets)
		{
			final var adapter = IDescriptorSetAdapter.adapt(descriptorList);
			bDescriptorSet.put(adapter.getLayoutId());
		}

		bDescriptorSet.flip();
		return bDescriptorSet;
	}
}
