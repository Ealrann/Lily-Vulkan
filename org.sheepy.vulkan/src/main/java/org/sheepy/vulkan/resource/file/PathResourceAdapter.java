package org.sheepy.vulkan.resource.file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.model.resource.PathResource;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.resource.ResourceAdapter;

public abstract class PathResourceAdapter extends ResourceAdapter
{
	private int initialBufferSize = 1024;

	public ByteBuffer toByteBuffer()
	{
		ByteBuffer buffer = null;
		InputStream inputStream = null;

		try
		{
			inputStream = getInputStream();
			final byte[] byteArray = inputStream.readAllBytes();

			buffer = ByteBuffer.allocateDirect(byteArray.length);

			buffer.put(byteArray);
			buffer.flip();

		} catch (final Exception e)
		{
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

	abstract protected InputStream getInputStream();

	public int getInitialBufferSize()
	{
		return initialBufferSize;
	}

	public void setInitialBufferSize(int initialBufferSize)
	{
		this.initialBufferSize = initialBufferSize;
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{}

	@Override
	public void free()
	{}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.PATH_RESOURCE == eClass;
	}

	public static PathResourceAdapter adapt(PathResource pathResource)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(pathResource, PathResourceAdapter.class);
	}
}
