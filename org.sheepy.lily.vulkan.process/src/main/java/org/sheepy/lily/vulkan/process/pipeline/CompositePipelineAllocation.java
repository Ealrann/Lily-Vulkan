package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.process.CompositePipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

@ModelExtender(scope = CompositePipeline.class)
@Allocation(activator = ProcessPackage.COMPOSITE_PIPELINE__ALLOCATE)
@AllocationChild(features = ProcessPackage.COMPOSITE_PIPELINE__PIPELINES)
public class CompositePipelineAllocation implements IExtender
{
}
