package org.sheepy.vulkan.process.descriptor;

import org.eclipse.emf.common.notify.Notifier;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.resource.descriptor.DescriptorPool;
import org.sheepy.vulkan.resource.descriptor.IDescriptorSetAdapter;
import org.sheepy.vulkan.resource.nativehelper.VkDescriptorSet;

public abstract class AbstractDescriptorSetAdapter extends AbstractStatefullAdapter
		implements IDescriptorSetAdapter
{
	protected VkDescriptorSet vkDescriptorSet;
	protected DescriptorSet descriptorSet = null;

	@Override
	public void setTarget(Notifier target)
	{
		descriptorSet = (DescriptorSet) target;
		super.setTarget(target);
	}

	@Override
	public void allocate(MemoryStack stack, DescriptorPool pool)
	{
		vkDescriptorSet = new VkDescriptorSet(getDescriptors());
		vkDescriptorSet.allocate(stack, pool);
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
	public void free()
	{
		vkDescriptorSet.free();
		vkDescriptorSet = null;
	}

	public static AbstractDescriptorSetAdapter adapt(DescriptorSet object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, AbstractDescriptorSetAdapter.class);
	}
}
