package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.allocation.up.annotation.Allocable;
import org.sheepy.lily.core.api.allocation.up.annotation.Dependency;
import org.sheepy.lily.core.api.allocation.up.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.resource.ISamplerAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.SamplerDescriptor;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@ModelExtender(scope = SamplerDescriptor.class)
@Allocable
public class SamplerDescriptorAllocation implements IDescriptorAllocation
{
	private final VkImageDescriptor vkDescriptor;

	public SamplerDescriptorAllocation(SamplerDescriptor descriptor,
									   @Dependency(features = VulkanResourcePackage.SAMPLER_DESCRIPTOR__SAMPLER, type = ISamplerAllocation.class) ISamplerAllocation samplerAllocation)
	{
		vkDescriptor = new VkImageDescriptor(0,
											 0,
											 EImageLayout.GENERAL,
											 descriptor.getType(),
											 descriptor.getShaderStages());

		vkDescriptor.updateSamplerPtr(samplerAllocation.getSamplerPtr());
		vkDescriptor.updateViewPtr(samplerAllocation.getViewPtr());
	}

	@UpdateDependency(features = VulkanResourcePackage.SAMPLER_DESCRIPTOR__SAMPLER)
	private void update(ISamplerAllocation samplerAllocation)
	{
		vkDescriptor.updateSamplerPtr(samplerAllocation.getSamplerPtr());
		vkDescriptor.updateViewPtr(samplerAllocation.getViewPtr());
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
