package org.sheepy.vulkan.process.pipeline;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.process.IPipelineUnit;

public interface IPipelineUnitAdapter<T extends AbstractCommandBuffer> extends IVulkanAdapter
{
	void record(T commandBuffer, int bindPoint);

	@SuppressWarnings("unchecked")
	static <T extends AbstractCommandBuffer> IPipelineUnitAdapter<T> adapt(IPipelineUnit object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IPipelineUnitAdapter.class);
	}
}
