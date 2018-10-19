package org.sheepy.vulkan.view;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IBasicAllocable;
import org.sheepy.vulkan.processpool.graphic.GraphicContext;

public class ImageViewManager implements IBasicAllocable
{
	private static final int IMAGE_ASPECT = VK_IMAGE_ASPECT_COLOR_BIT;

	private final GraphicContext context;

	private List<ImageView> imageViews = null;

	public ImageViewManager(GraphicContext context)
	{
		this.context = context;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		var device = context.getVkDevice();
		var swapChainManager = context.swapChainManager;
		var colorFormat = swapChainManager.getColorDomain().getFormat().getValue();
		var swapImages = swapChainManager.getSwapChainImages();

		imageViews = new ArrayList<>(swapImages.size());
		for (long imageId : swapImages)
		{
			var imageView = ImageView.alloc(device, imageId, colorFormat, IMAGE_ASPECT);
			imageViews.add(imageView);
		}

		imageViews = List.copyOf(imageViews);
	}

	public List<ImageView> getImageViews()
	{
		return imageViews;
	}

	public ImageView getImageView(int index)
	{
		return imageViews.get(index);
	}

	@Override
	public void free()
	{
		for (final ImageView view : imageViews)
		{
			view.free();
		}
		imageViews = null;
	}

	@Override
	public boolean isDirty()
	{
		return context.swapChainManager.isDirty();
	}
}
