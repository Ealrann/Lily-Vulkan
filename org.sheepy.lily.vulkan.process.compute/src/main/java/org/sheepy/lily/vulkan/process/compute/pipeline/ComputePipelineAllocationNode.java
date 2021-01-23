package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = ComputePipeline.class)
@Allocation(context = ProcessContext.class, activator = ComputePackage.COMPUTE_PIPELINE__ALLOCATE)
@AllocationChild(features = {ComputePackage.COMPUTE_PIPELINE__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {ComputePackage.COMPUTE_PIPELINE__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = {ComputePackage.COMPUTE_PIPELINE__DESCRIPTOR_POOL})
@AllocationChild(features = ComputePackage.COMPUTE_PIPELINE__TASK_PKGS)
public final class ComputePipelineAllocationNode implements IAdapter
{
}
