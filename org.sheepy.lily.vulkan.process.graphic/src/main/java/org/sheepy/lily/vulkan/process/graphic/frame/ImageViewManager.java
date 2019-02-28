package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.lily.vulkan.resource.nativehelper.VkImageView;

public class ImageViewManager implements IAllocable
{
	private static final int IMAGE_ASPECT = VK_IMAGE_ASPECT_COLOR_BIT;

	private List<VkImageView> imageViews = null;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		var graphicContext = (GraphicContext) context;
		var device = graphicContext.getVkDevice();
		var swapChainManager = graphicContext.swapChainManager;
		var pdsManager = graphicContext.surfaceManager;
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
		var graphicContext = (GraphicContext) context;
		return graphicContext.swapChainManager.isAllocationDirty(context);
	}
}
