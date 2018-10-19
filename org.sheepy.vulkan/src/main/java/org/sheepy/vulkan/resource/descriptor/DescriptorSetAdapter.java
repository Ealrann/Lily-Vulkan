package org.sheepy.vulkan.resource.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorSetAllocateInfo;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkDescriptorSetLayoutCreateInfo;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.allocation.adapter.impl.AbstractFlatAllocableAdapter;
import org.sheepy.vulkan.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.DescriptorSet;
import org.sheepy.vulkan.model.IDescriptor;
import org.sheepy.vulkan.resource.IResourceManagerAdapter;
import org.sheepy.vulkan.util.Logger;

public class DescriptorSetAdapter extends AbstractFlatAllocableAdapter
		implements IDescriptorSetAdapter
{
	private long descriptorSetId;
	private long layoutId;

	private DescriptorSet descriptorSet = null;

	@Override
	protected void load()
	{
		descriptorSet = (DescriptorSet) target;
	}

	@Override
	protected void unload()
	{
		descriptorSet = null;
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		final var resourceManager = IResourceManagerAdapter.adapt(target).getResourceManager();
		final var pool = resourceManager.descriptorPool;
		final var device = pool.getVkDevice();

		final var layoutBindings = createLayoutBinding(stack);

		final var layoutInfo = VkDescriptorSetLayoutCreateInfo.callocStack(stack);
		layoutInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO);
		layoutInfo.pBindings(layoutBindings);

		final long[] aDescriptorSetLayout = new long[1];
		Logger.check("Failed to create descriptor set layout!",
				() -> vkCreateDescriptorSetLayout(device, layoutInfo, null, aDescriptorSetLayout));
		layoutId = aDescriptorSetLayout[0];

		final LongBuffer layouts = MemoryUtil.memAllocLong(1);
		layouts.put(layoutId);
		layouts.flip();

		final var allocInfo = VkDescriptorSetAllocateInfo.callocStack(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO);
		allocInfo.descriptorPool(pool.getId());
		allocInfo.pSetLayouts(layouts);

		final long[] aDescriptorSet = new long[1];
		Logger.check("Failed to allocate descriptor set.",
				() -> vkAllocateDescriptorSets(device, allocInfo, aDescriptorSet));
		descriptorSetId = aDescriptorSet[0];

		updateDescriptorSet(stack, pool);
	}

	private VkDescriptorSetLayoutBinding.Buffer createLayoutBinding(MemoryStack stack)
	{
		final var descriptors = descriptorSet.getDescriptors();
		final int size = descriptors.size();
		final var layoutBindings = VkDescriptorSetLayoutBinding.callocStack(size, stack);

		int index = 0;
		for (final IDescriptor provider : descriptors)
		{
			final var adapter = IDescriptorAdapter.adapt(provider);
			final var layoutBinding = adapter.allocLayoutBinding(stack);
			layoutBinding.binding(index++);
			layoutBindings.put(layoutBinding);
		}
		layoutBindings.flip();
		return layoutBindings;
	}

	private void updateDescriptorSet(MemoryStack stack, DescriptorPool pool)
	{
		final VkWriteDescriptorSet.Buffer descriptorWrites = VkWriteDescriptorSet
				.callocStack(descriptorSet.getDescriptors().size(), stack);
		int index = 0;

		for (final IDescriptor descriptor : descriptorSet.getDescriptors())
		{
			final var adapter = IDescriptorAdapter.adapt(descriptor);
			final VkWriteDescriptorSet allocWriteDescriptor = adapter.allocWriteDescriptor(stack);
			allocWriteDescriptor.dstSet(descriptorSetId);
			allocWriteDescriptor.dstBinding(index++);
			descriptorWrites.put(allocWriteDescriptor);
		}
		descriptorWrites.flip();

		vkUpdateDescriptorSets(pool.getVkDevice(), descriptorWrites, null);
	}

	@Override
	public void bindDescriptorSet(	AbstractCommandBuffer commandBuffer,
									int bindPoint,
									long pipelineLayoutId)
	{
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
		final var bDescriptorSet = MemoryUtil.memAllocLong(1);
		bDescriptorSet.put(descriptorSetId);
		bDescriptorSet.flip();
		vkCmdBindDescriptorSets(vkCommandBuffer, bindPoint, pipelineLayoutId, 0, bDescriptorSet,
				null);
		MemoryUtil.memFree(bDescriptorSet);
	}

	@Override
	public long getId()
	{
		return descriptorSetId;
	}

	@Override
	public void free()
	{
		final var device = ILogicalDeviceAdapter.adapt(target).getVkDevice();
		vkDestroyDescriptorSetLayout(device, layoutId, null);
	}

	@Override
	public boolean isDirty()
	{
		return false;
	}

	@Override
	public long getLayoutId()
	{
		return layoutId;
	}

	public static DescriptorSetAdapter adapt(DescriptorSet object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, DescriptorSetAdapter.class);
	}
}
