import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.process.graphic.Adapters;

module org.sheepy.lily.vulkan.process.graphic
{
	requires transitive org.sheepy.lily.vulkan.api;

	requires org.sheepy.lily.vulkan.core;
	requires org.sheepy.lily.vulkan.process;

	exports org.sheepy.lily.vulkan.process.graphic.pipeline;

	opens org.sheepy.lily.vulkan.process.graphic.barrier;
	opens org.sheepy.lily.vulkan.process.graphic.frame;
	opens org.sheepy.lily.vulkan.process.graphic.execution;
	opens org.sheepy.lily.vulkan.process.graphic.pipeline;
	opens org.sheepy.lily.vulkan.process.graphic.pipeline.task;
	opens org.sheepy.lily.vulkan.process.graphic.process;
	opens org.sheepy.lily.vulkan.process.graphic.resource;
	opens org.sheepy.lily.vulkan.process.graphic.scene;

	provides IAdapterProvider with Adapters;
}
