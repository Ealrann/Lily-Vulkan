import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.process.Extenders;

module org.sheepy.lily.vulkan.process {
	requires transitive org.sheepy.lily.vulkan.api;
	requires transitive org.sheepy.lily.vulkan.core;

	exports org.sheepy.lily.vulkan.process.execution;
	exports org.sheepy.lily.vulkan.process.pipeline;
	exports org.sheepy.lily.vulkan.process.pipeline.task;
	exports org.sheepy.lily.vulkan.process.pipeline.builder;
	exports org.sheepy.lily.vulkan.process.process;

	opens org.sheepy.lily.vulkan.process.barrier;
	opens org.sheepy.lily.vulkan.process.pipeline;
	opens org.sheepy.lily.vulkan.process.pipeline.task;
	opens org.sheepy.lily.vulkan.process.process;

	provides IExtenderProvider with Extenders;
}
