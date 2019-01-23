package org.sheepy.vulkan.resource.file;

import java.io.IOException;
import java.io.InputStream;

import org.sheepy.vulkan.model.resource.AbstractModuleResource;
import org.sheepy.vulkan.model.resource.PathResource;

public abstract class AbstractModuleResourceAdapter extends PathResourceAdapter
{
	@Override
	protected InputStream getInputStream(PathResource resource)
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
