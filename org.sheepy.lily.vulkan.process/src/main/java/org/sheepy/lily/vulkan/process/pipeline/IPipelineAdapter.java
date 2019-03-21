package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.process.IPipeline;

public interface IPipelineAdapter<T extends AbstractCommandBuffer> extends IVulkanAdapter
{
	boolean isRecordNeeded();
	void setRecordNeeded(boolean value);

	default void prepare()
	{}

	void record(T commandBuffer, int bindPoint);

	@SuppressWarnings("unchecked")
	static <T extends AbstractCommandBuffer> IPipelineAdapter<T> adapt(IPipeline object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IPipelineAdapter.class);
	}
}
