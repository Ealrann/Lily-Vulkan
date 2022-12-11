package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.vulkan.extra.api.sprite.ISpriteSupplier;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;
import org.sheepy.lily.vulkan.model.vulkanresource.*;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

import java.util.List;

@ModelExtender(scope = SpriteExtension.class)
@Adapter
@AutoLoad
public final class SpriteResourceInstaller implements IAdapter
{
	private final MemoryChunk imageMemory;
	private final ImageDescriptor descriptor;

	private SpriteResourceInstaller(final SpriteExtension spriteExtension, final IObservatoryBuilder observatory)
	{
		final var spriteSupplier = spriteExtension.getSpriteDataSource().adaptNotNull(ISpriteSupplier.class);

		descriptor = spriteExtension.getSpritesDescriptor();
		imageMemory = spriteExtension.getSpriteImageMemory();

		observatory.focus(spriteSupplier).listen(this::loadSprites, ISpriteSupplier.Features.Sprites);

		loadSprites(spriteSupplier.images().toList(), List.of());
	}

	private void loadSprites(List<FileImage> addedSprites, List<FileImage> removedSprites)
	{
		for (final var sprite : addedSprites)
		{
			final var imageViewer = buildImage(sprite);
			imageMemory.getParts().add(imageViewer);
			descriptor.getImages().add(imageViewer);
		}

		final var it = imageMemory.getParts().iterator();
		while (it.hasNext())
		{
			final var imageViewer = (ImageViewer) it.next();
			final var dataProvider = (FileImageDataProvider) imageViewer.getDataProvider();
			if (removedSprites.contains(dataProvider.getFileImageReference()))
			{
				descriptor.getImages().remove(imageViewer);
				it.remove();
			}
		}
	}

	private static ImageViewer buildImage(final FileImage resource)
	{
		final var fileDataProvider = VulkanResourceFactory.eINSTANCE.createFileImageDataProvider();
		fileDataProvider.setFileImageReference(resource);

		final var imageViewer = VulkanResourceFactory.eINSTANCE.createImageViewer();
		imageViewer.setInitialLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		imageViewer.setDataProvider(fileDataProvider);
		imageViewer.getUsages().add(EImageUsage.SAMPLED);
		imageViewer.getUsages().add(EImageUsage.TRANSFER_DST);
		return imageViewer;
	}
}
