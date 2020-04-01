package org.sheepy.lily.vulkan.process.graphic.resource;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Observe;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

@Statefull
@Adapter(scope = AttachmentDescriptor.class)
public final class AttachmentDescriptorAdapter implements IDescriptorAdapter
{
	private final AttachmentDescriptor descriptor;
	private final VkImageDescriptor vkDescriptor;

	private AttachmentDescriptorAdapter(AttachmentDescriptor descriptor)
	{
		this.descriptor = descriptor;
		this.vkDescriptor = new VkImageDescriptor(0,
												  0,
												  EImageLayout.SHADER_READ_ONLY_OPTIMAL,
												  descriptor.getType(),
												  descriptor.getShaderStages());
	}

	@Observe
	private void observe(IObservatoryBuilder observatory)
	{
		observatory.explore(GraphicPackage.Literals.ATTACHMENT_DESCRIPTOR__ATTACHMENT)
				   .adaptNotifier(IVkImageAdapter.class)
				   .listen(this::updateView, IVkImageAdapter.Features.View);
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var attachment = descriptor.getAttachment();
		final var attachmentAdapter = attachment.adaptNotNull(IVkImageAdapter.class);
		updateView(attachmentAdapter.getViewPtr());
	}

	@Override
	public void free(IExecutionContext context)
	{
	}

	public void updateView(long viewPtr)
	{
		vkDescriptor.updateViewPtr(viewPtr);
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
