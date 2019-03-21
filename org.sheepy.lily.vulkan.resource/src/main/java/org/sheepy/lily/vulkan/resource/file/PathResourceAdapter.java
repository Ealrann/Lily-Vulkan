package org.sheepy.lily.vulkan.resource.file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.PathResource;

public abstract class PathResourceAdapter implements IVulkanAdapter
{
	public ByteBuffer toByteBuffer(PathResource resource)
	{
		ByteBuffer buffer = null;
		InputStream inputStream = null;

		try
		{
			inputStream = getInputStream(resource);
			final byte[] byteArray = inputStream.readAllBytes();

			buffer = MemoryUtil.memAlloc(byteArray.length);

			buffer.put(byteArray);
			buffer.flip();

		} catch (final Exception e)
		{
			System.err.println("Cannot read: " + resource.getPath());
			e.printStackTrace();
		} finally
		{
			if (inputStream != null) try
			{
				inputStream.close();
			} catch (final IOException e)
			{
				e.printStackTrace();
			}
		}
		return buffer;
	}

	abstract protected InputStream getInputStream(PathResource resource);

	public static PathResourceAdapter adapt(PathResource pathResource)
	{
		return IAdapterFactoryService.INSTANCE.adapt(pathResource, PathResourceAdapter.class);
	}
}
