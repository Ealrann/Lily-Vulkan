package org.sheepy.lily.vulkan.resource.file;

import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.resource.IFileResourceAdapter;
import org.sheepy.lily.core.model.application.FileResource;

public abstract class FileResourceAdapter implements IFileResourceAdapter
{
	@Override
	public ByteBuffer allocByteBuffer(FileResource resource)
	{
		ByteBuffer buffer = null;

		try (InputStream inputStream = getInputStream(resource))
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

	private static void logCantAccess(FileResource resource)
	{
		System.err.println("Can't access the file : " + resource.getPath());
	}

	abstract protected InputStream getInputStream(FileResource resource);
}
