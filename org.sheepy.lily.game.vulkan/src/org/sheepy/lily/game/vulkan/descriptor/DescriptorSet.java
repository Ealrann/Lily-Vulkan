package org.sheepy.lily.game.vulkan.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorImageInfo;
import org.lwjgl.vulkan.VkDescriptorSetAllocateInfo;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkDescriptorSetLayoutCreateInfo;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.game.vulkan.buffer.Texture;
import org.sheepy.lily.game.vulkan.buffer.UniformBufferObject;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class DescriptorSet
{
	private LogicalDevice logicalDevice;

	private long descriptorSetId;
	private long descriptorSetLayout;

	private int size;

	public static final DescriptorSet alloc(LogicalDevice logicalDevice,
			DescriptorPool pool,
			UniformBufferObject uniformBufferObject,
			Texture texture)
	{
		DescriptorSet res = new DescriptorSet(logicalDevice);
		res.load(pool, uniformBufferObject, texture);
		return res;
	}

	private DescriptorSet(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	private void load(DescriptorPool pool, UniformBufferObject uniformBuffer, Texture texture)
	{
		size = 0;
		size += uniformBuffer != null ? 1 : 0;
		size += texture != null ? 1 : 0;

		VkDescriptorSetLayoutBinding.Buffer layoutBindings = createLayoutBinding(uniformBuffer, texture);

		VkDescriptorSetLayoutCreateInfo layoutInfo = VkDescriptorSetLayoutCreateInfo.calloc();
		layoutInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO);
		layoutInfo.pBindings(layoutBindings);

		long[] aDescriptorSetLayout = new long[1];
		if (vkCreateDescriptorSetLayout(logicalDevice.getVkDevice(), layoutInfo, null,
				aDescriptorSetLayout) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create descriptor set layout!");
		}
		descriptorSetLayout = aDescriptorSetLayout[0];

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

		if (uniformBuffer != null)
		{
			uniformBuffer.load(this);
		}

		updateDescriptorSet(uniformBuffer, texture);
	}

	private VkDescriptorSetLayoutBinding.Buffer createLayoutBinding(
			UniformBufferObject uniformBuffer, Texture texture)
	{
		VkDescriptorSetLayoutBinding.Buffer layoutBindings = VkDescriptorSetLayoutBinding
				.calloc(size);

		int index = 0;
		if (uniformBuffer != null)
		{
			VkDescriptorSetLayoutBinding layoutBinding = layoutBindings.get();
			layoutBinding.binding(index++);
			layoutBinding.descriptorType(VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER);
			layoutBinding.descriptorCount(1);
			layoutBinding.stageFlags(VK_SHADER_STAGE_VERTEX_BIT);
		}
		
		if (texture != null)
		{
			VkDescriptorSetLayoutBinding samplerLayoutBinding = layoutBindings.get();
			samplerLayoutBinding.binding(index++);
			samplerLayoutBinding.descriptorType(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
			samplerLayoutBinding.descriptorCount(1);
			samplerLayoutBinding.stageFlags(VK_SHADER_STAGE_FRAGMENT_BIT);
		}

		layoutBindings.flip();
		return layoutBindings;
	}

	private void updateDescriptorSet(UniformBufferObject uniformBuffer, Texture texture)
	{
		VkWriteDescriptorSet.Buffer descriptorWrites = VkWriteDescriptorSet.calloc(size);
		int index = 0;
		if (uniformBuffer != null)
		{
			VkDescriptorBufferInfo.Buffer bufferInfos = VkDescriptorBufferInfo.calloc(1);
			bufferInfos.buffer(uniformBuffer.getBufferId());
			bufferInfos.offset(0);
			bufferInfos.range(UniformBufferObject.SIZE_OF);

			VkWriteDescriptorSet descriptorWrite = descriptorWrites.get();
			descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
			descriptorWrite.dstSet(descriptorSetId);
			descriptorWrite.dstBinding(index++);
			descriptorWrite.dstArrayElement(0);
			descriptorWrite.descriptorType(VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER);
			descriptorWrite.pBufferInfo(bufferInfos);
			descriptorWrite.pImageInfo(null); // Optional
			descriptorWrite.pTexelBufferView(null); // Optional
		}
		
		if (texture != null)
		{
			VkDescriptorImageInfo.Buffer imageInfo = VkDescriptorImageInfo.calloc(1);
			imageInfo.imageLayout(VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL);
			imageInfo.imageView(texture.getImageViewId());
			imageInfo.sampler(texture.getSampler().getId());

			VkWriteDescriptorSet descriptorWrite = descriptorWrites.get();
			descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
			descriptorWrite.dstSet(descriptorSetId);
			descriptorWrite.dstBinding(index++);
			descriptorWrite.dstArrayElement(0);
			descriptorWrite.descriptorType(VK_DESCRIPTOR_TYPE_COMBINED_IMAGE_SAMPLER);
			descriptorWrite.pBufferInfo(null);
			descriptorWrite.pImageInfo(imageInfo); // Optional
			descriptorWrite.pTexelBufferView(null); // Optional
		}

		descriptorWrites.flip();

		vkUpdateDescriptorSets(logicalDevice.getVkDevice(), descriptorWrites, null);
		
		descriptorWrites.free();
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
