package org.sheepy.lily.vulkan.api.pipeline;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.process.IProcessPartAdapter;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.vulkan.pipeline.VkPipeline;
import org.sheepy.vulkan.pipeline.VkPipelineLayout;

public interface IPipelineAdapter<T extends IProcessContext> extends IProcessPartAdapter
{
	VkPipelineLayout<? super T> getVkPipelineLayout();
	List<? extends VkPipeline<? super T>> getVkPipelines();

	static IPipelineAdapter<?> adapt(IPipeline object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IPipelineAdapter.class);
	}
}
