package org.sheepy.lily.vulkan.process.compute.process;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAllocation;

@ModelExtender(scope = ComputeProcess.class)
@Allocation(context = IVulkanContext.class)
@AllocationChild(features = ComputeProcess.FeatureIDs.CONFIGURATION)
@AllocationChild(features = {ComputeProcess.FeatureIDs.RESOURCE_PKG, VulkanResourcePkg.FeatureIDs.RESOURCES})
@AllocationChild(features = {ComputeProcess.FeatureIDs.DESCRIPTOR_PKG, DescriptorPkg.FeatureIDs.DESCRIPTORS})
@AllocationChild(features = ComputeProcess.FeatureIDs.DESCRIPTOR_POOL)
@AllocationChild(features = {ComputeProcess.FeatureIDs.PIPELINE_PKG, PipelinePkg.FeatureIDs.PIPELINES})
@AllocationChild(features = ComputeProcess.FeatureIDs.EXECUTION_MANAGER)
public class ComputeProcessAllocation extends AbstractProcessAllocation
{
	public ComputeProcessAllocation(ComputeProcess process, IVulkanContext context)
	{
		super(process, context);
	}
}
