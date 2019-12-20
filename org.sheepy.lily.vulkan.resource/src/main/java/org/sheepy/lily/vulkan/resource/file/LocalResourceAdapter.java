package org.sheepy.lily.vulkan.resource.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.core.model.application.LocalResource;

@Adapter(scope = LocalResource.class)
public class LocalResourceAdapter extends FileResourceAdapter
{
	@Override
	protected InputStream getInputStream(FileResource resource)
	{
		final var fileResource = (LocalResource) resource;
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
}
