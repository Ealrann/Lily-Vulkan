package org.sheepy.vulkan.process.descriptor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.resource.IDescriptor;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.resource.descriptor.DescriptorPool;
import org.sheepy.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.vulkan.resource.descriptor.IDescriptorSetAdapter;
import org.sheepy.vulkan.resource.descriptor.IVkDescriptor;
import org.sheepy.vulkan.resource.nativehelper.VkDescriptorSet;

public class DescriptorSetAdapter extends AbstractStatefullAdapter
		implements IDescriptorSetAdapter
{
	protected VkDescriptorSet vkDescriptorSet;
	protected DescriptorSet descriptorSet = null;

	private List<IVkDescriptor> vkDescriptors = null;

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
			vkDescriptors = new ArrayList<>();
			var descriptors = descriptorSet.getDescriptors();
			for (IDescriptor descriptor : descriptors)
			{
				vkDescriptors.add(IDescriptorAdapter.adapt(descriptor));
			}
		}
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.DESCRIPTOR_SET == eClass;
	}

	public static DescriptorSetAdapter adapt(DescriptorSet object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, DescriptorSetAdapter.class);
	}
}
