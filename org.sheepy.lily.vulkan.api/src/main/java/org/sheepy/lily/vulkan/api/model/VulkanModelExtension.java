package org.sheepy.lily.vulkan.api.model;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.enumeration.EnumerationPackage;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
import org.sheepy.vulkan.model.image.ImagePackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VulkanModelExtension implements IModelExtension
{
	@Override
	public Collection<EPackage> getEPackages()
	{
		final List<EPackage> res = new ArrayList<>();

		res.add(BarrierPackage.eINSTANCE);
		res.add(ComputePackage.eINSTANCE);
		res.add(EnumerationPackage.eINSTANCE);
		res.add(GraphicPackage.eINSTANCE);
		res.add(GraphicpipelinePackage.eINSTANCE);
		res.add(ImagePackage.eINSTANCE);
		res.add(ProcessPackage.eINSTANCE);
		res.add(VulkanResourcePackage.eINSTANCE);
		res.add(VulkanPackage.eINSTANCE);

		return List.copyOf(res);
	}
}
