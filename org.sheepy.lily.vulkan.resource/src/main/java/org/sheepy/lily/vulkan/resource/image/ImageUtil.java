package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.vulkan.model.enumeration.EImageLayout;

public class ImageUtil
{
	public static boolean hasStencilComponent(int imageFormat)
	{
		return imageFormat == VK_FORMAT_D32_SFLOAT_S8_UINT
				|| imageFormat == VK_FORMAT_D24_UNORM_S8_UINT;
	}


	public static int getAspectMask(EImageLayout layout, int imageFormat)
	{
		int aspectMask = 0;
		if (layout == EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL)
		{
			aspectMask = VK_IMAGE_ASPECT_DEPTH_BIT;

			if (ImageUtil.hasStencilComponent(imageFormat))
			{
				aspectMask |= VK_IMAGE_ASPECT_STENCIL_BIT;
			}
		}
		else
		{
			aspectMask = VK_IMAGE_ASPECT_COLOR_BIT;
		}
		return aspectMask;
	}
}
