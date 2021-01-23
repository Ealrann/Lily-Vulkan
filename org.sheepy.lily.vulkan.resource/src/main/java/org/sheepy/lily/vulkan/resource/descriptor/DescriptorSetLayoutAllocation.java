package org.sheepy.lily.vulkan.resource.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkDescriptorSetLayoutCreateInfo;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetLayoutAllocation;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;

import static org.lwjgl.vulkan.VK10.*;

@ModelExtender(scope = DescriptorSet.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(features = VulkanResourcePackage.DESCRIPTOR_SET__DESCRIPTORS, type = IDescriptorAllocation.class)
public final class DescriptorSetLayoutAllocation implements IDescriptorSetLayoutAllocation
{
	private static final String FAILED_TO_CREATE_DESCRIPTOR_SET_LAYOUT = "Failed to create descriptor set layout";

	private final long layoutPtr;
	private final VkDevice device;
	private final DescriptorSet descriptorSet;

	public DescriptorSetLayoutAllocation(DescriptorSet descriptorSet,
										 ExecutionContext context,
										 IAllocationState config,
										 IObservatoryBuilder observatory)
	{
		this.descriptorSet = descriptorSet;

		// Obsolete when structure change
		observatory.listenNoParam(config::setAllocationObsolete, VulkanResourcePackage.DESCRIPTOR_SET__DESCRIPTORS);

		final var stack = context.stack();
		device = context.getVkDevice();
		layoutPtr = allocateLayout(stack);
	}

	@Free
	public void free(ExecutionContext context)
	{
		final var device = context.getVkDevice();
		vkDestroyDescriptorSetLayout(device, layoutPtr, null);
	}

	@Override
	public int descriptorCount()
	{
		int res = 0;
		for (final var descriptor : descriptorSet.getDescriptors())
		{
			final var adapter = descriptor.adapt(IDescriptorAdapter.class);
			if (adapter.isEmpty() == false)
			{
				res++;
			}
		}
		return res;
	}

	private long allocateLayout(final MemoryStack stack)
	{
		final var layoutBindings = createLayoutBinding(stack);
		final var layoutInfo = VkDescriptorSetLayoutCreateInfo.callocStack(stack);
		layoutInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_CREATE_INFO);
		layoutInfo.pBindings(layoutBindings);

		final long[] aDescriptorSetLayout = new long[1];
		Logger.check(FAILED_TO_CREATE_DESCRIPTOR_SET_LAYOUT,
					 () -> vkCreateDescriptorSetLayout(device, layoutInfo, null, aDescriptorSetLayout));
		return aDescriptorSetLayout[0];
	}

	private VkDescriptorSetLayoutBinding.Buffer createLayoutBinding(MemoryStack stack)
	{
		final int size = descriptorCount();
		final var layoutBindings = VkDescriptorSetLayoutBinding.callocStack(size, stack);

		int index = 0;
		for (final var descriptor : descriptorSet.getDescriptors())
		{
			final var adapter = descriptor.adapt(IDescriptorAdapter.class);
			if (adapter.isEmpty() == false)
			{
				final var layoutBinding = adapter.allocLayoutBinding(stack);
				layoutBinding.binding(index);
				layoutBindings.put(layoutBinding);
			}
			index++;
		}
		layoutBindings.flip();
		return layoutBindings;
	}

	@Override
	public long getLayoutPtr()
	{
		return layoutPtr;
	}
}
