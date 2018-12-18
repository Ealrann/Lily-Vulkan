import org.sheepy.common.api.adapter.IAdapter;
import org.sheepy.vulkan.process.barrier.PipelineBufferBarrierAdapter;
import org.sheepy.vulkan.process.descriptor.BasicDescriptorSetAdapter;
import org.sheepy.vulkan.process.pipeline.PushConstantAdapter;

/**
 * 
 */
module org.sheepy.vulkan.process
{
	requires transitive org.sheepy.vulkan.common;
	requires transitive org.sheepy.vulkan.resource;

	exports org.sheepy.vulkan.process.barrier;
	exports org.sheepy.vulkan.process.descriptor;
	exports org.sheepy.vulkan.process.execution;
	exports org.sheepy.vulkan.process.pipeline;
	exports org.sheepy.vulkan.process.process;

	provides IAdapter
			with PipelineBufferBarrierAdapter, PushConstantAdapter, BasicDescriptorSetAdapter;
}
