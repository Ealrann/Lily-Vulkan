package org.sheepy.vulkan.pipeline.graphic;

import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.execution.graphic.GraphicCommandBuffer;
import org.sheepy.vulkan.model.GraphicsPipeline;
import org.sheepy.vulkan.pipeline.IProcessUnitAdapter;

/**
 * @author ealrann
 *
 */
public interface IGraphicPipelineAdapter extends IProcessUnitAdapter<GraphicCommandBuffer>
{
	public static IGraphicPipelineAdapter adapt(GraphicsPipeline object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, IGraphicPipelineAdapter.class);
	}
}
