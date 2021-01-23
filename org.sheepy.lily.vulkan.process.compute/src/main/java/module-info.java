import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.process.compute.Extenders;

module org.sheepy.lily.vulkan.process.compute {
	requires transitive org.sheepy.lily.vulkan.api;

	requires org.sheepy.lily.vulkan.core;
	requires org.sheepy.lily.vulkan.process;

	opens org.sheepy.lily.vulkan.process.compute.execution;
	opens org.sheepy.lily.vulkan.process.compute.pipeline;
	opens org.sheepy.lily.vulkan.process.compute.process;

	provides IAdapterProvider with Extenders;
}
