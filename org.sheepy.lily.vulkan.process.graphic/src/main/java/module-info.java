import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.process.graphic.Extenders;

module org.sheepy.lily.vulkan.process.graphic {
	requires transitive org.sheepy.lily.vulkan.api;

	requires org.sheepy.lily.vulkan.core;
	requires org.sheepy.lily.vulkan.process;

	opens org.sheepy.lily.vulkan.process.graphic.barrier;
	opens org.sheepy.lily.vulkan.process.graphic.frame;
	opens org.sheepy.lily.vulkan.process.graphic.execution;
	opens org.sheepy.lily.vulkan.process.graphic.pipeline;
	opens org.sheepy.lily.vulkan.process.graphic.pipeline.task;
	opens org.sheepy.lily.vulkan.process.graphic.pipeline.viewport;
	opens org.sheepy.lily.vulkan.process.graphic.process;
	opens org.sheepy.lily.vulkan.process.graphic.resource;
	opens org.sheepy.lily.vulkan.process.graphic.scene;

	provides IExtenderProvider with Extenders;
}
