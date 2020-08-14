package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = GraphicsPipeline.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = {GraphicPackage.GRAPHICS_PIPELINE__VULKAN_RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = {GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_POOL})
@AllocationChild(features = GraphicPackage.GRAPHICS_PIPELINE__TASK_PKGS)
public final class GraphicsPipelineAllocationNode implements IExtender
{
}
