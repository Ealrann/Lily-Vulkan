package org.sheepy.lily.vulkan.api.nativehelper;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkRenderPassCreateInfo;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.model.enumeration.EFormat;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;

public class VkRenderPassAllocator
{
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

		var attachementAllocator = new VkAttachmentDescriptionAllocator(swapchainImageFormat);
		var attachments = attachementAllocator.allocate(stack, renderPassInfo);

		var subpassAllocator = new VkSubpassDescriptionAllocator(renderPassInfo);
		var subpasses = subpassAllocator.allocate(stack);

		var dependencyAllocator = new VkSubpassDependencyAllocator(renderPassInfo);
		var dependencyInfos = renderPassInfo.getDependencies();
		var dependencies = dependencyAllocator.allocate(stack, dependencyInfos);

		final VkRenderPassCreateInfo createInfo = VkRenderPassCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO);
		createInfo.pAttachments(attachments);
		createInfo.pSubpasses(subpasses);
		createInfo.pDependencies(dependencies);

		final long[] aRenderPass = new long[1];
		Logger.check("Failed to create render pass!",
				() -> vkCreateRenderPass(device, createInfo, null, aRenderPass));
		renderPass = aRenderPass[0];
		return renderPass;
	}
}
