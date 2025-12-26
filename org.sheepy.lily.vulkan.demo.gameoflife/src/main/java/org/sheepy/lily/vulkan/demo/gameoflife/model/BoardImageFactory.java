package org.sheepy.lily.vulkan.demo.gameoflife.model;

import org.joml.Vector2ic;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

public final class BoardImageFactory
{
	private static final EFormat IMAGE_FORMAT = EFormat.R8G8B8A8_UNORM;

	public static StaticImage createBoardImage(Vector2ic size)
	{
		return StaticImage.builder()
						  .size(size)
						  .format(IMAGE_FORMAT)
						  .mipLevels(1)
						  .tiling(0)
						  .addUsage(EImageUsage.TRANSFER_SRC)
						  .addUsage(EImageUsage.TRANSFER_DST)
						  .addUsage(EImageUsage.STORAGE)
						  .initialLayout(EImageLayout.GENERAL)
						  .build();
	}
}
