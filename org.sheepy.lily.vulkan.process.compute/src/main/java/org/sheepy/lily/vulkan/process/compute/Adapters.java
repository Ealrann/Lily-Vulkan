package org.sheepy.lily.vulkan.process.compute;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.process.compute.pipeline.ComputePipelineAdapter;
import org.sheepy.lily.vulkan.process.compute.pipeline.DispatchTaskAdapter;
import org.sheepy.lily.vulkan.process.compute.process.ComputeProcessAdapter;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(	ComputeProcessAdapter.class,
						ComputePipelineAdapter.class,
						DispatchTaskAdapter.class);
	}
}
