package org.sheepy.vulkan.process.process;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.resource.IResourceManagerAdapter;
import org.sheepy.vulkan.resource.ResourceManager;

public class ResourceManagerAdapter extends AbstractSingletonAdapter
		implements IResourceManagerAdapter
{
	@Override
	public ResourceManager getResourceManager(EObject target)
	{
		var current = target;
		while (!ProcessPackage.Literals.ABSTRACT_PROCESS.isSuperTypeOf(current.eClass()))
		{
			current = current.eContainer();
		}

		return AbstractProcessAdapter.adapt((AbstractProcess) current).resourceManager;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return true;
	}
}
