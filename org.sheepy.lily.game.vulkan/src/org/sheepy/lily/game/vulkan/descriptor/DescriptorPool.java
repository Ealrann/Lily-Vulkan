package org.sheepy.lily.game.vulkan.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class DescriptorPool implements Iterable<DescriptorSet>
{
	private LogicalDevice logicalDevice;

	private List<DescriptorSet> descriptorSets = null;

	private long id;
	private int size;

	public static final DescriptorPool alloc(MemoryStack stack,
			LogicalDevice logicalDevice,
			int descriptorSetCount)
	{
		DescriptorPool res = new DescriptorPool(logicalDevice);
		res.load(stack, descriptorSetCount);
		return res;
	}

	private DescriptorPool(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	private void load(MemoryStack stack, int size)
	{
		this.size = size;

		VkDescriptorPoolSize.Buffer poolSize = VkDescriptorPoolSize.callocStack(1);
		poolSize.type(VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER);
		poolSize.descriptorCount(size);

		VkDescriptorPoolCreateInfo poolInfo = VkDescriptorPoolCreateInfo.callocStack();
		poolInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO);
		poolInfo.pPoolSizes(poolSize);
		poolInfo.maxSets(1);

		long[] aDescriptor = new long[1];
		if (vkCreateDescriptorPool(logicalDevice.getVkDevice(), poolInfo, null,
				aDescriptor) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create descriptor pool!");
		}
		id = aDescriptor[0];

		// Building the descriptorSets
		descriptorSets = new ArrayList<>();
		for (int i = 0; i < size; i++)
		{
			descriptorSets.add(DescriptorSet.alloc(logicalDevice, this));
		}
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
		return size;
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
}
