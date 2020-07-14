package org.sheepy.lily.vulkan.process.graphic.process;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAllocation;

@ModelExtender(scope = GraphicProcess.class)
@Allocation(context = IVulkanContext.class)
@AllocationChild(features = GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION)
@AllocationChild(features = {GraphicPackage.GRAPHIC_PROCESS__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {GraphicPackage.GRAPHIC_PROCESS__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = GraphicPackage.GRAPHIC_PROCESS__DESCRIPTOR_POOL)
@AllocationChild(features = GraphicPackage.GRAPHIC_PROCESS__SUBPASSES)
@AllocationChild(features = GraphicPackage.GRAPHIC_PROCESS__EXECUTION_MANAGER)
public final class GraphicProcessAllocation extends AbstractProcessAllocation
{
	public final SubpassManager subpassManager;

	public GraphicProcessAllocation(GraphicProcess process, IVulkanContext vulkanContext)
	{
		super(process, vulkanContext);
		subpassManager = new SubpassManager(process);

		if (process.getResourcePkg() == null)
		{
			process.setResourcePkg(ResourceFactory.eINSTANCE.createResourcePkg());
		}
		if (process.getDescriptorPkg() == null)
		{
			process.setDescriptorPkg(VulkanFactory.eINSTANCE.createDescriptorPkg());
		}
		subpassManager.start(vulkanContext);
	}

	@Free
	private void free()
	{
		subpassManager.stop(vulkanContext);
	}
}
