package org.sheepy.lily.vulkan.process.graphic.process;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;

@ModelExtender(scope = GraphicProcess.class)
@Allocation
@AllocationChild(features = GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION)
@AllocationChild(features = {GraphicPackage.GRAPHIC_PROCESS__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {GraphicPackage.GRAPHIC_PROCESS__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = GraphicPackage.GRAPHIC_PROCESS__DESCRIPTOR_POOL)
@AllocationChild(features = GraphicPackage.GRAPHIC_PROCESS__EXECUTION_RECORDER)
public class GraphicProcessAllocation implements IExtender
{
}
