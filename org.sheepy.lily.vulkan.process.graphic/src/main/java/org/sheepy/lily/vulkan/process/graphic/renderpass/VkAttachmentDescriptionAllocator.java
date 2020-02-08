package org.sheepy.lily.vulkan.process.graphic.renderpass;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentDescription;
import org.sheepy.lily.vulkan.core.resource.attachment.IExtraAttachmentAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;

public final class VkAttachmentDescriptionAllocator
{
	private final int swapchainImageFormat;

	public VkAttachmentDescriptionAllocator(int swapchainImageFormat)
	{
		this.swapchainImageFormat = swapchainImageFormat;
	}

	public VkAttachmentDescription.Buffer allocate(	final MemoryStack stack,
													final List<Attachment> attachments)
	{
		final var attachmentsBuffer = VkAttachmentDescription.callocStack(	attachments.size(),
																			stack);
		for (final var attachmentDescription : attachments)
		{
			fillAttachment(attachmentsBuffer.get(), attachmentDescription);
		}
		attachmentsBuffer.flip();
		return attachmentsBuffer;
	}

	private void fillAttachment(final VkAttachmentDescription vKattachment,
								final Attachment attachment)
	{
		final var format = getAttachmentFormat(attachment);
		vKattachment.format(format);
		vKattachment.samples(attachment.getSamples().getValue());
		vKattachment.loadOp(attachment.getLoadOp().getValue());
		vKattachment.storeOp(attachment.getStoreOp().getValue());
		vKattachment.stencilLoadOp(attachment.getStencilLoadOp().getValue());
		vKattachment.stencilStoreOp(attachment.getStencilStoreOp().getValue());
		vKattachment.initialLayout(attachment.getInitialLayout().getValue());
		vKattachment.finalLayout(attachment.getFinalLayout().getValue());
	}

	private int getAttachmentFormat(final Attachment attachment)
	{
		if (attachment instanceof ExtraAttachment)
		{
			final var adapter = attachment.adaptNotNull(IExtraAttachmentAdapter.class);
			return adapter.getImageFormat();
		}
		else
		{
			return swapchainImageFormat;
		}
	}
}
