package org.sheepy.lily.vulkan.demo.gameoflife.model;

import org.joml.Vector2ic;
import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

public final class BoardImageFactory
{
	private static final EFormat IMAGE_FORMAT = EFormat.R8G8B8A8_UNORM;

	public static StaticImage createBoardImage(Vector2ic size)
	{
		final var res = VulkanResourceFactory.eINSTANCE.createStaticImage();

		res.setSize(size);
		res.setFormat(IMAGE_FORMAT);
		res.setMipLevels(1);
		res.setTiling(0);
		res.getUsages().add(EImageUsage.TRANSFER_SRC);
		res.getUsages().add(EImageUsage.TRANSFER_DST);
		res.getUsages().add(EImageUsage.STORAGE);
		res.setInitialLayout(EImageLayout.GENERAL);

		return res;
	}
}
