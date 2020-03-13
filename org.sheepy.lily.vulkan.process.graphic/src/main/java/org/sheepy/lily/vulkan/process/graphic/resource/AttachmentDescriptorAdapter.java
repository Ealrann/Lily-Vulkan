package org.sheepy.lily.vulkan.process.graphic.resource;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.core.resource.attachment.IExtraAttachmentAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImageDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescriptor;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

import java.util.function.LongConsumer;

@Statefull
@Adapter(scope = AttachmentDescriptor.class)
public final class AttachmentDescriptorAdapter implements IDescriptorAdapter
{
	private final AttachmentDescriptor descriptor;
	private final VkImageDescriptor vkDescriptor;
	private final LongConsumer viewListener = this::updateView;

	private AttachmentDescriptorAdapter(AttachmentDescriptor descriptor)
	{
		this.descriptor = descriptor;
		this.vkDescriptor = new VkImageDescriptor(0,
												  0,
												  EImageLayout.SHADER_READ_ONLY_OPTIMAL,
												  descriptor.getType(),
												  descriptor.getShaderStages());
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var attachment = descriptor.getAttachment();
		final var attachmentAdapter = attachment.adaptNotNull(IExtraAttachmentAdapter.class);
		updateView(attachmentAdapter.getViewPtr());
		attachmentAdapter.listen(viewListener, IExtraAttachmentAdapter.Features.View);
	}

	@Override
	public void free(IExecutionContext context)
	{
		final var attachment = descriptor.getAttachment();
		final var attachmentAdapter = attachment.adaptNotNull(IExtraAttachmentAdapter.class);
		attachmentAdapter.sulk(viewListener, IExtraAttachmentAdapter.Features.View);
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
