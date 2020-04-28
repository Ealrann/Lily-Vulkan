package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.allocation.up.annotation.Allocable;
import org.sheepy.lily.core.api.allocation.up.annotation.Dependency;
import org.sheepy.lily.core.api.allocation.up.annotation.Free;
import org.sheepy.lily.core.api.allocation.up.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@ModelExtender(scope = ImageDescriptor.class)
@Allocable
public final class ImageDescriptorAllocation implements IDescriptorAllocation
{
	private final VkImageDescriptor vkDescriptor;

	private ImageDescriptorAllocation(ImageDescriptor descriptor,
									  @Dependency(features = VulkanResourcePackage.IMAGE_DESCRIPTOR__IMAGE, type = IVkImageAllocation.class) IVkImageAllocation imageAllocation)
	{
		this.vkDescriptor = new VkImageDescriptor(imageAllocation.getViewPtr(),
												  0,
												  EImageLayout.GENERAL,
												  descriptor.getType(),
												  descriptor.getShaderStages());
	}

	@UpdateDependency(features = VulkanResourcePackage.IMAGE_DESCRIPTOR__IMAGE)
	private void updateAllocation(IVkImageAllocation imageAllocation)
	{
		vkDescriptor.updateViewPtr(imageAllocation.getViewPtr());
	}

	@Free
	public void free()
	{
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
