import org.sheepy.common.api.adapter.IAdapter;
import org.sheepy.vulkan.process.compute.pipeline.ComputePipelineAdapter;
import org.sheepy.vulkan.process.compute.pipeline.ComputerAdapter;
import org.sheepy.vulkan.process.compute.process.ComputeContextAdapter;
import org.sheepy.vulkan.process.compute.process.ComputeProcessAdapter;

/**
 * 
 */
module org.sheepy.vulkan.process.compute
{
	requires transitive org.sheepy.vulkan.process;

	exports org.sheepy.vulkan.model.process.compute;
	exports org.sheepy.vulkan.model.process.compute.impl;
	exports org.sheepy.vulkan.model.process.compute.util;

	exports org.sheepy.vulkan.process.compute.execution;
	exports org.sheepy.vulkan.process.compute.pipeline;
	exports org.sheepy.vulkan.process.compute.process;

	provides IAdapter with ComputeProcessAdapter, ComputePipelineAdapter, ComputerAdapter,
			ComputeContextAdapter;
}
