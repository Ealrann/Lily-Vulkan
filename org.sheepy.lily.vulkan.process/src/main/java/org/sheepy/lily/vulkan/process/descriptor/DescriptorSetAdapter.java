package org.sheepy.lily.vulkan.process.descriptor;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolSize.Buffer;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.nativehelper.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.api.nativehelper.descriptor.VkDescriptorSet;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.IDescriptor;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;

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
	public void allocate(MemoryStack stack, IAllocationContext context, long poolAddress)
	{
		vkDescriptorSet = new VkDescriptorSet(getDescriptors());
		vkDescriptorSet.allocate(stack, context, poolAddress);
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
	public void free(IAllocationContext context)
	{
		vkDescriptorSet.free(context);
		vkDescriptorSet = null;
		vkDescriptors = null;
	}

	@Override
	public int size()
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
			for (final IDescriptor descriptor : descriptors)
			{
				vkDescriptors.add(IDescriptorAdapter.adapt(descriptor));
			}
			vkDescriptors = List.copyOf(vkDescriptors);
		}
	}

	public static DescriptorSetAdapter adapt(DescriptorSet object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, DescriptorSetAdapter.class);
	}
}
