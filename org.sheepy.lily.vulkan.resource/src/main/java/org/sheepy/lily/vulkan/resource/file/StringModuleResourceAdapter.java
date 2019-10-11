package org.sheepy.lily.vulkan.resource.file;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.model.resource.AbstractModuleResource;
import org.sheepy.lily.vulkan.model.resource.ModuleResource;
import org.sheepy.lily.vulkan.model.resource.StringModuleResource;

@Adapter(scope = StringModuleResource.class)
public class StringModuleResourceAdapter extends AbstractModuleResourceAdapter
{
	@Override
	protected Module getModule(AbstractModuleResource resource)
	{
		final String moduleName = ((StringModuleResource) resource).getModuleName();
		return ModuleLayer.boot().findModule(moduleName).orElse(null);
	}

	public static StringModuleResourceAdapter adapt(ModuleResource moduleResource)
	{
		return IAdapterFactoryService.INSTANCE.adapt(moduleResource,
				StringModuleResourceAdapter.class);
	}
}
