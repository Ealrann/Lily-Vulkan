package org.sheepy.lily.vulkan.resource.file;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.model.resource.AbstractModuleResource;
import org.sheepy.lily.core.model.resource.ModuleResource;

@ModelExtender(scope = ModuleResource.class)
@Adapter(singleton = true)
public class ModuleResourceAdapter extends AbstractModuleResourceAdapter
{
	@Override
	protected Module getModule(AbstractModuleResource resource)
	{
		return ((ModuleResource) resource).getModule();
	}
}
