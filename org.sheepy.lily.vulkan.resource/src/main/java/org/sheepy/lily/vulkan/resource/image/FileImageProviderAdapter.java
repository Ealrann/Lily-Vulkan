package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2ic;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.DummyNotifier;
import org.sheepy.lily.game.api.resource.image.IImageDataProviderAdapter;
import org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider;
import org.sheepy.lily.vulkan.resource.image.backend.ImageBuffer;
import org.sheepy.lily.vulkan.resource.image.backend.STBImageLoader;

import java.nio.ByteBuffer;

@ModelExtender(scope = FileImageDataProvider.class)
@Adapter
public final class FileImageProviderAdapter extends DummyNotifier<IImageDataProviderAdapter.Features> implements
																									  IImageDataProviderAdapter
{
	private final ImageBuffer imageBuffer;
	private final Vector2ic size;

	private FileImageProviderAdapter(FileImageDataProvider dataProvider)
	{
		final var fileImageContainment = dataProvider.getFileImageContainment();
		final var fileImageReference = dataProvider.getFileImageReference();
		assert fileImageContainment != null ^ fileImageReference != null;

		final var fileImage = fileImageContainment != null ? fileImageContainment : fileImageReference;
		imageBuffer = new ImageBuffer(fileImage.getFile());
		imageBuffer.allocate();
		size = imageBuffer.getImageSize();
	}

	@Dispose
	private void dispose()
	{
		imageBuffer.free();
	}

	@Override
	public void fill(final ByteBuffer buffer)
	{
		final var imageLoader = new STBImageLoader();
		imageBuffer.allocate();
		imageLoader.allocBuffer(imageBuffer.getByteBuffer());
		MemoryUtil.memCopy(imageLoader.getBuffer(), buffer);
		imageLoader.free();
		imageBuffer.free();
	}

	@Override
	public Vector2ic size()
	{
		return size;
	}
}
