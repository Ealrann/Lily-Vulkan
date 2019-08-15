package org.sheepy.lily.vulkan.process.graphic.renderpass;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkRenderPassCreateInfo;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.model.enumeration.EFormat;

public class VkRenderPassAllocator
{
	private static final String CREATION_ERROR = "Failed to create render pass";

	private final EFormat swapchainImageFormat;
	private final VkDevice device;

	public VkRenderPassAllocator(VkDevice device, EFormat swapchainImageFormat)
	{
		this.device = device;
		this.swapchainImageFormat = swapchainImageFormat;
	}

	public long allocate(MemoryStack stack, RenderPassInfo renderPassInfo)
	{
		long renderPass;

		final var format = swapchainImageFormat.getValue();
		final var attachementAllocator = new VkAttachmentDescriptionAllocator(format);
		final var attachments = attachementAllocator.allocate(stack, renderPassInfo);

		final var subpassAllocator = new VkSubpassDescriptionAllocator(renderPassInfo);
		final var subpasses = subpassAllocator.allocate(stack);

		final var dependencyAllocator = new VkSubpassDependencyAllocator(renderPassInfo);
		final var dependencyInfos = renderPassInfo.getDependencies();
		final var dependencies = dependencyAllocator.allocate(stack, dependencyInfos);

		final var createInfo = VkRenderPassCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO);
		createInfo.pAttachments(attachments);
		createInfo.pSubpasses(subpasses);
		createInfo.pDependencies(dependencies);

		final long[] aRenderPass = new long[1];
		Logger.check(CREATION_ERROR,
				() -> vkCreateRenderPass(device, createInfo, null, aRenderPass));
		renderPass = aRenderPass[0];
		return renderPass;
	}
}
