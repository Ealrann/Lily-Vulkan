package org.sheepy.lily.vulkan.process.graphic.resource;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.util.VulkanBufferUtils;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.List;

import static org.lwjgl.vulkan.KHRSwapchain.vkGetSwapchainImagesKHR;

@Statefull
@Adapter(scope = SwapImageAttachment.class)
public class SwapImageAttachmentAdapter implements IAdapter
{
	private List<Long> swapChainImages = null;

	public void allocate(final IGraphicContext context, long swapChainPtr)
	{
		final var stack = context.stack();
		final var vkDevice = context.getVkDevice();

		final IntBuffer pImageCount = stack.mallocInt(1);
		vkGetSwapchainImagesKHR(vkDevice, swapChainPtr, pImageCount, null);
		final int swapImageCount = pImageCount.get(0);
		final LongBuffer pSwapchainImages = stack.mallocLong(swapImageCount);
		vkGetSwapchainImagesKHR(vkDevice, swapChainPtr, pImageCount, pSwapchainImages);

		swapChainImages = List.copyOf(VulkanBufferUtils.toList(pSwapchainImages));
	}

	public void free()
	{
		swapChainImages = null;
	}

	public int getImageCount()
	{
		return swapChainImages != null ? swapChainImages.size() : 0;
	}

	public List<Long> getImagePtrs()
	{
		return swapChainImages;
	}
}
