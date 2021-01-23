package org.sheepy.lily.vulkan.process.compute;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeExecutionRecorderAllocation;
import org.sheepy.lily.vulkan.process.compute.pipeline.ComputePipelineAllocation;
import org.sheepy.lily.vulkan.process.compute.pipeline.ComputePipelineAllocationNode;
import org.sheepy.lily.vulkan.process.compute.pipeline.ComputePipelineRecorder;
import org.sheepy.lily.vulkan.process.compute.pipeline.DispatchTaskAdapter;
import org.sheepy.lily.vulkan.process.compute.process.ComputeProcessAdapter;
import org.sheepy.lily.vulkan.process.compute.process.ComputeProcessAllocation;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Extenders implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(ComputeExecutionManagerAllocation.class,
					   ComputeExecutionRecorderAllocation.class,
					   ComputeProcessAllocation.class,
					   ComputeProcessAdapter.class,
					   ComputePipelineAllocationNode.class,
					   ComputePipelineAllocation.class,
					   ComputePipelineRecorder.class,
					   DispatchTaskAdapter.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
