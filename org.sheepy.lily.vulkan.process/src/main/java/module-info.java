import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.process.Adapters;

module org.sheepy.lily.vulkan.process
{
	requires transitive org.sheepy.lily.vulkan.api;
	requires transitive org.sheepy.lily.vulkan.common;

	exports org.sheepy.lily.vulkan.process.execution;
	exports org.sheepy.lily.vulkan.process.pipeline;
	exports org.sheepy.lily.vulkan.process.pipeline.task;
	exports org.sheepy.lily.vulkan.process.pipeline.builder;
	exports org.sheepy.lily.vulkan.process.process;

	opens org.sheepy.lily.vulkan.process.cadence;
	opens org.sheepy.lily.vulkan.process.barrier;
	opens org.sheepy.lily.vulkan.process.binding;
	opens org.sheepy.lily.vulkan.process.binding.task;
	opens org.sheepy.lily.vulkan.process.descriptor;
	opens org.sheepy.lily.vulkan.process.pipeline;
	opens org.sheepy.lily.vulkan.process.pipeline.task;
	opens org.sheepy.lily.vulkan.process.process;

	provides IAdapterProvider with Adapters;
}
