package org.sheepy.lily.vulkan.process.descriptor;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize.Buffer;
import org.sheepy.lily.core.api.allocation.up.annotation.Allocable;
import org.sheepy.lily.core.api.allocation.up.annotation.Dependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.descriptor.VkDescriptorSet;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.util.List;

@ModelExtender(scope = DescriptorSet.class)
@Allocable
public final class DescriptorSetAllocation implements IDescriptorSetAllocation
{
	private final List<IDescriptorAllocation> descriptors;
	private final VkDescriptorSet vkDescriptorSet;

	public DescriptorSetAllocation(@Dependency(features = VulkanResourcePackage.DESCRIPTOR_SET__DESCRIPTORS, type = IDescriptorAllocation.class) List<IDescriptorAllocation> descriptorAllocations)
	{
		descriptors = List.copyOf(descriptorAllocations);
		vkDescriptorSet = new VkDescriptorSet(descriptors);
	}

	@Override
	public void allocate(ExecutionContext context, long poolAddress)
	{
		vkDescriptorSet.allocate(context, poolAddress);
	}

	@Override
	public void free(ExecutionContext context)
	{
		vkDescriptorSet.free(context);
	}

	@Override
	public void fillPoolSizes(Buffer poolSizes)
	{
		for (final var descriptor : descriptors)
		{
			final var vkDescriptor = descriptor.getVkDescriptor();
			if (vkDescriptor.isEmpty() == false)
			{
				final var poolSize = poolSizes.get();
				vkDescriptor.fillPoolSize(poolSize);
			}
		}
	}

	@Override
	public void updateDescriptorSet(MemoryStack stack)
	{
		vkDescriptorSet.updateDescriptorSet(stack);
	}

	@Override
	public long getPtr()
	{
		return vkDescriptorSet.getId();
	}

	@Override
	public long getLayoutPtr()
	{
		return vkDescriptorSet.getLayoutId();
	}

	@Override
	public int descriptorCount()
	{
		int res = 0;
		for (final var descriptor : descriptors)
		{
			final var vkDescriptor = descriptor.getVkDescriptor();
			if (vkDescriptor.isEmpty() == false)
			{
				res++;
			}
		}
		return res;
	}

	@Override
	public void prepare()
	{
		vkDescriptorSet.prepare();
	}

	@Override
	public boolean hasChanged()
	{
		return vkDescriptorSet.hasChanged();
	}

	@Override
	public String toString()
	{
		return vkDescriptorSet.toString();
	}
}
