import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.image.ImagePipelineAdapter;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicProcessAdapter;

/**
 * 
 */
module org.sheepy.lily.vulkan.process.graphic
{
	requires transitive org.sheepy.lily.vulkan.process;
	requires transitive org.sheepy.lily.vulkan.resource;
	requires transitive org.sheepy.lily.vulkan.api;

	exports org.sheepy.lily.vulkan.process.graphic.execution;
	exports org.sheepy.lily.vulkan.process.graphic.frame;
	exports org.sheepy.lily.vulkan.process.graphic.pipeline;
	exports org.sheepy.lily.vulkan.process.graphic.process;

	opens org.sheepy.lily.vulkan.process.graphic.pipeline.image to org.sheepy.lily.core.api;

	provides IAdapter with ImagePipelineAdapter, GraphicProcessAdapter;
}
