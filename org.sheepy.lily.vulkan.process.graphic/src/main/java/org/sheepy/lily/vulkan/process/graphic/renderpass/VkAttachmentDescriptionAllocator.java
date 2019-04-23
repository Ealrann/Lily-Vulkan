package org.sheepy.lily.vulkan.process.graphic.renderpass;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentDescription;
import org.sheepy.lily.vulkan.api.resource.attachment.ISwapAttachmentAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;

public class VkAttachmentDescriptionAllocator
{
	private final int swapchainImageFormat;

	public VkAttachmentDescriptionAllocator(int swapchainImageFormat)
	{
		this.swapchainImageFormat = swapchainImageFormat;
	}

	public VkAttachmentDescription.Buffer allocate(	final MemoryStack stack,
													final RenderPassInfo renderPassInfo)
	{
		final var attachmentDescriptions = renderPassInfo.getAttachments();
		final var attachments = VkAttachmentDescription.callocStack(attachmentDescriptions.size(),
				stack);
		for (final AttachmentDescription attachmentDescription : attachmentDescriptions)
		{
			fillAttachment(attachments.get(), attachmentDescription);
		}
		attachments.flip();
		return attachments;
	}

	private void fillAttachment(final VkAttachmentDescription attachment,
								final AttachmentDescription attachmentDescription)
	{
		final var format = getAttachmentFormat(attachmentDescription);
		attachment.format(format);
		attachment.samples(attachmentDescription.getSamples().getValue());
		attachment.loadOp(attachmentDescription.getLoadOp().getValue());
		attachment.storeOp(attachmentDescription.getStoreOp().getValue());
		attachment.stencilLoadOp(attachmentDescription.getStencilLoadOp().getValue());
		attachment.stencilStoreOp(attachmentDescription.getStencilStoreOp().getValue());
		attachment.initialLayout(attachmentDescription.getInitialLayout().getValue());
		attachment.finalLayout(attachmentDescription.getFinalLayout().getValue());
	}

	private int getAttachmentFormat(final AttachmentDescription attachmentDescription)
	{
		if (attachmentDescription instanceof ExtraAttachmentDescription)
		{
			final var depthImage = ((ExtraAttachmentDescription) attachmentDescription)
					.getAttachment();
			final var adapter = ISwapAttachmentAdapter.adapt(depthImage);
			return adapter.getImageFormat();
		}
		else
		{
			return swapchainImageFormat;
		}
	}
}
