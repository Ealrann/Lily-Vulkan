import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.process.compute.pipeline.ComputePipelineAdapter;
import org.sheepy.lily.vulkan.process.compute.pipeline.ComputerAdapter;
import org.sheepy.lily.vulkan.process.compute.process.ComputeProcessAdapter;

/**
 * 
 */
module org.sheepy.lily.vulkan.process.compute
{
	requires transitive org.sheepy.lily.vulkan.process;

	exports org.sheepy.lily.vulkan.process.compute.execution;
	exports org.sheepy.lily.vulkan.process.compute.pipeline;
	exports org.sheepy.lily.vulkan.process.compute.process;

	provides IAdapter with ComputeProcessAdapter, ComputePipelineAdapter, ComputerAdapter;
}
