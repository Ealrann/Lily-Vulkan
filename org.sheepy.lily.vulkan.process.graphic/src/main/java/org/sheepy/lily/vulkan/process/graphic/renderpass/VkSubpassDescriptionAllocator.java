package org.sheepy.lily.vulkan.process.graphic.renderpass;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentReference;
import org.lwjgl.vulkan.VkSubpassDescription;
import org.lwjgl.vulkan.VkSubpassDescription.Buffer;
import org.sheepy.lily.vulkan.core.resource.attachment.IExtraAttachmentAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

public class VkSubpassDescriptionAllocator
{
	private final List<Attachment> attachments;

	public VkSubpassDescriptionAllocator(List<Attachment> attachments)
	{
		this.attachments = List.copyOf(attachments);
	}

	public VkSubpassDescription.Buffer allocate(MemoryStack stack, List<Subpass> subpasses)
	{
		final int colorAttachmentCount = countColorAttachments();
		final int size = Math.max(1, subpasses.size());
		final var vkSubpasses = VkSubpassDescription.callocStack(size, stack);

		if (subpasses.isEmpty() == false)
		{
			fill(stack, subpasses, colorAttachmentCount, vkSubpasses);
		}
		else
		{
			final var colorAttachmentRef = VkAttachmentReference.callocStack(1, stack);
			colorAttachmentRef.attachment(0);
			colorAttachmentRef.layout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL_VALUE);
			colorAttachmentRef.get();
			colorAttachmentRef.flip();

			vkSubpasses.pipelineBindPoint(0);
			vkSubpasses.colorAttachmentCount(1);
			vkSubpasses.pColorAttachments(colorAttachmentRef);
			vkSubpasses.get();
			vkSubpasses.flip();
		}

		return vkSubpasses;
	}

	private void fill(	MemoryStack stack,
						List<Subpass> subpasses,
						final int colorAttachmentCount,
						final Buffer vkSubpasses)
	{
		for (final var subpass : subpasses)
		{
			vkSubpasses.pipelineBindPoint(subpass.getBindPoint());
			vkSubpasses.colorAttachmentCount(colorAttachmentCount);

			final var attachmantRefPkg = subpass.getAttachmantRefPkg();
			final var refs = attachmantRefPkg != null
					? attachmantRefPkg.getAttachmentRefs()
					: List.<AttachmentRef> of();
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
					vkSubpasses.pDepthStencilAttachment(vkAttachmentRef);
				}
				else
				{
					vkAttachmentRef = colorAttachmentRef.get();
				}

				fillAttachmentRef(ref, vkAttachmentRef);
			}
			colorAttachmentRef.flip();

			vkSubpasses.pColorAttachments(colorAttachmentRef);

			vkSubpasses.get();
		}
		vkSubpasses.flip();
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
