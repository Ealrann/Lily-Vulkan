import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.process.barrier.BufferBarrierAdapter;
import org.sheepy.lily.vulkan.process.barrier.ImageBarrierAdapter;
import org.sheepy.lily.vulkan.process.barrier.ReferenceBufferBarrierAdapter;
import org.sheepy.lily.vulkan.process.barrier.ReferenceImageBarrierAdapter;
import org.sheepy.lily.vulkan.process.descriptor.DescriptorSetAdapter;
import org.sheepy.lily.vulkan.process.pipeline.PipelineAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.BindDescriptorSetsAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.CompositeTaskAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.PipelineBarrierAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.PushBufferTaskAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.PushConstantBufferAdapter;

@Adapters(classifiers = {
		PipelineBarrierAdapter.class,
		PushConstantBufferAdapter.class,
		DescriptorSetAdapter.class,
		ReferenceBufferBarrierAdapter.class,
		ReferenceImageBarrierAdapter.class,
		BufferBarrierAdapter.class,
		ImageBarrierAdapter.class,
		PipelineAdapter.class,
		BindDescriptorSetsAdapter.class,
		CompositeTaskAdapter.class,
		PushBufferTaskAdapter.class
})

module org.sheepy.lily.vulkan.process
{
	requires transitive org.sheepy.lily.vulkan.api;

	requires org.sheepy.lily.vulkan.common;

	exports org.sheepy.lily.vulkan.process.execution;
	exports org.sheepy.lily.vulkan.process.pipeline;
	exports org.sheepy.lily.vulkan.process.pipeline.task;
	exports org.sheepy.lily.vulkan.process.process;

	opens org.sheepy.lily.vulkan.process.descriptor;
	opens org.sheepy.lily.vulkan.process.barrier;
	opens org.sheepy.lily.vulkan.process.pipeline;
	opens org.sheepy.lily.vulkan.process.pipeline.task;
}
