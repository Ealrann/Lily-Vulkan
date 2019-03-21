package org.sheepy.lily.vulkan.resource.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.model.resource.FileResource;
import org.sheepy.lily.vulkan.model.resource.PathResource;

@Adapter(scope = FileResource.class)
public class FileResourceAdapter extends PathResourceAdapter
{
	@Override
	protected InputStream getInputStream(PathResource resource)
	{
		final var fileResource = (FileResource) resource;
		final var file = new File(fileResource.getPath());

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
		return IAdapterFactoryService.INSTANCE.adapt(fileResource, FileResourceAdapter.class);
	}
}
