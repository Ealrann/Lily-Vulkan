package org.sheepy.lily.vulkan.resource.file;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.AbstractModuleResource;
import org.sheepy.lily.core.model.resource.StringModuleResource;

@ModelExtender(scope = StringModuleResource.class)
@Adapter(singleton = true)
public class StringModuleResourceAdapter extends AbstractModuleResourceAdapter
{
	@Override
	protected Module getModule(AbstractModuleResource resource)
	{
		final String moduleName = ((StringModuleResource) resource).getModuleName();
		return ModuleLayer.boot().findModule(moduleName).orElse(null);
	}
}
