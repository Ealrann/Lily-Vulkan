package org.sheepy.vulkan.resource.file;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.model.resource.AbstractModuleResource;
import org.sheepy.vulkan.model.resource.ModuleResource;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.resource.StringModuleResource;

public class StringModuleResourceAdapter extends AbstractModuleResourceAdapter
{
	@Override
	protected Module getModule(AbstractModuleResource resource)
	{
		String moduleName = ((StringModuleResource) resource).getModuleName();
		Module res = null;
		throw new AssertionError("TODO, resolve module from name");
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.MODULE_RESOURCE == eClass;
	}

	public static StringModuleResourceAdapter adapt(ModuleResource moduleResource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(moduleResource, StringModuleResourceAdapter.class);
	}
}
