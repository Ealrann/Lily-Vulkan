import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.process.compute.pipeline.ComputePipelineAdapter;
import org.sheepy.lily.vulkan.process.compute.pipeline.ComputerAdapter;
import org.sheepy.lily.vulkan.process.compute.process.ComputeProcessAdapter;

@Adapters(classifiers = {
		ComputeProcessAdapter.class, ComputePipelineAdapter.class, ComputerAdapter.class
})

module org.sheepy.lily.vulkan.process.compute
{
	requires transitive org.sheepy.lily.vulkan.process;

	exports org.sheepy.lily.vulkan.process.compute.execution;
	exports org.sheepy.lily.vulkan.process.compute.pipeline;
	exports org.sheepy.lily.vulkan.process.compute.process;
}
