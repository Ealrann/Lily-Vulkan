import org.sheepy.common.api.adapter.IServiceAdapter;
import org.sheepy.vulkan.process.graphic.pipeline.image.ImagePipelineAdapter;
import org.sheepy.vulkan.process.graphic.pool.GraphicContextAdapter;
import org.sheepy.vulkan.process.graphic.pool.GraphicProcessPoolAdapter;
import org.sheepy.vulkan.process.graphic.process.GraphicProcessAdapter;

/**
 * 
 */
module org.sheepy.vulkan.process.graphic
{
	requires transitive org.sheepy.vulkan.process;

	exports org.sheepy.vulkan.process.graphic.execution;
	exports org.sheepy.vulkan.process.graphic.pipeline;
	exports org.sheepy.vulkan.process.graphic.pipeline.render;
	exports org.sheepy.vulkan.process.graphic.pool;
	exports org.sheepy.vulkan.process.graphic.process;

	exports org.sheepy.vulkan.model.process.graphic;
	exports org.sheepy.vulkan.model.process.graphic.impl;
	exports org.sheepy.vulkan.model.process.graphic.util;

	provides IServiceAdapter with GraphicProcessPoolAdapter, GraphicProcessAdapter,
			ImagePipelineAdapter, GraphicContextAdapter;
}
