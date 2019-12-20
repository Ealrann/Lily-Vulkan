package org.sheepy.lily.vulkan.resource.file;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.model.application.AbstractModuleResource;
import org.sheepy.lily.core.model.application.StringModuleResource;

@Adapter(scope = StringModuleResource.class)
public class StringModuleResourceAdapter extends AbstractModuleResourceAdapter
{
	@Override
	protected Module getModule(AbstractModuleResource resource)
	{
		final String moduleName = ((StringModuleResource) resource).getModuleName();
		return ModuleLayer.boot().findModule(moduleName).orElse(null);
	}
}
