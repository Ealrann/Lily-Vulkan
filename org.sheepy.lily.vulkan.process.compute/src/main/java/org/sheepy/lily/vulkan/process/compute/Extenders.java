package org.sheepy.lily.vulkan.process.compute;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeExecutionRecorders;
import org.sheepy.lily.vulkan.process.compute.pipeline.ComputePipelineAdapter;
import org.sheepy.lily.vulkan.process.compute.pipeline.DispatchTaskAdapter;
import org.sheepy.lily.vulkan.process.compute.process.ComputeProcessAdapter;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(ComputeExecutionRecorders.class,
					   ComputeProcessAdapter.class,
					   ComputePipelineAdapter.class,
					   DispatchTaskAdapter.class);
	}
}
