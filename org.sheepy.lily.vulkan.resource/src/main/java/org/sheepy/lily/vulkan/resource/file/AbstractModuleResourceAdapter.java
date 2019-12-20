package org.sheepy.lily.vulkan.resource.file;

import java.io.IOException;
import java.io.InputStream;

import org.sheepy.lily.core.model.application.AbstractModuleResource;
import org.sheepy.lily.core.model.application.FileResource;

public abstract class AbstractModuleResourceAdapter extends FileResourceAdapter
{
	@Override
	protected InputStream getInputStream(FileResource resource)
	{
		final var moduleResource = (AbstractModuleResource) resource;

		final var path = moduleResource.getPath();
		final var module = getModule(moduleResource);

		try
		{
			return module.getResourceAsStream(path);
		} catch (final IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	protected abstract Module getModule(AbstractModuleResource resource);
}
