package org.sheepy.lily.vulkan.process.graphic.renderpass;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentReference;
import org.lwjgl.vulkan.VkSubpassDescription;
import org.lwjgl.vulkan.VkSubpassDescription.Buffer;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.EAttachmentType;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class VkSubpassDescriptionAllocator
{
	private final List<Attachment> attachments;

	public VkSubpassDescriptionAllocator(List<Attachment> attachments)
	{
		this.attachments = List.copyOf(attachments);
	}

	public VkSubpassDescription.Buffer allocate(MemoryStack stack, List<Subpass> subpasses)
	{
		final int size = Math.max(1, subpasses.size());
		final var vkSubpasses = VkSubpassDescription.callocStack(size, stack);

		if (subpasses.isEmpty() == false)
		{
			fill(stack, subpasses, vkSubpasses);
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

	private void fill(MemoryStack stack, List<Subpass> subpasses, final Buffer vkSubpasses)
	{
		for (final var subpass : subpasses)
		{
			final var vkSubpass = vkSubpasses.get();
			final var attachmantRefPkg = subpass.getAttachmentRefPkg();
			final var refs = attachmantRefPkg != null ? attachmantRefPkg.getAttachmentRefs() : List.<AttachmentRef>of();

			vkSubpass.pipelineBindPoint(subpass.getBindPoint());

			// Color
			final var colorRefs = refs.stream()
									  .filter(a -> a.getType() == EAttachmentType.COLOR)
									  .collect(Collectors.toList());
			fillAttachment(stack, colorRefs, attachmentBuffer -> {
				vkSubpass.colorAttachmentCount(attachmentBuffer.limit());
				vkSubpass.pColorAttachments(attachmentBuffer);
			});

			// Depth
			final var depthRef = refs.stream().filter(a -> a.getType() == EAttachmentType.DEPTH).findFirst();
			depthRef.ifPresent(attachmentRef -> fillAttachment(stack,
															   attachmentRef,
															   vkSubpass::pDepthStencilAttachment));

			// Input
			final var inputRefs = refs.stream()
									  .filter(a -> a.getType() == EAttachmentType.INPUT)
									  .collect(Collectors.toList());
			fillAttachment(stack, inputRefs, vkSubpass::pInputAttachments);
		}
		vkSubpasses.flip();
	}

	private void fillAttachment(final MemoryStack stack,
								final List<AttachmentRef> refs,
								final Consumer<VkAttachmentReference.Buffer> installer)
	{
		final int attachmentCount = refs.size();
		final var attachmentRefBuffer = VkAttachmentReference.callocStack(attachmentCount, stack);
		for (final AttachmentRef ref : refs)
		{
			fillAttachmentRef(ref, attachmentRefBuffer.get());
		}
		attachmentRefBuffer.flip();
		installer.accept(attachmentRefBuffer);
	}

	private void fillAttachment(final MemoryStack stack,
								final AttachmentRef ref,
								final Consumer<VkAttachmentReference> installer)
	{
		final var vkAttachmentRef = VkAttachmentReference.callocStack(stack);
		fillAttachmentRef(ref, vkAttachmentRef);
		installer.accept(vkAttachmentRef);
	}

	private void fillAttachmentRef(final AttachmentRef attachmentRef, VkAttachmentReference vkAttachmentRef)
	{
		final var attachement = attachmentRef.getAttachment();
		final int index = attachments.indexOf(attachement);
		vkAttachmentRef.attachment(index);
		vkAttachmentRef.layout(attachmentRef.getLayout().getValue());
	}
}
