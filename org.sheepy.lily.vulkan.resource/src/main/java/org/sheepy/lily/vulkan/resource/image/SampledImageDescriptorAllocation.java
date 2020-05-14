package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.up.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.up.annotation.InjectDependency;
import org.sheepy.lily.core.api.allocation.up.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.resource.ISampledImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@ModelExtender(scope = SampledImageDescriptor.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.SAMPLED_IMAGE_DESCRIPTOR__SAMPLED_IMAGE, type = ISampledImageAllocation.class)
public class SampledImageDescriptorAllocation implements IDescriptorAllocation
{
	private final VkImageDescriptor vkDescriptor;

	public SampledImageDescriptorAllocation(SampledImageDescriptor descriptor,
											@InjectDependency(index = 0) ISampledImageAllocation imageAllocation)
	{
		final var sampledImage = descriptor.getSampledImage();
		final var initialLayout = sampledImage.getImage().getInitialLayout();
		final var layout = initialLayout != null ? initialLayout.getLayout() : EImageLayout.SHADER_READ_ONLY_OPTIMAL;

		vkDescriptor = new VkImageDescriptor(imageAllocation.getViewPtr(),
											 imageAllocation.getSamplerPtr(),
											 layout,
											 descriptor.getType(),
											 descriptor.getShaderStages());
	}

	@UpdateDependency(index = 0)
	private void update(ISampledImageAllocation imageAllocation)
	{
		vkDescriptor.updateSamplerPtr(imageAllocation.getSamplerPtr());
		vkDescriptor.updateViewPtr(imageAllocation.getViewPtr());
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
