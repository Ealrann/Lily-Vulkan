package org.sheepy.lily.vulkan.api.nativehelper;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentDescription;
import org.sheepy.lily.vulkan.api.resource.image.IDepthImageAdapter;
import org.sheepy.lily.vulkan.model.enumeration.EFormat;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;

public class VkAttachmentDescriptionAllocator
{
	private final EFormat swapchainImageFormat;

	public VkAttachmentDescriptionAllocator(EFormat swapchainImageFormat)
	{
		this.swapchainImageFormat = swapchainImageFormat;
	}

	public VkAttachmentDescription.Buffer allocate(	final MemoryStack stack,
													final RenderPassInfo renderPassInfo)
	{
		final var attachmentDescriptions = renderPassInfo.getAttachments();
		final var attachments = VkAttachmentDescription.callocStack(attachmentDescriptions.size(), stack);
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
		if (attachmentDescription instanceof DepthAttachmentDescription)
		{
			final var depthImage = ((DepthAttachmentDescription) attachmentDescription).getDepthImage();
			final var adapter = IDepthImageAdapter.adapt(depthImage);
			return adapter.getDepthImageFormat();
		}
		else
		{
			return swapchainImageFormat.getValue();
		}
	}

}
