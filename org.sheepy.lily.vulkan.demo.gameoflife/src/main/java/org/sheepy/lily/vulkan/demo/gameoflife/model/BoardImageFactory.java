package org.sheepy.lily.vulkan.demo.gameoflife.model;

import org.joml.Vector2ic;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageFactory;

public class BoardImageFactory
{
	private static final EFormat IMAGE_FORMAT = EFormat.R8G8B8A8_UNORM;

	public static final StaticImage createBoardImage(Vector2ic size)
	{
		final var res = ResourceFactory.eINSTANCE.createStaticImage();

		final var initialLayout = ImageFactory.eINSTANCE.createImageLayout();
		initialLayout.setStage(EPipelineStage.COMPUTE_SHADER_BIT);
		initialLayout.setLayout(EImageLayout.GENERAL);
		initialLayout.getAccessMask().add(EAccess.SHADER_WRITE_BIT);

		res.setSize(size);
		res.setFormat(IMAGE_FORMAT);
		res.setMipLevels(1);
		res.setTiling(0);
		res.getUsages().add(EImageUsage.TRANSFER_SRC);
		res.getUsages().add(EImageUsage.STORAGE);
		res.setInitialLayout(initialLayout);

		return res;
	}
}
