import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.process.barrier.BufferBarrierAdapter;
import org.sheepy.lily.vulkan.process.barrier.CompositeBufferBarrierAdapter;
import org.sheepy.lily.vulkan.process.barrier.ImageBarrierAdapter;
import org.sheepy.lily.vulkan.process.barrier.ReferenceBufferBarrierAdapter;
import org.sheepy.lily.vulkan.process.barrier.ReferenceImageBarrierAdapter;
import org.sheepy.lily.vulkan.process.binding.BindingConfigurationAdapter;
import org.sheepy.lily.vulkan.process.binding.task.ConfigureBindAdapter;
import org.sheepy.lily.vulkan.process.binding.task.ConfigureCompositeBufferBarrierAdapter;
import org.sheepy.lily.vulkan.process.binding.task.ConfigurePrepareCompositeAdapter;
import org.sheepy.lily.vulkan.process.cadence.SwapBindingsTaskAdapter;
import org.sheepy.lily.vulkan.process.descriptor.DescriptorSetAdapter;
import org.sheepy.lily.vulkan.process.pipeline.PipelineAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.BindDescriptorSetsAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.CompositeTaskAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.CopyBufferTaskAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.FlushTransferBufferTaskAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.PipelineBarrierAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.PrepareCompositeTransferAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.PushConstantBufferAdapter;
import org.sheepy.lily.vulkan.process.pipeline.task.RotateConfigurationAdapter;

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
		FlushTransferBufferTaskAdapter.class,
		CopyBufferTaskAdapter.class,
		PrepareCompositeTransferAdapter.class,
		CompositeBufferBarrierAdapter.class,
		SwapBindingsTaskAdapter.class,
		RotateConfigurationAdapter.class,
		ConfigureBindAdapter.class,
		BindingConfigurationAdapter.class,
		ConfigureCompositeBufferBarrierAdapter.class,
		ConfigurePrepareCompositeAdapter.class
})

module org.sheepy.lily.vulkan.process
{
	requires transitive org.sheepy.lily.vulkan.api;

	requires org.sheepy.lily.vulkan.common;

	exports org.sheepy.lily.vulkan.process.execution;
	exports org.sheepy.lily.vulkan.process.pipeline;
	exports org.sheepy.lily.vulkan.process.pipeline.task;
	exports org.sheepy.lily.vulkan.process.process;

	opens org.sheepy.lily.vulkan.process.cadence;
	opens org.sheepy.lily.vulkan.process.barrier;
	opens org.sheepy.lily.vulkan.process.binding;
	opens org.sheepy.lily.vulkan.process.binding.task;
	opens org.sheepy.lily.vulkan.process.descriptor;
	opens org.sheepy.lily.vulkan.process.pipeline;
	opens org.sheepy.lily.vulkan.process.pipeline.task;
	opens org.sheepy.lily.vulkan.process.process;
}
