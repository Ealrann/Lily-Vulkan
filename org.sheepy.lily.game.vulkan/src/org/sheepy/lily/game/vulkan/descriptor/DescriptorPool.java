package org.sheepy.lily.game.vulkan.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class DescriptorPool implements Iterable<DescriptorSet>
{
	private LogicalDevice logicalDevice;

	private List<DescriptorSet> descriptorSets = null;

	private long id;

	public static final DescriptorPool alloc(MemoryStack stack,
			LogicalDevice logicalDevice,
			Collection<IDescriptor> descriptors)
	{
		DescriptorPool res = new DescriptorPool(logicalDevice);
		res.load(stack, descriptors);
		return res;
	}

	private DescriptorPool(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	private void load(MemoryStack stack, Collection<IDescriptor> descriptors)
	{
		VkDescriptorPoolSize.Buffer poolSizes = VkDescriptorPoolSize
				.callocStack(descriptors.size());

		for (IDescriptor descriptor : descriptors)
		{
			poolSizes.put(descriptor.allocPoolSize(stack));
		}
		poolSizes.flip();

		VkDescriptorPoolCreateInfo poolInfo = VkDescriptorPoolCreateInfo.callocStack();
		poolInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO);
		poolInfo.pPoolSizes(poolSizes);
		poolInfo.maxSets(1);

		long[] aDescriptor = new long[1];
		if (vkCreateDescriptorPool(logicalDevice.getVkDevice(), poolInfo, null,
				aDescriptor) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create descriptor pool!");
		}
		id = aDescriptor[0];

		descriptorSets = new ArrayList<>();

		descriptorSets.add(DescriptorSet.alloc(stack, logicalDevice, this, descriptors));
	}

	public void destroy()
	{
		for (DescriptorSet descriptorSet : descriptorSets)
		{
			descriptorSet.destroy();
		}
		vkDestroyDescriptorPool(logicalDevice.getVkDevice(), id, null);
	}

	public long getId()
	{
		return id;
	}

	public int getSize()
	{
		return descriptorSets.size();
	}

	public DescriptorSet get(int index)
	{
		return descriptorSets.get(index);
	}

	@Override
	public Iterator<DescriptorSet> iterator()
	{
		return descriptorSets.iterator();
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
}
