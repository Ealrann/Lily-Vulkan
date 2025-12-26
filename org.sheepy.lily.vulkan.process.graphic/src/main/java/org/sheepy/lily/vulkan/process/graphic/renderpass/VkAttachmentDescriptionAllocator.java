package org.sheepy.lily.vulkan.process.graphic.renderpass;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentDescription;
import org.sheepy.lily.vulkan.core.resource.attachment.IExtraAttachmentAllocation;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;

import java.util.List;

public final class VkAttachmentDescriptionAllocator
{
	private final int swapchainImageFormat;

	public VkAttachmentDescriptionAllocator(int swapchainImageFormat)
	{
		this.swapchainImageFormat = swapchainImageFormat;
	}

	public VkAttachmentDescription.Buffer allocate(final MemoryStack stack, final List<Attachment> attachments)
	{
		final var attachmentsBuffer = VkAttachmentDescription.calloc(attachments.size(), stack);
		for (final var attachmentDescription : attachments)
		{
			fillAttachment(attachmentsBuffer.get(), attachmentDescription);
		}
		attachmentsBuffer.flip();
		return attachmentsBuffer;
	}

	private void fillAttachment(final VkAttachmentDescription vkAttachment, final Attachment attachment)
	{
		final var format = getAttachmentFormat(attachment);
		vkAttachment.format(format);
		vkAttachment.samples(attachment.samples().value());
		vkAttachment.loadOp(attachment.loadOp().value());
		vkAttachment.storeOp(attachment.storeOp().value());
		vkAttachment.stencilLoadOp(attachment.stencilLoadOp().value());
		vkAttachment.stencilStoreOp(attachment.stencilStoreOp().value());
		vkAttachment.initialLayout(attachment.initialLayout().value());
		vkAttachment.finalLayout(attachment.finalLayout().value());
	}

	private int getAttachmentFormat(final Attachment attachment)
	{
		if (attachment instanceof ExtraAttachment)
		{
			final var adapter = attachment.adapt(IExtraAttachmentAllocation.class);
			return adapter.getImageFormat();
		}
		else
		{
			return swapchainImageFormat;
		}
	}
}
