package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = ComputePipeline.class)
@Allocation(context = ProcessContext.class, activator = ComputePipeline.FeatureIDs.ALLOCATE)
@AllocationChild(features = {ComputePipeline.FeatureIDs.RESOURCE_PKG, VulkanResourcePkg.FeatureIDs.RESOURCES})
@AllocationChild(features = {ComputePipeline.FeatureIDs.DESCRIPTOR_PKG, DescriptorPkg.FeatureIDs.DESCRIPTORS})
@AllocationChild(features = {ComputePipeline.FeatureIDs.DESCRIPTOR_POOL})
@AllocationChild(features = ComputePipeline.FeatureIDs.TASK_PKGS)
public final class ComputePipelineAllocationNode implements IAdapter
{
}
