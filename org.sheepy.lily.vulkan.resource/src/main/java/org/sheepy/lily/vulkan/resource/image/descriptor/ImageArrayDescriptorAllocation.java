package org.sheepy.lily.vulkan.resource.image.descriptor;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
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
										  @InjectDependency(index = 0) List<IVkImageAllocation> imageAllocations)
	{
		final var initialLayout = descriptor.getInitialLayout();
		final long[] viewPtrs = imageAllocations.stream().mapToLong(IVkImageAllocation::getViewPtr).toArray();
		vkDescriptor = new VkImageArrayDescriptor(viewPtrs, initialLayout, descriptor.getType());
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
