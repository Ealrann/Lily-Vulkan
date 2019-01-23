package org.sheepy.vulkan.common.nativehelper;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentDescription;
import org.sheepy.vulkan.common.resource.image.IDepthImageAdapter;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.vulkan.model.process.graphic.DepthAttachmentDescription;
import org.sheepy.vulkan.model.process.graphic.RenderPassInfo;

public class VkAttachmentDescriptionAllocator
{
	private final EFormat swapchainImageFormat;

	public VkAttachmentDescriptionAllocator(EFormat swapchainImageFormat)
	{
		this.swapchainImageFormat = swapchainImageFormat;
	}

	public VkAttachmentDescription.Buffer allocate(MemoryStack stack,
															final RenderPassInfo renderPassInfo)
	{
		var attachmentDescriptions = renderPassInfo.getAttachments();
		var attachments = VkAttachmentDescription.callocStack(attachmentDescriptions.size(), stack);
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
		var format = getAttachmentFormat(attachmentDescription);
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
			var depthImage = ((DepthAttachmentDescription) attachmentDescription).getDepthImage();
			var adapter = IDepthImageAdapter.adapt(depthImage);
			return adapter.getDepthImageFormat();
		}
		else
		{
			return swapchainImageFormat.getValue();
		}
	}

}
