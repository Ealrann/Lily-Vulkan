package org.sheepy.lily.vulkan.api.util;

import java.nio.ByteBuffer;

import org.joml.Vector2ic;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.api.resource.IPathResourceAdapter;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.vulkan.resource.image.STBImageLoader;

public class ImageBuffer
{
	public final PathResource resource;

	private ByteBuffer byteBuffer = null;
	private Vector2ic size;

	public ImageBuffer(PathResource resource)
	{
		this.resource = resource;
	}

	public void allocate()
	{
		if (byteBuffer == null)
		{
			final var fileAdapter = resource.adaptNotNull(IPathResourceAdapter.class);
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