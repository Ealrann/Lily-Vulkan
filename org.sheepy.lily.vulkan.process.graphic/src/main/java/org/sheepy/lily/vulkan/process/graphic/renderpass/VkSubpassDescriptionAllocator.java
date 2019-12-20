package org.sheepy.lily.vulkan.process.graphic.renderpass;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentReference;
import org.lwjgl.vulkan.VkSubpassDescription;
import org.sheepy.lily.vulkan.api.resource.attachment.IExtraAttachmentAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;

public class VkSubpassDescriptionAllocator
{
	private final RenderPassInfo renderPass;
	private final List<Attachment> attachments;

	public VkSubpassDescriptionAllocator(RenderPassInfo renderPass, List<Attachment> attachments)
	{
		this.renderPass = renderPass;
		this.attachments = List.copyOf(attachments);
	}

	public VkSubpassDescription.Buffer allocate(MemoryStack stack)
	{
		final int colorAttachmentCount = countColorAttachments();
		final var subpassDescriptions = renderPass.getSubpasses();
		final var subpasses = VkSubpassDescription.callocStack(subpassDescriptions.size(), stack);

		for (final var subpassDescription : subpassDescriptions)
		{
			subpasses.pipelineBindPoint(renderPass.getBindPoint());
			subpasses.colorAttachmentCount(colorAttachmentCount);

			final var refs = subpassDescription.getRefs();
			final var colorAttachmentRef = VkAttachmentReference.callocStack(	colorAttachmentCount,
																				stack);
			for (final AttachmentRef ref : refs)
			{
				VkAttachmentReference vkAttachmentRef = null;
				// DepthAttachmentRef shouldn't be mixed with ColorAttachments

				boolean isDepth = false;
				if (ref.getAttachment() instanceof ExtraAttachment)
				{

					final var attachment = (ExtraAttachment) ref.getAttachment();
					final var adapter = attachment.adaptNotNull(IExtraAttachmentAdapter.class);
					isDepth = adapter.isDepthAttachment();
				}
				if (isDepth)
				{
					vkAttachmentRef = VkAttachmentReference.callocStack(stack);
					subpasses.pDepthStencilAttachment(vkAttachmentRef);
				}
				else
				{
					vkAttachmentRef = colorAttachmentRef.get();
				}

				fillAttachmentRef(ref, vkAttachmentRef);
			}
			colorAttachmentRef.flip();

			subpasses.pColorAttachments(colorAttachmentRef);

			subpasses.get();
		}
		subpasses.flip();

		return subpasses;
	}

	private int countColorAttachments()
	{
		int colorAttachmentCount = 0;
		for (final var description : attachments)
		{
			boolean isDepth = false;
			if (description instanceof ExtraAttachment)
			{
				final var attachment = (ExtraAttachment) description;
				final var adapter = attachment.adaptNotNull(IExtraAttachmentAdapter.class);
				isDepth = adapter.isDepthAttachment();
			}

			if (isDepth == false)
			{
				colorAttachmentCount++;
			}
		}
		return colorAttachmentCount;
	}

	private void fillAttachmentRef(	final AttachmentRef attachmentRef,
									VkAttachmentReference vkAttachmentRef)
	{
		final var attachement = attachmentRef.getAttachment();
		final int index = attachments.indexOf(attachement);
		vkAttachmentRef.attachment(index);
		vkAttachmentRef.layout(attachmentRef.getLayout().getValue());
	}
}
