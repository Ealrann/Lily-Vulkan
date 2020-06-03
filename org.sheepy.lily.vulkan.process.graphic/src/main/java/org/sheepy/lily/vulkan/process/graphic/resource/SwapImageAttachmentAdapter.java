package org.sheepy.lily.vulkan.process.graphic.resource;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;

import static org.lwjgl.vulkan.KHRSwapchain.vkGetSwapchainImagesKHR;

@ModelExtender(scope = SwapImageAttachment.class)
@Adapter
public final class SwapImageAttachmentAdapter implements IExtender
{
	private long[] swapChainImages = null;

	public void allocate(final IVulkanContext context, long swapChainPtr)
	{
		final var vkDevice = context.getVkDevice();
		final int[] pImageCount = new int[1];
		vkGetSwapchainImagesKHR(vkDevice, swapChainPtr, pImageCount, null);
		final int swapImageCount = pImageCount[0];
		swapChainImages = new long[swapImageCount];
		vkGetSwapchainImagesKHR(vkDevice, swapChainPtr, pImageCount, swapChainImages);
	}

	public void free()
	{
		swapChainImages = null;
	}

	public int getImageCount()
	{
		return swapChainImages != null ? swapChainImages.length : 0;
	}

	public long getImagePtr(int index)
	{
		return swapChainImages[index];
	}
}
