import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.vulkan.process.graphic.pipeline.image.ImagePipelineAdapter;
import org.sheepy.vulkan.process.graphic.process.GraphicContextAdapter;
import org.sheepy.vulkan.process.graphic.process.GraphicProcessAdapter;

/**
 * 
 */
module org.sheepy.vulkan.process.graphic
{
	requires transitive org.sheepy.vulkan.process;
	requires transitive org.sheepy.vulkan.resource;
	requires transitive org.sheepy.vulkan.api;

	exports org.sheepy.vulkan.process.graphic.execution;
	exports org.sheepy.vulkan.process.graphic.pipeline;
	exports org.sheepy.vulkan.process.graphic.process;
	exports org.sheepy.vulkan.process.graphic.swapchain;
	exports org.sheepy.vulkan.process.graphic.view;

	exports org.sheepy.vulkan.model.process.graphic;
	exports org.sheepy.vulkan.model.process.graphic.impl;
	exports org.sheepy.vulkan.model.process.graphic.util;

	opens org.sheepy.vulkan.process.graphic.pipeline.image;

	provides ISingletonAdapter
			with GraphicProcessAdapter, ImagePipelineAdapter, GraphicContextAdapter;
}
