package org.sheepy.vulkan.process.graphic.pipeline;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.vulkan.process.graphic.execution.GraphicCommandBuffer;
import org.sheepy.vulkan.process.pipeline.IProcessUnitAdapter;

/**
 *
 */
public interface IGraphicPipelineAdapter extends IProcessUnitAdapter<GraphicCommandBuffer>
{
	static IGraphicPipelineAdapter adapt(GraphicsPipeline object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IGraphicPipelineAdapter.class);
	}
}
