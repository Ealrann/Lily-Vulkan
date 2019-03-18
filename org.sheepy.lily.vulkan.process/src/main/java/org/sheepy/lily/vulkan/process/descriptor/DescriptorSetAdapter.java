package org.sheepy.lily.vulkan.process.descriptor;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.IDescriptor;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.resource.nativehelper.VkDescriptorSet;

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
	public void allocate(MemoryStack stack, IAllocationContext context, DescriptorPool pool)
	{
		vkDescriptorSet = new VkDescriptorSet(getDescriptors());
		vkDescriptorSet.allocate(stack, context, pool);
	}

	@Override
	public void bindDescriptorSet(	AbstractCommandBuffer commandBuffer,
									int bindPoint,
									long pipelineLayoutId)
	{
		vkDescriptorSet.bindDescriptorSet(commandBuffer, bindPoint, pipelineLayoutId);
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
	public List<IVkDescriptor> getDescriptors()
	{
		gatherDescriptors();
		return vkDescriptors;
	}

	private void gatherDescriptors()
	{
		if (vkDescriptors == null)
		{
			var descriptors = descriptorSet.getDescriptors();
			vkDescriptors = new ArrayList<>(descriptors.size());
			for (IDescriptor descriptor : descriptors)
			{
				vkDescriptors.add(IDescriptorAdapter.adapt(descriptor));
			}
		}
	}

	public static DescriptorSetAdapter adapt(DescriptorSet object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, DescriptorSetAdapter.class);
	}
}
