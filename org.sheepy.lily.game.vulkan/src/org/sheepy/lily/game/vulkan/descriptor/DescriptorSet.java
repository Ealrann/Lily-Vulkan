package org.sheepy.lily.game.vulkan.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorSetAllocateInfo;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkDescriptorSetLayoutCreateInfo;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.vertex.UniformBufferObject;

public class DescriptorSet
{
	private LogicalDevice logicalDevice;
	
	private long descriptorSetId;
	private long descriptorSetLayout;

	public static final DescriptorSet alloc(LogicalDevice logicalDevice, DescriptorPool pool)
	{
		DescriptorSet res = new DescriptorSet(logicalDevice);
		res.load(pool);
		return res;
	}
	
	private DescriptorSet(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	private void load(DescriptorPool pool)
	{
		VkDescriptorSetLayoutBinding.Buffer uboLayoutBinding = VkDescriptorSetLayoutBinding
				.calloc(1);
		uboLayoutBinding.binding(0);
		uboLayoutBinding.descriptorType(VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER);
		uboLayoutBinding.descriptorCount(1);
		uboLayoutBinding.stageFlags(VK_SHADER_STAGE_VERTEX_BIT);
		uboLayoutBinding.pImmutableSamplers(null); // Optional

		VkDescriptorSetLayoutCreateInfo layoutInfo = VkDescriptorSetLayoutCreateInfo.calloc();
		layoutInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO);
		layoutInfo.pBindings(uboLayoutBinding);

		LongBuffer bDescriptorSetLayout = MemoryUtil.memAllocLong(1);
		if (vkCreateDescriptorSetLayout(logicalDevice.getVkDevice(), layoutInfo, null,
				bDescriptorSetLayout) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create descriptor set layout!");
		}
		descriptorSetLayout = bDescriptorSetLayout.get(0);
		
		LongBuffer layouts = MemoryUtil.memAllocLong(1);
		layouts.put(descriptorSetLayout);
		layouts.flip();

		VkDescriptorSetAllocateInfo allocInfo = VkDescriptorSetAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO);
		allocInfo.descriptorPool(pool.getId());
		allocInfo.pSetLayouts(layouts);

		long[] aDescriptorSet = new long[1];
		if (vkAllocateDescriptorSets(logicalDevice.getVkDevice(), allocInfo,
				aDescriptorSet) != VK_SUCCESS)
		{
			throw new AssertionError("failed to allocate descriptor set!");
		}
		descriptorSetId = aDescriptorSet[0];

		MemoryUtil.memFree(bDescriptorSetLayout);
	}
	
	public void updateDescriptorSet(UniformBufferObject uniformBufferObject)
	{
		VkDescriptorBufferInfo.Buffer bufferInfo = VkDescriptorBufferInfo.calloc(1);
		bufferInfo.buffer(uniformBufferObject.getBufferId());
		bufferInfo.offset(0);
		bufferInfo.range(UniformBufferObject.SIZE_OF);
		
		VkWriteDescriptorSet.Buffer descriptorWrite = VkWriteDescriptorSet.calloc(1);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstSet(descriptorSetId);
		descriptorWrite.dstBinding(0);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER);
		descriptorWrite.pBufferInfo(bufferInfo);
		descriptorWrite.pImageInfo(null); // Optional
		descriptorWrite.pTexelBufferView(null); // Optional
		
		vkUpdateDescriptorSets(logicalDevice.getVkDevice(), descriptorWrite, null);
	}
	
	public long getId()
	{
		return descriptorSetId;
	}
	
	public void destroy()
	{
		vkDestroyDescriptorSetLayout(logicalDevice.getVkDevice(), descriptorSetLayout, null);
	}

	public long getLayoutId()
	{
		return descriptorSetLayout;
	}
}
