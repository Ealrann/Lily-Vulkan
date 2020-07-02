package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = GraphicsPipeline.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = {GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = {GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_POOL})
@AllocationChild(features = {GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, ProcessPackage.TASK_PKG__TASKS})
public final class GraphicsPipelineAllocationNode implements IExtender
{
}
