package org.sheepy.vulkan.resource.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.model.resource.FileResource;
import org.sheepy.vulkan.model.resource.ResourcePackage;

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

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.FILE_RESOURCE == eClass;
	}

	public static FileResourceAdapter adapt(FileResource fileResource)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(fileResource, FileResourceAdapter.class);
	}
}
