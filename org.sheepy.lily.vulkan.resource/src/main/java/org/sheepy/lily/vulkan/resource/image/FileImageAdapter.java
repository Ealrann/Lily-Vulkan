package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2ic;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.resource.IFileImageAdapter;
import org.sheepy.lily.core.api.resource.IFileResourceAdapter;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.vulkan.resource.image.backend.STBImageLoader;

import java.nio.ByteBuffer;

@ModelExtender(scope = FileImage.class)
@Adapter
public final class FileImageAdapter implements IFileImageAdapter
{
	public final FileResource resource;

	private ByteBuffer byteBuffer = null;
	private Vector2ic size = null;

	private FileImageAdapter(FileImage fileImage)
	{
		this.resource = fileImage.getFile();
	}

	public void allocate()
	{
		if (byteBuffer == null)
		{
			final var fileAdapter = resource.adaptNotNull(IFileResourceAdapter.class);
			byteBuffer = fileAdapter.allocByteBuffer(resource);
			size = STBImageLoader.getSize(byteBuffer);
		}
	}

	@Dispose
	public void free()
	{
		if (byteBuffer != null)
		{
			MemoryUtil.memFree(byteBuffer);
			byteBuffer = null;
		}
	}

	@Override
	public Vector2ic size()
	{
		if (size == null) allocate();
		return size;
	}

	public ByteBuffer getByteBuffer()
	{
		return byteBuffer;
	}
}