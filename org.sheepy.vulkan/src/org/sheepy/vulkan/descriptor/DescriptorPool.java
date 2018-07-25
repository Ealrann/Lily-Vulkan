package org.sheepy.vulkan.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;

public class DescriptorPool implements Iterable<DescriptorSet>, IAllocable
{
	private LogicalDevice logicalDevice;
	private List<IDescriptorSetContext> contexts;

	private Map<IDescriptor, DescriptorSetInfo> infoMap = new HashMap<>();
	private Map<IDescriptorSetContext, DescriptorSet> configurationMap = new HashMap<>();
	private List<DescriptorSet> descriptorSets = new ArrayList<>();

	private long id;

	public DescriptorPool(LogicalDevice logicalDevice)
	{
		this(logicalDevice, Collections.emptyList());
	}

	public DescriptorPool(LogicalDevice logicalDevice,
			Collection<? extends IDescriptorSetContext> contexts)
	{
		this.logicalDevice = logicalDevice;
		this.contexts = new ArrayList<>(contexts);
	}

	public void addConfiguration(IDescriptorSetContext context)
	{
		this.contexts.add(context);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		int poolSize = 0;
		for (IDescriptorSetContext context : contexts)
		{
			poolSize += context.getDescriptors().size();
		}

		if (poolSize > 0)
		{
			VkDescriptorPoolSize.Buffer poolSizes = VkDescriptorPoolSize.callocStack(poolSize);

			for (IDescriptorSetContext context : contexts)
			{
				for (IDescriptor descriptor : context.getDescriptors())
				{
					poolSizes.put(descriptor.allocPoolSize(stack));
				}
			}
			poolSizes.flip();

			VkDescriptorPoolCreateInfo poolInfo = VkDescriptorPoolCreateInfo.callocStack();
			poolInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO);
			poolInfo.pPoolSizes(poolSizes);
			poolInfo.maxSets(contexts.size());

			long[] aDescriptor = new long[1];
			if (vkCreateDescriptorPool(logicalDevice.getVkDevice(), poolInfo, null,
					aDescriptor) != VK_SUCCESS)
			{
				throw new AssertionError("Failed to create descriptor pool!");
			}
			id = aDescriptor[0];

			for (IDescriptorSetContext context : contexts)
			{
				DescriptorSet descriptorSet = DescriptorSet.alloc(stack, logicalDevice, this,
						context);
				int index = 0;
				for (IDescriptor descriptor : context.getDescriptors())
				{
					DescriptorSetInfo info = new DescriptorSetInfo(descriptorSet, index++);
					infoMap.put(descriptor, info);
				}
				descriptorSets.add(descriptorSet);
				configurationMap.put(context, descriptorSet);
			}
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

	public DescriptorSet getDescriptorSet(IDescriptorSetContext context)
	{
		return configurationMap.get(context);
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
