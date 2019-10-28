package org.sheepy.lily.vulkan.resource.file;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.model.resource.AbstractModuleResource;
import org.sheepy.lily.vulkan.model.resource.ModuleResource;

@Adapter(scope = ModuleResource.class)
public class ModuleResourceAdapter extends AbstractModuleResourceAdapter
{
	@Override
	protected Module getModule(AbstractModuleResource resource)
	{
		return ((ModuleResource) resource).getModule();
	}
}
