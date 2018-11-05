package org.sheepy.vulkan.pipeline.graphic;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.execution.graphic.GraphicCommandBuffer;
import org.sheepy.vulkan.model.process.GraphicsPipeline;
import org.sheepy.vulkan.pipeline.IProcessUnitAdapter;

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
