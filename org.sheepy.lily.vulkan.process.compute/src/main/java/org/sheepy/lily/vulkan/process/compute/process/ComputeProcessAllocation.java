package org.sheepy.lily.vulkan.process.compute.process;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;

@ModelExtender(scope = ComputeProcess.class)
@Allocation
@AllocationChild(features = ComputePackage.COMPUTE_PROCESS__CONFIGURATION)
@AllocationChild(features = {ComputePackage.COMPUTE_PROCESS__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {ComputePackage.COMPUTE_PROCESS__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = ComputePackage.COMPUTE_PROCESS__DESCRIPTOR_POOL)
@AllocationChild(features = ComputePackage.COMPUTE_PROCESS__EXECUTION_RECORDER)
public final class ComputeProcessAllocation implements IExtender
{
}
