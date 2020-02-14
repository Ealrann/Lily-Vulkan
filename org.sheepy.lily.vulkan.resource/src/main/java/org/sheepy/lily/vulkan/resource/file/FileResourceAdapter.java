package org.sheepy.lily.vulkan.resource.file;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.resource.IFileResourceAdapter;
import org.sheepy.lily.core.model.resource.FileResource;

import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class FileResourceAdapter implements IFileResourceAdapter
{
	@Override
	public ByteBuffer allocByteBuffer(FileResource resource)
	{
		try (final var inputStream = getInputStream(resource))
		{
			final byte[] byteArray = inputStream.readAllBytes();
			final var buffer = MemoryUtil.memAlloc(byteArray.length);
			buffer.put(byteArray);
			buffer.flip();
			return buffer;
		}
		catch (final Exception e)
		{
			logCantAccess(resource);
			e.printStackTrace();
			return null;
		}
	}

	private static void logCantAccess(FileResource resource)
	{
		System.err.println("Can't access the file : " + resource.getPath());
	}

	abstract protected InputStream getInputStream(FileResource resource);
}
