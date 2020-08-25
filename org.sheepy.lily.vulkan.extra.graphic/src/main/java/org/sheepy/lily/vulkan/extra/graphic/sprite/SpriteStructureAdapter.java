package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureResourceAdapter;
import org.sheepy.lily.vulkan.extra.model.sprite.Sprite;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

import java.util.List;
import java.util.stream.Collectors;

@ModelExtender(scope = SpriteStructure.class)
@Adapter
public final class SpriteStructureAdapter implements IStructureResourceAdapter
{
	private final MemoryChunk imageMemoryChunk;
	private final List<ImageViewer> images;

	public SpriteStructureAdapter(SpriteStructure spriteStructure)
	{
		imageMemoryChunk = VulkanResourceFactory.eINSTANCE.createMemoryChunk();
		final var parts = imageMemoryChunk.getParts();
		imageMemoryChunk.setName("Sprite images memoryChunk");
		images = buildImages(spriteStructure);
		parts.addAll(images);
	}

	@Override
	public List<MemoryChunk> getResources()
	{
		return List.of(imageMemoryChunk);
	}

	public List<? extends IVulkanImage> getImages()
	{
		return images;
	}

	private static List<ImageViewer> buildImages(SpriteStructure structure)
	{
		return structure.getSprites()
						.stream()
						.map(Sprite::getFile)
						.map(SpriteStructureAdapter::buildImage)
						.collect(Collectors.toUnmodifiableList());
	}

	private static ImageViewer buildImage(final FileImage resource)
	{
		final var fileDataProvider = VulkanResourceFactory.eINSTANCE.createFileImageDataProvider();
		fileDataProvider.setFileImageReference(resource);

		final var image = VulkanResourceFactory.eINSTANCE.createImageViewer();
		image.setInitialLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		image.setDataProvider(fileDataProvider);
		image.getUsages().add(EImageUsage.SAMPLED);
		image.getUsages().add(EImageUsage.TRANSFER_DST);
		return image;
	}
}
