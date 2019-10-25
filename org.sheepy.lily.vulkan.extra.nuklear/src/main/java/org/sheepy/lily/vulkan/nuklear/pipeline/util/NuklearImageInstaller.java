package org.sheepy.lily.vulkan.nuklear.pipeline.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.lwjgl.BufferUtils;
import org.lwjgl.nuklear.NkImage;
import org.sheepy.lily.vulkan.api.resource.ITexture2DArrayAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.model.resource.Texture2DArray;
import org.sheepy.vulkan.resource.image.VkTexture;

public final class NuklearImageInstaller
{
	private final List<PathResource> imagePaths;
	private final Texture2DArray imageArray;

	private Map<PathResource, NkImage> imageMap;

	public NuklearImageInstaller(	GraphicsPipeline pipeline,
									List<PathResource> imagePaths,
									Texture2DArray imageArray)
	{
		this.imagePaths = List.copyOf(imagePaths);
		this.imageArray = imageArray;

		for (final var pathResource : imagePaths)
		{
			imageArray.getFiles().add(EcoreUtil.copy(pathResource));
		}

		final var specializationBuffer = BufferUtils.createByteBuffer(4);
		specializationBuffer.putInt(imagePaths.size());
		specializationBuffer.flip();
		pipeline.setSpecializationData(specializationBuffer);
	}

	public Map<PathResource, NkImage> imageMap()
	{
		if (imageMap == null)
		{
			if (imageArray != null)
			{
				final var imageMap = createImageMap();
				this.imageMap = Map.copyOf(imageMap);
			}
			else
			{
				imageMap = Map.of();
			}
		}

		return imageMap;
	}

	private Map<PathResource, NkImage> createImageMap()
	{
		final Map<PathResource, NkImage> imageMap = new HashMap<>();
		final var adapter = imageArray.adapt(ITexture2DArrayAdapter.class);

		final List<VkTexture> textures = adapter.getTextures();
		for (int i = 0; i < textures.size(); i++)
		{
			final var imagePath = imagePaths.get(i);
			final var texture = textures.get(i);
			final var nkImage = NkImage.create();
			nkImage.handle(t -> t.ptr(texture.getViewPtr()));

			imageMap.put(imagePath, nkImage);
		}
		return imageMap;
	}
}
