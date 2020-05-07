package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.up.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.up.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImageArrayDescriptor;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.util.List;

@ModelExtender(scope = ImageArrayDescriptor.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.IMAGE_ARRAY_DESCRIPTOR__IMAGES, type = IVkImageAllocation.class)
public class ImageArrayDescriptorAllocation implements IDescriptorAllocation
{
	private final VkImageArrayDescriptor vkDescriptor;

	public ImageArrayDescriptorAllocation(ImageArrayDescriptor descriptor,
										  @InjectDependency(type = IVkImageAllocation.class) List<IVkImageAllocation> imageAllocations)
	{
		final var images = descriptor.getImages();
		final var initialLayout = descriptor.getInitialLayout();
		vkDescriptor = new VkImageArrayDescriptor(images.size(),
												  initialLayout,
												  descriptor.getType(),
												  descriptor.getShaderStages());

		final long[] viewPtrs = new long[images.size()];
		for (int i = 0; i < imageAllocations.size(); i++)
		{
			final var imageAllocation = imageAllocations.get(i);
			viewPtrs[i] = imageAllocation.getViewPtr();
		}

		vkDescriptor.updateViewPtrs(viewPtrs);
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
