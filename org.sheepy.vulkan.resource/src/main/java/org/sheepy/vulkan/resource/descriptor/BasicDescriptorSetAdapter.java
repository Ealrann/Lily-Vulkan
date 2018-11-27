package org.sheepy.vulkan.resource.descriptor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.model.resource.BasicDescriptorSet;
import org.sheepy.vulkan.model.resource.IDescriptor;
import org.sheepy.vulkan.model.resource.ResourcePackage;

public class BasicDescriptorSetAdapter extends AbstractDescriptorSetAdapter
{
	private List<IVkDescriptor> vkDescriptors = null;

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		if (vkDescriptors == null)
		{
			vkDescriptors = new ArrayList<>();
			var descriptors = ((BasicDescriptorSet) descriptorSet).getDescriptors();
			for(IDescriptor descriptor : descriptors)
			{
				vkDescriptors.add(IDescriptorAdapter.adapt(descriptor));
			}
		}
		return vkDescriptors;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.BASIC_DESCRIPTOR_SET == eClass;
	}

	public static BasicDescriptorSetAdapter adapt(BasicDescriptorSet object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, BasicDescriptorSetAdapter.class);
	}
}
