package org.sheepy.lily.vulkan.process.compute;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeExecutionRecordersAllocation;
import org.sheepy.lily.vulkan.process.compute.pipeline.ComputePipelineRecorder;
import org.sheepy.lily.vulkan.process.compute.pipeline.DispatchTaskAdapter;
import org.sheepy.lily.vulkan.process.compute.process.ComputeProcessAdapter;
import org.sheepy.lily.vulkan.process.compute.process.ComputeProcessAllocation;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(ComputeExecutionRecordersAllocation.class,
					   ComputeProcessAdapter.class,
					   ComputeProcessAllocation.class,
					   ComputePipelineRecorder.class,
					   DispatchTaskAdapter.class);
	}
}
