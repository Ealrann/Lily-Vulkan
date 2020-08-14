package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

@ModelExtender(scope = Subpass.class)
@Allocation
@AllocationChild(features = {GraphicPackage.SUBPASS__VULKAN_RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {GraphicPackage.SUBPASS__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = {GraphicPackage.SUBPASS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES})
public final class SubpassAllocation implements IExtender
{
}
