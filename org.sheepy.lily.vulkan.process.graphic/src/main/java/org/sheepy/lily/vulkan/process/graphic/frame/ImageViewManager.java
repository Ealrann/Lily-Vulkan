package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.common.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.common.graphic.IImageViewManager;
import org.sheepy.lily.vulkan.common.resource.image.VkImageView;

public class ImageViewManager implements IImageViewManager
{
	private static final int IMAGE_ASPECT = VK_IMAGE_ASPECT_COLOR_BIT;

	private List<VkImageView> imageViews = null;

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		final var swapChainManager = context.getSwapChainManager();

		config.addDependencies(List.of(swapChainManager));
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		final var device = context.getVkDevice();
		final var swapChainManager = context.getSwapChainManager();
		final var pdsManager = context.getSurfaceManager();
		final var colorFormat = pdsManager.getColorDomain().getFormat().getValue();
		final var swapImages = swapChainManager.getSwapChainImages();

		imageViews = new ArrayList<>(swapImages.size());
		for (final long imageId : swapImages)
		{
			final var imageView = new VkImageView(IMAGE_ASPECT);
			imageView.allocate(device, imageId, 1, colorFormat);
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
		final var device = context.getVkDevice();
		for (final var view : imageViews)
		{
			view.free(device);
		}
		imageViews = null;
	}
}
