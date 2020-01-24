import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.process.compute.Adapters;

module org.sheepy.lily.vulkan.process.compute
{
	requires transitive org.sheepy.lily.vulkan.api;

	requires org.sheepy.lily.vulkan.common;
	requires org.sheepy.lily.vulkan.process;

	opens org.sheepy.lily.vulkan.process.compute.execution;
	opens org.sheepy.lily.vulkan.process.compute.pipeline;
	opens org.sheepy.lily.vulkan.process.compute.process;

	provides IAdapterProvider with Adapters;
}
