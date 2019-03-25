package org.sheepy.lily.vulkan.api.nativehelper;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkAttachmentReference;
import org.lwjgl.vulkan.VkSubpassDescription;
import org.sheepy.lily.vulkan.model.process.graphic.AttachementRef;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachmentDescription;
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
		int colorAttachmentCount = countColorAttachments(renderPass);
		var subpassDescriptions = renderPass.getSubpasses();
		var subpasses = VkSubpassDescription.callocStack(subpassDescriptions.size(), stack);

		for (var subpassDescription : subpassDescriptions)
		{
			subpasses.pipelineBindPoint(renderPass.getBindPoint());
			subpasses.colorAttachmentCount(colorAttachmentCount);

			var refs = subpassDescription.getRefs();
			var colorAttachmentRef = VkAttachmentReference.callocStack(colorAttachmentCount, stack);
			for (AttachementRef ref : refs)
			{
				VkAttachmentReference vkAttachmentRef = null;
				// DepthAttachmentRef shouldn't be mixed with ColorAttachments
				if (ref.getAttachement() instanceof DepthAttachmentDescription)
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
			if (attachmentDescription instanceof DepthAttachmentDescription == false)
			{
				colorAttachmentCount++;
			}
		}
		return colorAttachmentCount;
	}

	private void fillAttachmentRef(	final AttachementRef attachmentRef,
									VkAttachmentReference vkAttachmentRef)
	{
		AttachmentDescription attachement = attachmentRef.getAttachement();
		int index = renderPass.getAttachments().indexOf(attachement);
		vkAttachmentRef.attachment(index);
		vkAttachmentRef.layout(attachmentRef.getLayout().getValue());
	}
}
