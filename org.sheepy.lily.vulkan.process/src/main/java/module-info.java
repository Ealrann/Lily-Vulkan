import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.process.barrier.PipelineBarrierAdapter;
import org.sheepy.lily.vulkan.process.descriptor.DescriptorSetAdapter;
import org.sheepy.lily.vulkan.process.pipeline.PushConstantAdapter;

@Adapters(classifiers = {
		PipelineBarrierAdapter.class, PushConstantAdapter.class, DescriptorSetAdapter.class
})

module org.sheepy.lily.vulkan.process
{
	requires transitive org.sheepy.lily.vulkan.common;
	requires transitive org.sheepy.lily.vulkan.resource;

	exports org.sheepy.lily.vulkan.process.barrier;
	exports org.sheepy.lily.vulkan.process.descriptor;
	exports org.sheepy.lily.vulkan.process.execution;
	exports org.sheepy.lily.vulkan.process.pipeline;
	exports org.sheepy.lily.vulkan.process.process;
}
