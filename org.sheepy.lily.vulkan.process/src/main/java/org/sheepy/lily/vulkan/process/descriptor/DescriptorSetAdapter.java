package org.sheepy.lily.vulkan.process.descriptor;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize.Buffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.common.resource.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.descriptor.VkDescriptorSet;
import org.sheepy.vulkan.device.IVulkanContext;

@Statefull
@Adapter(scope = DescriptorSet.class)
public final class DescriptorSetAdapter implements IDescriptorSetAdapter
{
	private final List<IVkDescriptor> descriptors;

	private VkDescriptorSet vkDescriptorSet;

	public DescriptorSetAdapter(DescriptorSet descriptorSet)
	{
		descriptors = List.copyOf(gatherDescriptors(descriptorSet));
	}

	@Override
	public void allocate(IVulkanContext context, long poolAddress)
	{
		vkDescriptorSet = new VkDescriptorSet(descriptors);
		vkDescriptorSet.allocate(context, poolAddress);
	}

	@Override
	public void free(IVulkanContext context)
	{
		vkDescriptorSet.free(context);
		vkDescriptorSet = null;
	}

	@Override
	public void fillPoolSizes(Buffer poolSizes)
	{
		for (final var descriptor : descriptors)
		{
			if (descriptor.isEmpty() == false)
			{
				final var poolSize = poolSizes.get();
				descriptor.fillPoolSize(poolSize);
			}
		}
	}

	@Override
	public void updateDescriptorSet(MemoryStack stack)
	{
		vkDescriptorSet.updateDescriptorSet(stack);
	}

	@Override
	public long getId()
	{
		return vkDescriptorSet.getId();
	}

	@Override
	public long getLayoutId()
	{
		return vkDescriptorSet.getLayoutId();
	}

	@Override
	public int descriptorCount()
	{
		int res = 0;
		for (final var descriptor : descriptors)
		{
			if (descriptor.isEmpty() == false)
			{
				res++;
			}
		}
		return res;
	}

	private static List<IVkDescriptor> gatherDescriptors(DescriptorSet descriptorSet)
	{
		final var descriptors = descriptorSet.getDescriptors();
		final List<IVkDescriptor> vkDescriptors = new ArrayList<>(descriptors.size());
		for (final var descriptor : descriptors)
		{
			final var adapter = descriptor.adaptNotNull(IDescriptorAdapter.class);
			vkDescriptors.add(adapter.getVkDescriptor());
		}
		return List.copyOf(vkDescriptors);
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
