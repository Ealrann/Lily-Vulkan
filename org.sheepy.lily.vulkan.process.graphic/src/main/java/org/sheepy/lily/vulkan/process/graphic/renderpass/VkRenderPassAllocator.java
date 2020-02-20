package org.sheepy.lily.vulkan.process.graphic.renderpass;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkRenderPassCreateInfo;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.process.graphic.pipeline.util.SubpassUtil;
import org.sheepy.vulkan.model.enumeration.EFormat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO;
import static org.lwjgl.vulkan.VK10.vkCreateRenderPass;

public final class VkRenderPassAllocator
{
	private static final String CREATION_ERROR = "Failed to create render pass";

	private final EFormat swapchainImageFormat;
	private final VkDevice device;

	public VkRenderPassAllocator(VkDevice device, EFormat swapchainImageFormat)
	{
		this.device = device;
		this.swapchainImageFormat = swapchainImageFormat;
	}

	public long allocate(MemoryStack stack, GraphicProcess process)
	{
		final var format = swapchainImageFormat.getValue();
		final var attachementAllocator = new VkAttachmentDescriptionAllocator(format);
		final var descriptions = getAttachments(process.getAttachmentPkg());
		final var attachments = attachementAllocator.allocate(stack, descriptions);

		final List<Subpass> renderSubpasses = new ArrayList<>();
		for (final var subpass : process.getSubpasses())
		{
			if (SubpassUtil.isGraphic(subpass))
			{
				renderSubpasses.add(subpass);
			}
		}
		renderSubpasses.sort(Comparator.comparingInt(Subpass::getSubpassIndex));

		final var subpassAllocator = new VkSubpassDescriptionAllocator(descriptions);
		final var subpasses = subpassAllocator.allocate(stack, renderSubpasses);
		final var dependencyAllocator = new VkSubpassDependencyAllocator();
		final var dependencies = dependencyAllocator.allocate(stack, renderSubpasses);

		final var createInfo = VkRenderPassCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO);
		createInfo.pAttachments(attachments);
		createInfo.pSubpasses(subpasses);
		createInfo.pDependencies(dependencies);

		final long[] aRenderPass = new long[1];
		Logger.check(CREATION_ERROR, () -> vkCreateRenderPass(device, createInfo, null, aRenderPass));
		return aRenderPass[0];
	}

	private static List<Attachment> getAttachments(AttachmentPkg attachmentPkg)
	{
		final List<Attachment> res = new ArrayList<>();
		res.add(attachmentPkg.getColorAttachment());
		res.addAll(attachmentPkg.getExtraAttachments());
		return res;
	}
}
