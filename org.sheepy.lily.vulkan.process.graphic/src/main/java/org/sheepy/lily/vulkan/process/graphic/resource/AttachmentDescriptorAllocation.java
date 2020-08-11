package org.sheepy.lily.vulkan.process.graphic.resource;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@ModelExtender(scope = AttachmentDescriptor.class)
@Allocation
@AllocationDependency(features = GraphicPackage.ATTACHMENT_DESCRIPTOR__ATTACHMENT, type = IVkImageAllocation.class)
public final class AttachmentDescriptorAllocation implements IDescriptorAllocation
{
	private final VkImageDescriptor vkDescriptor;

	private AttachmentDescriptorAllocation(AttachmentDescriptor descriptor,
										   @InjectDependency(index = 0) IVkImageAllocation imageAllocation)
	{
		this.vkDescriptor = new VkImageDescriptor(imageAllocation.getViewPtr(),
												  0,
												  EImageLayout.SHADER_READ_ONLY_OPTIMAL,
												  descriptor.getType());
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
