package org.sheepy.lily.vulkan.api.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.binding.BindingPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.enumeration.EnumerationPackage;
import org.sheepy.vulkan.model.image.ImagePackage;

public class VulkanModelExtension implements IModelExtension
{
	@Override
	public Collection<EPackage> getEPackages()
	{
		final List<EPackage> res = new ArrayList<>();

		res.add(BarrierPackage.eINSTANCE);
		res.add(BindingPackage.eINSTANCE);
		res.add(ComputePackage.eINSTANCE);
		res.add(EnumerationPackage.eINSTANCE);
		res.add(GraphicPackage.eINSTANCE);
		res.add(ImagePackage.eINSTANCE);
		res.add(ProcessPackage.eINSTANCE);
		res.add(ResourcePackage.eINSTANCE);
		res.add(VulkanPackage.eINSTANCE);

		return List.copyOf(res);
	}
}
