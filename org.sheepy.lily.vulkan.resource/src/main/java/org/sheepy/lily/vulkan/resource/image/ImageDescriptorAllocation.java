package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.allocation.up.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@ModelExtender(scope = ImageDescriptor.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.IMAGE_DESCRIPTOR__IMAGE, type = IVkImageAllocation.class)
public final class ImageDescriptorAllocation implements IDescriptorAllocation
{
	private final VkImageDescriptor vkDescriptor;

	private ImageDescriptorAllocation(ImageDescriptor descriptor,
									  @InjectDependency(type = IVkImageAllocation.class) IVkImageAllocation imageAllocation)
	{
		this.vkDescriptor = new VkImageDescriptor(imageAllocation.getViewPtr(),
												  0,
												  EImageLayout.GENERAL,
												  descriptor.getType(),
												  descriptor.getShaderStages());
	}

	@UpdateDependency(type = IVkImageAllocation.class)
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
