package org.sheepy.lily.game.vulkan.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.game.vulkan.buffer.Texture;
import org.sheepy.lily.game.vulkan.buffer.UniformBufferObject;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class DescriptorPool implements Iterable<DescriptorSet>
{
	private LogicalDevice logicalDevice;

	private List<DescriptorSet> descriptorSets = null;

	private long id;

	public static final DescriptorPool alloc(MemoryStack stack,
			LogicalDevice logicalDevice,
			UniformBufferObject uniformBuffer,
			Texture texture)
	{
		DescriptorPool res = new DescriptorPool(logicalDevice);
		res.load(stack, uniformBuffer, texture);
		return res;
	}

	private DescriptorPool(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	private void load(MemoryStack stack, UniformBufferObject uniformBuffer, Texture texture)
	{
		int size = 0;
		size += uniformBuffer != null ? 1 : 0;
		size += texture != null ? 1 : 0;

		VkDescriptorPoolSize.Buffer poolSizes = VkDescriptorPoolSize.callocStack(size);

		if (uniformBuffer != null)
		{
			VkDescriptorPoolSize poolSize = poolSizes.get();
			poolSize.type(VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER);
			poolSize.descriptorCount(1);
		}
		if (texture != null)
		{
			VkDescriptorPoolSize poolSize = poolSizes.get();
			poolSize.type(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
			poolSize.descriptorCount(1);
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

		descriptorSets.add(DescriptorSet.alloc(logicalDevice, this, uniformBuffer, texture));
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
}
