package org.sheepy.lily.vulkan.extra.api.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.extra.model.graphic.GraphicExtraPackage;

public class VulkanExtraModelExtension implements IModelExtension
{
	@Override
	public Collection<EPackage> getEPackages()
	{
		final List<EPackage> res = new ArrayList<>();

		res.add(GraphicExtraPackage.eINSTANCE);
		
		return List.copyOf(res);
	}
}
