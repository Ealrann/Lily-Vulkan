package org.sheepy.lily.vulkan.process.graphic.renderpass;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentReference;
import org.lwjgl.vulkan.VkSubpassDescription;
import org.sheepy.lily.vulkan.api.resource.attachment.ISwapAttachmentAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.AttachementRef;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;

public class VkSubpassDescriptionAllocator
{
	private final RenderPassInfo renderPass;

	public VkSubpassDescriptionAllocator(RenderPassInfo renderPass)
	{
		this.renderPass = renderPass;
	}

	public VkSubpassDescription.Buffer allocate(MemoryStack stack)
	{
		final int colorAttachmentCount = countColorAttachments(renderPass);
		final var subpassDescriptions = renderPass.getSubpasses();
		final var subpasses = VkSubpassDescription.callocStack(subpassDescriptions.size(), stack);

		for (final var subpassDescription : subpassDescriptions)
		{
			subpasses.pipelineBindPoint(renderPass.getBindPoint());
			subpasses.colorAttachmentCount(colorAttachmentCount);

			final var refs = subpassDescription.getRefs();
			final var colorAttachmentRef = VkAttachmentReference.callocStack(colorAttachmentCount,
					stack);
			for (final AttachementRef ref : refs)
			{
				VkAttachmentReference vkAttachmentRef = null;
				// DepthAttachmentRef shouldn't be mixed with ColorAttachments

				boolean isDepth = false;
				if (ref.getAttachement() instanceof ExtraAttachmentDescription)
				{

					final var attachment = ((ExtraAttachmentDescription) ref.getAttachement())
							.getAttachment();
					final var adapter = ISwapAttachmentAdapter.adapt(attachment);
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

	private static int countColorAttachments(final RenderPassInfo renderPassInfo)
	{
		int colorAttachmentCount = 0;
		for (final AttachmentDescription attachmentDescription : renderPassInfo.getAttachments())
		{
			boolean isDepth = false;
			if (attachmentDescription instanceof ExtraAttachmentDescription)
			{
				final var attachment = ((ExtraAttachmentDescription) attachmentDescription)
						.getAttachment();
				final var adapter = ISwapAttachmentAdapter.adapt(attachment);
				isDepth = adapter.isDepthAttachment();
			}

			if (isDepth == false)
			{
				colorAttachmentCount++;
			}
		}
		return colorAttachmentCount;
	}

	private void fillAttachmentRef(	final AttachementRef attachmentRef,
									VkAttachmentReference vkAttachmentRef)
	{
		final AttachmentDescription attachement = attachmentRef.getAttachement();
		final int index = renderPass.getAttachments().indexOf(attachement);
		vkAttachmentRef.attachment(index);
		vkAttachmentRef.layout(attachmentRef.getLayout().getValue());
	}
}
