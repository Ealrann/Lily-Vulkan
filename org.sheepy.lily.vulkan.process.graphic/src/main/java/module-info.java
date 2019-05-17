import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.process.graphic.barrier.SwapImageBarrierAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.BindIndexBufferAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.BindVertexBuferAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.BlitToSwapImageAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.DrawIndexedAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.SetScissorAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.SetViewportAdapter;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicProcessAdapter;
import org.sheepy.lily.vulkan.process.graphic.resource.DepthAttachmentAdapter;
import org.sheepy.lily.vulkan.process.graphic.resource.IndexedVertexDescriptorAdapter;
import org.sheepy.lily.vulkan.process.graphic.resource.VertexDescriptorAdapter;

@Adapters(classifiers = {
		GraphicProcessAdapter.class,
		GraphicsPipelineAdapter.class,
		DepthAttachmentAdapter.class,
		SwapImageBarrierAdapter.class,
		BlitToSwapImageAdapter.class,
		VertexDescriptorAdapter.class,
		IndexedVertexDescriptorAdapter.class,
		DrawIndexedAdapter.class,
		BindIndexBufferAdapter.class,
		BindVertexBuferAdapter.class,
		SetScissorAdapter.class,
		SetViewportAdapter.class,
})

module org.sheepy.lily.vulkan.process.graphic
{
	requires transitive org.sheepy.lily.vulkan.process;
	requires transitive org.sheepy.lily.vulkan.resource;
	requires transitive org.sheepy.lily.vulkan.api;

	exports org.sheepy.lily.vulkan.process.graphic.pipeline;

	opens org.sheepy.lily.vulkan.process.graphic.barrier;
	opens org.sheepy.lily.vulkan.process.graphic.frame;
	opens org.sheepy.lily.vulkan.process.graphic.execution;
	opens org.sheepy.lily.vulkan.process.graphic.pipeline.task;
	opens org.sheepy.lily.vulkan.process.graphic.process;
	opens org.sheepy.lily.vulkan.process.graphic.resource;
}
