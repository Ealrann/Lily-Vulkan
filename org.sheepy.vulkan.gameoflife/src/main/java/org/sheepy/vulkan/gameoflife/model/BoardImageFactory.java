package org.sheepy.vulkan.gameoflife.model;

import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.common.api.types.SVector2i;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.resource.Image;
import org.sheepy.vulkan.model.resource.ImageLayout;
import org.sheepy.vulkan.model.resource.impl.ImageImpl;
import org.sheepy.vulkan.model.resource.impl.ImageLayoutImpl;

public class BoardImageFactory
{
	private static final EFormat IMAGE_FORMAT = EFormat.R8G8B8A8_UNORM;

	public static final Image createBoardImage(SVector2i size)
	{
		Image res = new ImageImpl();

		ImageLayout initialLayout = new ImageLayoutImpl();
		initialLayout.setStage(EPipelineStage.COMPUTE_SHADER_BIT);
		initialLayout.setLayout(EImageLayout.GENERAL);
		initialLayout.setAccess(VK_ACCESS_SHADER_WRITE_BIT);

		res.setWidth(size.x);
		res.setHeight(size.y);
		res.setFormat(IMAGE_FORMAT);
		res.setMipLevels(1);
		res.setTiling(VK_IMAGE_TILING_OPTIMAL);
		res.getUsages().add(EImageUsage.TRANSFER_SRC);
		res.getUsages().add(EImageUsage.STORAGE);
		res.setProperties(VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);

		res.setDescriptorType(EDescriptorType.STORAGE_IMAGE);
		res.getShaderStages().add(EShaderStage.COMPUTE_BIT);

		res.setInitialLayout(initialLayout);

		return res;
	}
}
