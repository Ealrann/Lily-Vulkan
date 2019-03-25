import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.image.ImagePipelineAdapter;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicProcessAdapter;

@Adapters(classifiers = {
		ImagePipelineAdapter.class, GraphicProcessAdapter.class, GraphicsPipelineAdapter.class
})

module org.sheepy.lily.vulkan.process.graphic
{
	requires transitive org.sheepy.lily.vulkan.process;
	requires transitive org.sheepy.lily.vulkan.resource;
	requires transitive org.sheepy.lily.vulkan.api;

	exports org.sheepy.lily.vulkan.process.graphic.api;
	exports org.sheepy.lily.vulkan.process.graphic.pipeline;

	opens org.sheepy.lily.vulkan.process.graphic.frame;
	opens org.sheepy.lily.vulkan.process.graphic.execution;
	opens org.sheepy.lily.vulkan.process.graphic.pipeline.image;
	opens org.sheepy.lily.vulkan.process.graphic.process;
}
