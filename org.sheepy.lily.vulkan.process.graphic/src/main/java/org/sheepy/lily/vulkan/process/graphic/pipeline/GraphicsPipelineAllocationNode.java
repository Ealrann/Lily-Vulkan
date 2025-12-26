package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = GraphicsPipeline.class)
@Allocation(context = ProcessContext.class, activator = GraphicsPipeline.FeatureIDs.ALLOCATE)
@AllocationChild(features = {GraphicsPipeline.FeatureIDs.RESOURCE_PKG, VulkanResourcePkg.FeatureIDs.RESOURCES})
@AllocationChild(features = {GraphicsPipeline.FeatureIDs.DESCRIPTOR_PKG, DescriptorPkg.FeatureIDs.DESCRIPTORS})
@AllocationChild(features = {GraphicsPipeline.FeatureIDs.DESCRIPTOR_POOL})
@AllocationChild(features = GraphicsPipeline.FeatureIDs.TASK_PKGS)
public final class GraphicsPipelineAllocationNode implements IAdapter
{
}
