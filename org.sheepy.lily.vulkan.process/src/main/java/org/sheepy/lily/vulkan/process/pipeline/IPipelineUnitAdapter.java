package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.process.IPipelineUnit;

public interface IPipelineUnitAdapter<T extends AbstractCommandBuffer> extends IVulkanAdapter
{
	void record(T commandBuffer, int bindPoint);

	@SuppressWarnings("unchecked")
	static <T extends AbstractCommandBuffer> IPipelineUnitAdapter<T> adapt(IPipelineUnit object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IPipelineUnitAdapter.class);
	}
}
