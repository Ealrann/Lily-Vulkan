package org.sheepy.lily.game.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkFormatProperties;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.view.ImageView;

public class DepthResource
{
	private LogicalDevice logicalDevice;

	private ImageBuffer depthImage;
	private ImageView depthImageView;

	private int depthFormat;

	public static final DepthResource alloc(LogicalDevice logicalDevice, CommandPool commandPool, int width, int height)
	{
		DepthResource res = new DepthResource(logicalDevice);
		res.load(commandPool, width, height);
		return res;
	}

	public DepthResource(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;

		depthImage = new ImageBuffer(logicalDevice);
		depthImageView = new ImageView(logicalDevice);
	}

	public void load(CommandPool commandPool, int width, int height)
	{
		depthFormat = findDepthFormat();
		depthImage.createImage(width, height, 1, depthFormat, VK_IMAGE_TILING_OPTIMAL,
				VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT, VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		depthImageView.load(depthImage.getId(), 1, depthFormat, VK_IMAGE_ASPECT_DEPTH_BIT);

		depthImage.transitionImageLayout(commandPool,
				logicalDevice.getQueueManager().getGraphicQueue(), depthFormat,
				VK_IMAGE_LAYOUT_UNDEFINED, VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL, 1);
	}

	private int findSupportedFormat(int[] candidates, int tiling, int features)
	{
		for (int format : candidates)
		{
			VkFormatProperties props = VkFormatProperties.calloc();
			vkGetPhysicalDeviceFormatProperties(
					logicalDevice.getPhysicalDevice().getVkPhysicalDevice(), format, props);

			if (tiling == VK_IMAGE_TILING_LINEAR
					&& (props.linearTilingFeatures() & features) == features)
			{
				return format;
			}
			else if (tiling == VK_IMAGE_TILING_OPTIMAL
					&& (props.optimalTilingFeatures() & features) == features)
			{
				return format;
			}
		}

		throw new AssertionError("failed to find supported format!");
	}

	private int findDepthFormat()
	{
		return findSupportedFormat(new int[] {
				VK_FORMAT_D32_SFLOAT, VK_FORMAT_D32_SFLOAT_S8_UINT, VK_FORMAT_D24_UNORM_S8_UINT
		}, VK_IMAGE_TILING_OPTIMAL, VK_FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT);
	}

	public int getDepthFormat()
	{
		return depthFormat;
	}

	public long getDepthImageId()
	{
		return depthImage.getId();
	}

	public long getDepthImageViewId()
	{
		return depthImageView.getId();
	}

	public void free()
	{
		depthImageView.free();
		depthImage.free();
	}
}
