package org.sheepy.lily.game.vulkan.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.game.vulkan.common.IAllocable;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class DescriptorPool implements Iterable<DescriptorSet>, IAllocable
{
	private LogicalDevice logicalDevice;
	private List<IDescriptorSetConfiguration> configurations;

	private Map<IDescriptor, DescriptorSetInfo> infoMap = new HashMap<>();
	private Map<IDescriptorSetConfiguration, DescriptorSet> configurationMap = new HashMap<>();
	private List<DescriptorSet> descriptorSets = new ArrayList<>();

	private long id;

	public static final DescriptorPool alloc(MemoryStack stack,
			LogicalDevice logicalDevice,
			Collection<? extends IDescriptorSetConfiguration> configurations)
	{
		DescriptorPool res = new DescriptorPool(logicalDevice, configurations);
		res.allocate(stack);
		return res;
	}

	public DescriptorPool(LogicalDevice logicalDevice,
			Collection<? extends IDescriptorSetConfiguration> configurations)
	{
		this.logicalDevice = logicalDevice;
		this.configurations = new ArrayList<>(configurations);
	}
	
	public void addConfiguration(IDescriptorSetConfiguration configuration)
	{
		this.configurations.add(configuration);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		int poolSize = 0;
		for (IDescriptorSetConfiguration configuration : configurations)
		{
			poolSize += configuration.getDescriptors().size();
		}

		VkDescriptorPoolSize.Buffer poolSizes = VkDescriptorPoolSize.callocStack(poolSize);

		for (IDescriptorSetConfiguration configuration : configurations)
		{
			for (IDescriptor descriptor : configuration.getDescriptors())
			{
				poolSizes.put(descriptor.allocPoolSize(stack));
			}
		}
		poolSizes.flip();

		VkDescriptorPoolCreateInfo poolInfo = VkDescriptorPoolCreateInfo.callocStack();
		poolInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO);
		poolInfo.pPoolSizes(poolSizes);
		poolInfo.maxSets(configurations.size());

		long[] aDescriptor = new long[1];
		if (vkCreateDescriptorPool(logicalDevice.getVkDevice(), poolInfo, null,
				aDescriptor) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create descriptor pool!");
		}
		id = aDescriptor[0];

		for (IDescriptorSetConfiguration configuration : configurations)
		{
			DescriptorSet descriptorSet = DescriptorSet.alloc(stack, logicalDevice, this,
					configuration);
			int index = 0;
			for (IDescriptor descriptor : configuration.getDescriptors())
			{
				DescriptorSetInfo info = new DescriptorSetInfo(descriptorSet, index++);
				infoMap.put(descriptor, info);
			}
			descriptorSets.add(descriptorSet);
			configurationMap.put(configuration, descriptorSet);
		}
	}

	@Override
	public void free()
	{
		for (DescriptorSet descriptorSet : descriptorSets)
		{
			descriptorSet.destroy();
		}
		vkDestroyDescriptorPool(logicalDevice.getVkDevice(), id, null);

		configurationMap.clear();
		infoMap.clear();
		descriptorSets.clear();
	}

	public long getId()
	{
		return id;
	}

	public DescriptorSet getDescriptorSet(int index)
	{
		return descriptorSets.get(index);
	}

	public DescriptorSet getDescriptorSet(IDescriptorSetConfiguration configuration)
	{
		return configurationMap.get(configuration);
	}

	public DescriptorSetInfo getDescriptorSetInfo(IDescriptor descriptor)
	{
		return infoMap.get(descriptor);
	}

	public LongBuffer allocLayoutBuffer()
	{
		LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(descriptorSets.size());

		for (DescriptorSet descriptorSet : descriptorSets)
		{
			bDescriptorSet.put(descriptorSet.getLayoutId());
		}

		bDescriptorSet.flip();
		return bDescriptorSet;
	}

	@Override
	public Iterator<DescriptorSet> iterator()
	{
		return descriptorSets.iterator();
	}

	public int size()
	{
		return descriptorSets.size();
	}
}
