package org.sheepy.lily.vulkan.demo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;

public class VulkanDemoModelExtension implements IModelExtension
{
	@Override
	public Collection<EPackage> getEPackages()
	{
		final List<EPackage> res = new ArrayList<>();

		res.add(VulkanDemoPackage.eINSTANCE);

		return List.copyOf(res);
	}
}
