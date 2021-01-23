package org.sheepy.lily.vulkan.process.compute.process;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAllocation;

@ModelExtender(scope = ComputeProcess.class)
@Allocation(context = IVulkanContext.class)
@AllocationChild(features = ComputePackage.COMPUTE_PROCESS__CONFIGURATION)
@AllocationChild(features = {ComputePackage.COMPUTE_PROCESS__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {ComputePackage.COMPUTE_PROCESS__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = ComputePackage.COMPUTE_PROCESS__DESCRIPTOR_POOL)
@AllocationChild(features = {ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES})
@AllocationChild(features = ComputePackage.COMPUTE_PROCESS__EXECUTION_MANAGER)
public class ComputeProcessAllocation extends AbstractProcessAllocation
{
	public ComputeProcessAllocation(ComputeProcess process, IVulkanContext context)
	{
		super(process, context);
	}
}
