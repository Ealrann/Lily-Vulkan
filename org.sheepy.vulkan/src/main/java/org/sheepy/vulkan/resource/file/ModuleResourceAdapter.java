package org.sheepy.vulkan.resource.file;

import java.io.IOException;
import java.io.InputStream;

import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.model.ModuleResource;

public class ModuleResourceAdapter extends PathResourceAdapter
{
	@Override
	protected InputStream getInputStream()
	{
		final var resource = (ModuleResource) target;

		final var path = resource.getPath();
		final var module = resource.getModule();

		try
		{
			return module.getResourceAsStream(path);
		} catch (final IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ModuleResourceAdapter adapt(ModuleResource moduleResource)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(moduleResource, ModuleResourceAdapter.class);
	}
}
