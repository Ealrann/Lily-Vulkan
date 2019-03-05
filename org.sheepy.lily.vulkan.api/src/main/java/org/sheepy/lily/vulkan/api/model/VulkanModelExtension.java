package org.sheepy.lily.vulkan.api.model;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.enumeration.EnumerationPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

public class VulkanModelExtension implements IModelExtension
{
	@Override
	public Collection<EPackage> getEPackages()
	{
		Collection<EPackage> res = new ArrayList<>();

		res.add(ComputePackage.eINSTANCE);
		res.add(GraphicPackage.eINSTANCE);
		res.add(ProcessPackage.eINSTANCE);
		res.add(ResourcePackage.eINSTANCE);
		res.add(VulkanPackage.eINSTANCE);
		res.add(EnumerationPackage.eINSTANCE);

		return res;
	}
}
