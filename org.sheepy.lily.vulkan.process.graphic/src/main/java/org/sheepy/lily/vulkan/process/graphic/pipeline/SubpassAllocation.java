package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;

@ModelExtender(scope = Subpass.class)
@Allocation(activator = Subpass.FeatureIDs.ENABLED)
@AllocationChild(features = {Subpass.FeatureIDs.RESOURCE_PKG, VulkanResourcePkg.FeatureIDs.RESOURCES})
@AllocationChild(features = {Subpass.FeatureIDs.DESCRIPTOR_PKG, DescriptorPkg.FeatureIDs.DESCRIPTORS})
@AllocationChild(features = {Subpass.FeatureIDs.PIPELINE_PKG, PipelinePkg.FeatureIDs.PIPELINES})
public final class SubpassAllocation implements IAdapter
{
}
