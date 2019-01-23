package org.sheepy.lily.vulkan.resource.file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

public abstract class PathResourceAdapter extends AbstractSingletonAdapter implements IVulkanAdapter
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

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.PATH_RESOURCE == eClass;
	}

	public static PathResourceAdapter adapt(PathResource pathResource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(pathResource, PathResourceAdapter.class);
	}
}
