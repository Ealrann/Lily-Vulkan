package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2ic;
import org.lwjgl.system.MemoryUtil;
import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.logoce.extender.api.ModelExtender;
import org.logoce.notification.api.DummyNotifier;
import org.sheepy.lily.game.api.resource.image.IImageDataProviderAdapter;
import org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider;
import org.sheepy.lily.vulkan.resource.image.backend.STBImageLoader;

import java.nio.ByteBuffer;

@ModelExtender(scope = FileImageDataProvider.class)
@Adapter
public final class FileImageProviderAdapter extends DummyNotifier<IImageDataProviderAdapter.Features> implements
																									  IImageDataProviderAdapter
{
	private final FileImageAdapter imageAdapter;

	private FileImageProviderAdapter(FileImageDataProvider dataProvider)
	{
		final var fileImageContainment = dataProvider.getFileImageContainment();
		final var fileImageReference = dataProvider.getFileImageReference();
		assert fileImageContainment != null ^ fileImageReference != null;

		final var fileImage = fileImageContainment != null ? fileImageContainment : fileImageReference;
		imageAdapter = fileImage.adapt(FileImageAdapter.class);
		imageAdapter.allocate();
	}

	@Dispose
	private void dispose()
	{
		imageAdapter.free();
	}

	@Override
	public void fill(final ByteBuffer buffer)
	{
		imageAdapter.allocate();
		final var pixelBuffer = STBImageLoader.load(imageAdapter.getByteBuffer());
		MemoryUtil.memCopy(pixelBuffer.pixels(), buffer);
		imageAdapter.free();
		pixelBuffer.free();
	}

	@Override
	public Vector2ic size()
	{
		return imageAdapter.size();
	}
}
