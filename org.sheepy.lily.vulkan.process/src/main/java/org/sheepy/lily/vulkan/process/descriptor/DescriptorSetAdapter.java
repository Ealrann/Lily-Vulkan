package org.sheepy.lily.vulkan.process.descriptor;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize.Buffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IDescriptedResourceAdapter;
import org.sheepy.lily.vulkan.api.resource.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.descriptor.VkDescriptorSet;
import org.sheepy.vulkan.device.IVulkanContext;

@Statefull
@Adapter(scope = DescriptorSet.class)
public class DescriptorSetAdapter implements IDescriptorSetAdapter
{
	protected VkDescriptorSet vkDescriptorSet;
	protected DescriptorSet descriptorSet = null;

	private List<IVkDescriptor> vkDescriptors = null;

	public DescriptorSetAdapter(DescriptorSet descriptorSet)
	{
		this.descriptorSet = descriptorSet;
	}

	@Override
	public void allocate(IVulkanContext context, long poolAddress)
	{
		vkDescriptorSet = new VkDescriptorSet(getDescriptors());
		vkDescriptorSet.allocate(context, poolAddress);
	}

	@Override
	public void fillPoolSizes(Buffer poolSizes)
	{
		for (final var descriptor : getDescriptors())
		{
			final var poolSize = poolSizes.get();
			descriptor.fillPoolSize(poolSize);
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
	public void free(IVulkanContext context)
	{
		vkDescriptorSet.free(context);
		vkDescriptorSet = null;
		vkDescriptors = null;
	}

	@Override
	public int descriptorCount()
	{
		return getDescriptors().size();
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		gatherDescriptors();
		return vkDescriptors;
	}

	private void gatherDescriptors()
	{
		if (vkDescriptors == null)
		{
			final var descriptors = descriptorSet.getDescriptors();
			vkDescriptors = new ArrayList<>(descriptors.size());
			for (final var descriptor : descriptors)
			{
				final var adapter = descriptor.adaptNotNull(IDescriptedResourceAdapter.class);
				final var gatherDescriptors = adapter.getDescriptors();
				vkDescriptors.addAll(gatherDescriptors);
			}
			vkDescriptors = List.copyOf(vkDescriptors);
		}
	}

	@Override
	public String toString()
	{
		return vkDescriptorSet.toString();
	}
}
