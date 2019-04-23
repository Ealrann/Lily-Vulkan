package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.IImageViewManager;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.resource.image.VkImageView;

public class ImageViewManager implements IImageViewManager
{
	private static final int IMAGE_ASPECT = VK_IMAGE_ASPECT_COLOR_BIT;

	private List<VkImageView> imageViews = null;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		final var device = graphicContext.getVkDevice();
		final var swapChainManager = graphicContext.getSwapChainManager();
		final var pdsManager = graphicContext.getSurfaceManager();
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
	public void free(IAllocationContext context)
	{
		for (final VkImageView view : imageViews)
		{
			view.free();
		}
		imageViews = null;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		return graphicContext.getSwapChainManager().isAllocationDirty(context);
	}
}
