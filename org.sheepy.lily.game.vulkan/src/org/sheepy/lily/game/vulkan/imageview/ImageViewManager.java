package org.sheepy.lily.game.vulkan.imageview;

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
			imageViews.add(new ImageView(logicalDevice, imageId, colorFormat));
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
