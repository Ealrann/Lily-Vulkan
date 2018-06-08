package org.sheepy.lily.game.vulkan.view;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;

public class ImageViewManager
{
	private LogicalDevice logicalDevice;

	private List<ImageView> imageViews = null;

	public ImageViewManager(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public void load(SwapChainManager swapChainManager)
	{
		int colorFormat = swapChainManager.getColorDomain().getColorFormat();
		imageViews = new ArrayList<>();
		for (long imageId : swapChainManager.getSwapChainImages())
		{
			imageViews.add(ImageView.alloc(logicalDevice, imageId, colorFormat,
					VK_IMAGE_ASPECT_COLOR_BIT));
		}

		imageViews = Collections.unmodifiableList(imageViews);
	}

	public List<ImageView> getImageViews()
	{
		return imageViews;
	}

	public void free()
	{
		for (ImageView view : imageViews)
		{
			view.free();
		}
		imageViews = null;
	}
}
