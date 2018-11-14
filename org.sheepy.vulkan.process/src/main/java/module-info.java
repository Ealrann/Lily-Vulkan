import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.vulkan.process.pool.ExecutionManagerAdapter;
import org.sheepy.vulkan.process.pool.ResourceManagerAdapter;

/**
 * 
 */
module org.sheepy.vulkan.process
{
	requires transitive org.sheepy.vulkan.common;
	requires transitive org.sheepy.vulkan.resource;

	exports org.sheepy.vulkan.process.barrier;
	exports org.sheepy.vulkan.process.execution;
	exports org.sheepy.vulkan.process.pipeline;
	exports org.sheepy.vulkan.process.pool;
	exports org.sheepy.vulkan.process.process;

	exports org.sheepy.vulkan.model.process;
	exports org.sheepy.vulkan.model.process.impl;
	exports org.sheepy.vulkan.model.process.util;

	provides ISingletonAdapter
			with ExecutionManagerAdapter, ResourceManagerAdapter;
}