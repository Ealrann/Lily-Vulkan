package org.sheepy.vulkan.view;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.swapchain.SwapChainManager;

public class ImageViewManager implements IAllocable
{
	private LogicalDevice logicalDevice;
	private SwapChainManager swapChainManager;

	private List<ImageView> imageViews = null;

	public ImageViewManager(LogicalDevice logicalDevice, SwapChainManager swapChainManager)
	{
		this.logicalDevice = logicalDevice;
		this.swapChainManager = swapChainManager;
	}

	@Override
	public void allocate(MemoryStack stack)
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

	@Override
	public void free()
	{
		for (ImageView view : imageViews)
		{
			view.free();
		}
		imageViews = null;
	}
}
