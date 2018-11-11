import org.sheepy.common.api.adapter.IServiceAdapter;
import org.sheepy.vulkan.process.compute.pipeline.ComputePipelineAdapter;
import org.sheepy.vulkan.process.compute.pipeline.ComputerAdapter;
import org.sheepy.vulkan.process.compute.pool.ComputeContextAdapter;
import org.sheepy.vulkan.process.compute.pool.ComputeProcessPoolAdapter;
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

	provides IServiceAdapter with ComputeProcessPoolAdapter, ComputeProcessAdapter,
			ComputePipelineAdapter, ComputerAdapter, ComputeContextAdapter;
}