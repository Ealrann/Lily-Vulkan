package org.sheepy.lily.vulkan.resource.file;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.LocalResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@ModelExtender(scope = LocalResource.class)
@Adapter(singleton = true)
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
		}
		catch (final FileNotFoundException e)
		{
			e.printStackTrace();
			return InputStream.nullInputStream();
		}
	}
}
