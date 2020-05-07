package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureResourceAdapter;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure;
import org.sheepy.lily.vulkan.model.resource.FileImage;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageFactory;

import java.util.List;
import java.util.stream.Collectors;

@ModelExtender(scope = SpriteStructure.class)
@Adapter
public final class SpriteStructureAdapter implements IStructureResourceAdapter
{
	private final List<Image> images;

	public SpriteStructureAdapter(SpriteStructure spriteStructure)
	{
		images = List.copyOf(gatherResources(spriteStructure));
	}

	@Override
	public List<Image> getResources()
	{
		return images;
	}

	private static List<Image> gatherResources(SpriteStructure structure)
	{
		return structure.getSprites()
						.stream()
						.map(s -> EcoreUtil.copy(s.getFile()))
						.map(SpriteStructureAdapter::buildImage)
						.collect(Collectors.toList());
	}

	private static FileImage buildImage(final FileResource resource)
	{
		final var initialLayout = ImageFactory.eINSTANCE.createImageLayout();
		initialLayout.setStage(EPipelineStage.FRAGMENT_SHADER_BIT);
		initialLayout.setLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		initialLayout.getAccessMask().add(EAccess.SHADER_READ_BIT);

		final var image = VulkanResourceFactory.eINSTANCE.createFileImage();
		image.setInitialLayout(initialLayout);
		image.setFile(resource);
		image.getUsages().add(EImageUsage.SAMPLED);
		image.getUsages().add(EImageUsage.TRANSFER_DST);
		return image;
	}
}
