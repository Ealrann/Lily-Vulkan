package org.sheepy.lily.vulkan.resource.file;

import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.api.resource.IPathResourceAdapter;
import org.sheepy.lily.vulkan.model.resource.PathResource;

public abstract class PathResourceAdapter implements IPathResourceAdapter
{
	@Override
	public ByteBuffer allocByteBuffer(PathResource resource)
	{
		ByteBuffer buffer = null;

		try (InputStream inputStream = getInputStream(resource);)
		{
			final byte[] byteArray = inputStream.readAllBytes();
			buffer = MemoryUtil.memAlloc(byteArray.length);
			buffer.put(byteArray);
			buffer.flip();

		} catch (final Exception e)
		{
			logCantAccess(resource);
			e.printStackTrace();
		}

		return buffer;
	}

	private static void logCantAccess(PathResource resource)
	{
		System.err.println("Can't access the file : " + resource.getPath());
	}

	abstract protected InputStream getInputStream(PathResource resource);
}
