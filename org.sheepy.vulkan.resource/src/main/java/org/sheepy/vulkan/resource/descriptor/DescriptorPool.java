package org.sheepy.vulkan.resource.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
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

	private List<IDescriptorSetAdapter> descriptorSetAdapters = null;

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
		var descriptorSets = resourceManager.getDescriptorLists();
		descriptorSetAdapters = new ArrayList<>();
		for (final DescriptorSet descriptorSet : descriptorSets)
		{
			final var adapter = IDescriptorSetAdapter.adapt(descriptorSet);
			descriptorSetAdapters.add(adapter);
			poolSize += adapter.getDescriptors().size();
		}
		descriptorSetAdapters = List.copyOf(descriptorSetAdapters);

		if (poolSize > 0)
		{
			final var poolSizes = VkDescriptorPoolSize.callocStack(poolSize);
			for (var descriptorSetAdapter : descriptorSetAdapters)
			{
				for (var descriptor : descriptorSetAdapter.getDescriptors())
				{
					poolSizes.put(descriptor.allocPoolSize(stack));
				}
			}
			poolSizes.flip();

			final var poolInfo = VkDescriptorPoolCreateInfo.callocStack();
			poolInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO);
			poolInfo.pPoolSizes(poolSizes);
			poolInfo.maxSets(descriptorSetAdapters.size());

			final var vkDevice = resourceManager.getVkDevice();
			final long[] aDescriptor = new long[1];
			Logger.check("Failed to create descriptor pool!",
					() -> vkCreateDescriptorPool(vkDevice, poolInfo, null, aDescriptor));
			id = aDescriptor[0];
		}

		for (var descriptorSetAdapter : descriptorSetAdapters)
		{
			if (descriptorSetAdapter.getDescriptors().isEmpty() == false)
			{
				descriptorSetAdapter.allocate(stack);
			}
		}
	}

	@Override
	public boolean isAllocationDirty()
	{
		return resourceManager.isAllocationDirty();
	}

	@Override
	public void free()
	{
		for (var descriptorSetAdapter : descriptorSetAdapters)
		{
			descriptorSetAdapter.free();
		}
		descriptorSetAdapters = null;

		vkDestroyDescriptorPool(resourceManager.getVkDevice(), id, null);
	}

	public long getId()
	{
		return id;
	}

	public LongBuffer allocLayoutBuffer()
	{
		LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(descriptorSetAdapters.size());

		for (var descriptorSetAdapter : descriptorSetAdapters)
		{
			bDescriptorSet.put(descriptorSetAdapter.getLayoutId());
		}

		bDescriptorSet.flip();
		return bDescriptorSet;
	}
}
