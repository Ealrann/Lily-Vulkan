package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.process.CompositePipeline;

@ModelExtender(scope = CompositePipeline.class)
@Allocation(activator = CompositePipeline.FeatureIDs.ALLOCATE)
@AllocationChild(features = CompositePipeline.FeatureIDs.PIPELINES)
public class CompositePipelineAllocation implements IAdapter
{
}

