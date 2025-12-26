package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.process.TaskPkg;

@ModelExtender(scope = TaskPkg.class)
@Allocation
@AllocationChild(features = TaskPkg.FeatureIDs.TASKS)
public final class TaskPkgAllocation implements IAdapter
{
}

