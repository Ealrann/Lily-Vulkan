package org.sheepy.lily.vulkan.resource.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.model.resource.FileResource;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

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

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.FILE_RESOURCE == eClass;
	}

	public static FileResourceAdapter adapt(FileResource fileResource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(fileResource, FileResourceAdapter.class);
	}
}
