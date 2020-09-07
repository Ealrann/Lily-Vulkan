package org.sheepy.lily.vulkan.resource.image.backend;

import org.joml.Vector2ic;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.resource.IFileResourceAdapter;
import org.sheepy.lily.core.model.resource.FileResource;

import java.nio.ByteBuffer;

public final class ImageBuffer
{
	public final FileResource resource;

	private ByteBuffer byteBuffer = null;
	private Vector2ic size;

	public ImageBuffer(FileResource resource)
	{
		this.resource = resource;
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

	public void free()
	{
		if (byteBuffer != null)
		{
			MemoryUtil.memFree(byteBuffer);
			byteBuffer = null;
		}
	}

	public Vector2ic getImageSize()
	{
		return size;
	}

	public ByteBuffer getByteBuffer()
	{
		return byteBuffer;
	}
}