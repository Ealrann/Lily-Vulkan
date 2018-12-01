package org.sheepy.vulkan.process.compute.pipeline;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.model.process.compute.IComputer;
import org.sheepy.vulkan.process.compute.execution.ComputeCommandBuffer;

public interface IComputerAdapter extends IVulkanAdapter
{
	void record(ComputeCommandBuffer commandBuffer, int bindPoint);
	
	static IComputerAdapter adapt(IComputer object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IComputerAdapter.class);
	}
}
