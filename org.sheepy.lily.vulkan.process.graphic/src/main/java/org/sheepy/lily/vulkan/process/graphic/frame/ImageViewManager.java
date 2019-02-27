package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.IAllocable;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.lily.vulkan.resource.nativehelper.VkImageView;

public class ImageViewManager implements IAllocable
{
	private static final int IMAGE_ASPECT = VK_IMAGE_ASPECT_COLOR_BIT;

	private final GraphicContext context;

	private List<VkImageView> imageViews = null;

	public ImageViewManager(GraphicContext context)
	{
		this.context = context;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		var device = context.getVkDevice();
		var swapChainManager = context.swapChainManager;
		var pdsManager = context.surfaceManager;
		var colorFormat = pdsManager.getColorDomain().getFormat().getValue();
		var swapImages = swapChainManager.getSwapChainImages();

		imageViews = new ArrayList<>(swapImages.size());
		for (long imageId : swapImages)
		{
			var imageView = VkImageView.alloc(device, imageId, colorFormat, IMAGE_ASPECT);
			imageViews.add(imageView);
		}

		imageViews = List.copyOf(imageViews);
	}

	public List<VkImageView> getImageViews()
	{
		return imageViews;
	}

	public VkImageView getImageView(int index)
	{
		return imageViews.get(index);
	}

	@Override
	public void free()
	{
		for (final VkImageView view : imageViews)
		{
			view.free();
		}
		imageViews = null;
	}

	@Override
	public boolean isAllocationDirty()
	{
		return context.swapChainManager.isAllocationDirty();
	}
}
