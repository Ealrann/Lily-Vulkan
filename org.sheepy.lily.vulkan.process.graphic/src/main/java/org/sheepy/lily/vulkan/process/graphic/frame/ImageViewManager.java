package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.IImageViewManager;
import org.sheepy.vulkan.resource.image.VkImageView;

public class ImageViewManager implements IImageViewManager
{
	private static final int IMAGE_ASPECT = VK_IMAGE_ASPECT_COLOR_BIT;

	private List<VkImageView> imageViews = null;

	@Override
	public void allocate(MemoryStack stack, IGraphicContext context)
	{
		final var device = context.getVkDevice();
		final var swapChainManager = context.getSwapChainManager();
		final var pdsManager = context.getSurfaceManager();
		final var colorFormat = pdsManager.getColorDomain().getFormat().getValue();
		final var swapImages = swapChainManager.getSwapChainImages();

		imageViews = new ArrayList<>(swapImages.size());
		for (final long imageId : swapImages)
		{
			final var imageView = VkImageView.alloc(device, imageId, colorFormat, IMAGE_ASPECT);
			imageViews.add(imageView);
		}

		imageViews = List.copyOf(imageViews);
	}

	@Override
	public List<VkImageView> getImageViews()
	{
		return imageViews;
	}

	public VkImageView getImageView(int index)
	{
		return imageViews.get(index);
	}

	@Override
	public void free(IGraphicContext context)
	{
		for (final VkImageView view : imageViews)
		{
			view.free();
		}
		imageViews = null;
	}

	@Override
	public boolean isAllocationDirty(IGraphicContext context)
	{
		return context.getSwapChainManager().isAllocationDirty(context);
	}
}
