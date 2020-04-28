package org.sheepy.lily.vulkan.process.graphic.resource;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAllocation;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@ModelExtender(scope = AttachmentDescriptor.class)
@Adapter
public final class AttachmentDescriptorAllocation implements IDescriptorAllocation, IAllocableAdapter<IExecutionContext>
{
	private final AttachmentDescriptor descriptor;
	private final VkImageDescriptor vkDescriptor;

	private AttachmentDescriptorAllocation(AttachmentDescriptor descriptor, IObservatoryBuilder observatory)
	{
		this.descriptor = descriptor;
		this.vkDescriptor = new VkImageDescriptor(0,
												  0,
												  EImageLayout.SHADER_READ_ONLY_OPTIMAL,
												  descriptor.getType(),
												  descriptor.getShaderStages());

		observatory.explore(GraphicPackage.Literals.ATTACHMENT_DESCRIPTOR__ATTACHMENT)
				   .allocation(IVkImageAllocation.class)
				   .listenNoParam(this::updateView);
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		updateView();
	}

	@Override
	public void free(IExecutionContext context)
	{
	}

	public void updateView()
	{
		final var attachment = descriptor.getAttachment();
		final var attachmentAdapter = attachment.allocationHandle(IVkImageAllocation.class).get();
		vkDescriptor.updateViewPtr(attachmentAdapter.getViewPtr());
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
