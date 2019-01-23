import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.process.barrier.PipelineBarrierAdapter;
import org.sheepy.lily.vulkan.process.descriptor.DescriptorSetAdapter;
import org.sheepy.lily.vulkan.process.pipeline.PushConstantAdapter;

/**
 * 
 */
module org.sheepy.lily.vulkan.process
{
	requires transitive org.sheepy.lily.vulkan.common;
	requires transitive org.sheepy.lily.vulkan.resource;

	exports org.sheepy.lily.vulkan.process.barrier;
	exports org.sheepy.lily.vulkan.process.descriptor;
	exports org.sheepy.lily.vulkan.process.execution;
	exports org.sheepy.lily.vulkan.process.pipeline;
	exports org.sheepy.lily.vulkan.process.process;

	provides IAdapter with PipelineBarrierAdapter, PushConstantAdapter, DescriptorSetAdapter;
}
