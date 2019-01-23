package org.sheepy.lily.vulkan.resource.file;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.model.resource.AbstractModuleResource;
import org.sheepy.lily.vulkan.model.resource.ModuleResource;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.StringModuleResource;

public class StringModuleResourceAdapter extends AbstractModuleResourceAdapter
{
	@Override
	protected Module getModule(AbstractModuleResource resource)
	{
		String moduleName = ((StringModuleResource) resource).getModuleName();
		Module res = ModuleLayer.boot().findModule(moduleName).orElse(null);
		return res;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.STRING_MODULE_RESOURCE == eClass;
	}

	public static StringModuleResourceAdapter adapt(ModuleResource moduleResource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(moduleResource, StringModuleResourceAdapter.class);
	}
}
