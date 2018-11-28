package org.sheepy.vulkan.resource.file;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.model.resource.ModuleResource;
import org.sheepy.vulkan.model.resource.PathResource;
import org.sheepy.vulkan.model.resource.ResourcePackage;

public class ModuleResourceAdapter extends PathResourceAdapter
{
	@Override
	protected InputStream getInputStream(PathResource resource)
	{
		final var moduleResource = (ModuleResource) resource;

		final var path = moduleResource.getPath();
		final var module = moduleResource.getModule();

		try
		{
			return module.getResourceAsStream(path);
		} catch (final IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.MODULE_RESOURCE == eClass;
	}

	public static ModuleResourceAdapter adapt(ModuleResource moduleResource)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(moduleResource, ModuleResourceAdapter.class);
	}
}
