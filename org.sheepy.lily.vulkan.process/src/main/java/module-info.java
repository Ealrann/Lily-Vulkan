import org.logoce.lmf.core.api.extender.IAdapterProvider;
import org.sheepy.lily.vulkan.process.Extenders;

module org.sheepy.lily.vulkan.process
{
	requires transitive org.sheepy.lily.vulkan.api;
	requires org.sheepy.lily.vulkan.core;

	exports org.sheepy.lily.vulkan.process.execution;
	exports org.sheepy.lily.vulkan.process.execution.util;
	exports org.sheepy.lily.vulkan.process.pipeline.builder;
	exports org.sheepy.lily.vulkan.process.process;

	opens org.sheepy.lily.vulkan.process.barrier;
	opens org.sheepy.lily.vulkan.process.execution;
	opens org.sheepy.lily.vulkan.process.pipeline;
	opens org.sheepy.lily.vulkan.process.pipeline.task;

	provides IAdapterProvider with Extenders;
}
