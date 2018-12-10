package org.sheepy.vulkan.resource.descriptor;

import org.eclipse.emf.common.notify.Notifier;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.resource.IResourceManagerAdapter;
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
	public void allocate(MemoryStack stack)
	{
		var resourceManager = IResourceManagerAdapter.adapt(target).getResourceManager(target);
		var pool = resourceManager.descriptorPool;

		vkDescriptorSet = new VkDescriptorSet(pool, getDescriptors());
		vkDescriptorSet.allocate(stack);
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

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}

	public static AbstractDescriptorSetAdapter adapt(DescriptorSet object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, AbstractDescriptorSetAdapter.class);
	}
}
