package org.sheepy.lily.vulkan.process.graphic.process;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAllocation;

@ModelExtender(scope = GraphicProcess.class)
@Allocation(context = IVulkanContext.class)
@AllocationChild(features = GraphicProcess.FeatureIDs.CONFIGURATION)
@AllocationChild(features = {GraphicProcess.FeatureIDs.RESOURCE_PKG, VulkanResourcePkg.FeatureIDs.RESOURCES})
@AllocationChild(features = {GraphicProcess.FeatureIDs.DESCRIPTOR_PKG, DescriptorPkg.FeatureIDs.DESCRIPTORS})
@AllocationChild(features = GraphicProcess.FeatureIDs.DESCRIPTOR_POOL)
@AllocationChild(features = GraphicProcess.FeatureIDs.SUBPASSES)
@AllocationChild(features = GraphicProcess.FeatureIDs.EXECUTION_MANAGER)
public final class GraphicProcessAllocation extends AbstractProcessAllocation
{
	public final SubpassManager subpassManager;

	public GraphicProcessAllocation(GraphicProcess process, IVulkanContext vulkanContext)
	{
		super(process, vulkanContext);
		subpassManager = new SubpassManager(process);

		if (process.resourcePkg() == null)
		{
			process.resourcePkg(VulkanResourcePkg.builder().build());
		}
		if (process.descriptorPkg() == null)
		{
			process.descriptorPkg(DescriptorPkg.builder().build());
		}
		subpassManager.start(vulkanContext);
	}

	@Free
	private void free()
	{
		subpassManager.stop();
	}
}
