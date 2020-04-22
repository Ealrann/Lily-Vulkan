package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.resource.ISamplerAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.SamplerDescriptor;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@ModelExtender(scope = SamplerDescriptor.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.SAMPLER_DESCRIPTOR__SAMPLER, type = ISamplerAllocation.class)
public class SamplerDescriptorAllocation implements IDescriptorAllocation
{
	private final VkImageDescriptor vkDescriptor;

	public SamplerDescriptorAllocation(SamplerDescriptor descriptor,
									   @InjectDependency(index = 0) ISamplerAllocation samplerAllocation)
	{
		vkDescriptor = new VkImageDescriptor(samplerAllocation.getViewPtr(),
											 samplerAllocation.getSamplerPtr(),
											 EImageLayout.GENERAL,
											 descriptor.getType(),
											 descriptor.getShaderStages());
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
