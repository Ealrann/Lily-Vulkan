package org.sheepy.lily.vulkan.resource.image.descriptor;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.image.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.resource.image.SamplerAllocation;

import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_NULL_HANDLE;

@ModelExtender(scope = ImageDescriptor.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.IMAGE_DESCRIPTOR__IMAGES, type = IVkImageAllocation.class)
@AllocationDependency(features = VulkanResourcePackage.IMAGE_DESCRIPTOR__SAMPLER, type = SamplerAllocation.class)
public final class ImageDescriptorAllocation implements IDescriptorAllocation
{
	private final VkImageDescriptor vkDescriptor;

	private ImageDescriptorAllocation(ImageDescriptor descriptor,
									  @InjectDependency(index = 0) List<IVkImageAllocation> imageAllocations,
									  @InjectDependency(index = 1) SamplerAllocation samplerAllocation)
	{
		final var viewPtrs = imageAllocations.stream().mapToLong(IVkImageAllocation::getViewPtr).toArray();
		final long samplerPtr = samplerAllocation != null ? samplerAllocation.getSamplerPtr() : VK_NULL_HANDLE;

		this.vkDescriptor = new VkImageDescriptor(viewPtrs,
												  samplerPtr,
												  descriptor.getLayout(),
												  descriptor.getType());
	}

	@Override
	public void attach(final IRecordContext recordContext)
	{
		// TODO
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
