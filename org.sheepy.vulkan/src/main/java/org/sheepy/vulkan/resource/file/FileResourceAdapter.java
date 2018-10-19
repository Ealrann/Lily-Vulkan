package org.sheepy.vulkan.resource.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.model.resource.FileResource;

public class FileResourceAdapter extends PathResourceAdapter
{
	@Override
	protected InputStream getInputStream()
	{
		final var resource = (FileResource) target;
		final var file = new File(resource.getPath());

		try
		{
			return new FileInputStream(file);
		} catch (final FileNotFoundException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public static FileResourceAdapter adapt(FileResource fileResource)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(fileResource, FileResourceAdapter.class);
	}
}
