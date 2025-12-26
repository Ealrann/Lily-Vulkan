package org.sheepy.lily.vulkan.extra.graphic.sprite;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
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
		final var spriteSupplier = spriteExtension.spriteDataSource().adaptNotNull(ISpriteSupplier.class);

		descriptor = spriteExtension.spritesDescriptor();
		imageMemory = spriteExtension.spriteImageMemory();

		observatory.focus(spriteSupplier).listen(this::loadSprites, ISpriteSupplier.Features.Sprites);

		loadSprites(spriteSupplier.images().toList(), List.of());
	}

	private void loadSprites(List<FileImage> addedSprites, List<FileImage> removedSprites)
	{
		for (final var sprite : addedSprites)
		{
			final var imageViewer = buildImage(sprite);
			imageMemory.parts().add(imageViewer);
			descriptor.images().add(imageViewer);
		}

		final var it = imageMemory.parts().iterator();
		while (it.hasNext())
		{
			final var imageViewer = (ImageViewer) it.next();
			final var dataProvider = (FileImageDataProvider) imageViewer.dataProvider();
			if (removedSprites.contains(dataProvider.fileImageReference()))
			{
				descriptor.images().remove(imageViewer);
				it.remove();
			}
		}
	}

	private static ImageViewer buildImage(final FileImage resource)
	{
		final var fileDataProvider = FileImageDataProvider.builder()
														  .fileImageReference(() -> resource)
														  .build();

		return ImageViewer.builder()
						  .initialLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL)
						  .dataProvider(() -> fileDataProvider)
						  .addUsage(EImageUsage.SAMPLED)
						  .addUsage(EImageUsage.TRANSFER_DST)
						  .build();
	}
}
