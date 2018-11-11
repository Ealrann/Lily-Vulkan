package org.sheepy.vulkan.resource.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorSetAllocateInfo;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkDescriptorSetLayoutCreateInfo;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.common.allocation.adapter.impl.AbstractFlatAllocableAdapter;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.resource.IDescriptor;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.resource.IResourceManagerAdapter;

public class DescriptorSetAdapter extends AbstractFlatAllocableAdapter
		implements IDescriptorSetAdapter
{
	private long descriptorSetId;
	private long layoutId;

	private DescriptorSet descriptorSet = null;

	@Override
	public void setTarget(Notifier target)
	{
		descriptorSet = (DescriptorSet) target;
		super.setTarget(target);
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		var resourceManager = IResourceManagerAdapter.adapt(target).getResourceManager(target);
		var pool = resourceManager.descriptorPool;
		var device = pool.getVkDevice();

		var layoutBindings = createLayoutBinding(stack);

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
		final var device = ILogicalDeviceAdapter.adapt(target).getVkDevice(target);
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

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.DESCRIPTOR_SET == eClass;
	}

	public static DescriptorSetAdapter adapt(DescriptorSet object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, DescriptorSetAdapter.class);
	}
}
