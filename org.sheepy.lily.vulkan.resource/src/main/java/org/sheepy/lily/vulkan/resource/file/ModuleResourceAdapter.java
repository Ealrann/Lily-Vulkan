package org.sheepy.vulkan.resource.file;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.model.resource.AbstractModuleResource;
import org.sheepy.vulkan.model.resource.ModuleResource;
import org.sheepy.vulkan.model.resource.ResourcePackage;

public class ModuleResourceAdapter extends AbstractModuleResourceAdapter
{
	@Override
	protected Module getModule(AbstractModuleResource resource)
	{
		return ((ModuleResource) resource).getModule();
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.MODULE_RESOURCE == eClass;
	}

	public static ModuleResourceAdapter adapt(ModuleResource moduleResource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(moduleResource, ModuleResourceAdapter.class);
	}
}
