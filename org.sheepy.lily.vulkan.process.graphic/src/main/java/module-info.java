import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.process.graphic.barrier.SwapImageBarrierAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.BindIndexBufferAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.BindVertexBuferAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.BlitToSwapImageAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.DrawAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.DrawIndexedAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.SetScissorAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.SetViewportAdapter;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicProcessAdapter;
import org.sheepy.lily.vulkan.process.graphic.resource.DepthAttachmentAdapter;
import org.sheepy.lily.vulkan.process.graphic.scene.BackgroundImageSubpassProvider;

@Adapters(classifiers = {
		GraphicProcessAdapter.class,
		GraphicsPipelineAdapter.class,
		DepthAttachmentAdapter.class,
		SwapImageBarrierAdapter.class,
		BlitToSwapImageAdapter.class,
		DrawIndexedAdapter.class,
		DrawAdapter.class,
		BindIndexBufferAdapter.class,
		BindVertexBuferAdapter.class,
		SetScissorAdapter.class,
		SetViewportAdapter.class,
		BackgroundImageSubpassProvider.class
})

module org.sheepy.lily.vulkan.process.graphic
{
	requires transitive org.sheepy.lily.vulkan.api;

	requires org.sheepy.lily.vulkan.common;
	requires org.sheepy.lily.vulkan.process;

	exports org.sheepy.lily.vulkan.process.graphic.pipeline;

	opens org.sheepy.lily.vulkan.process.graphic.barrier;
	opens org.sheepy.lily.vulkan.process.graphic.frame;
	opens org.sheepy.lily.vulkan.process.graphic.execution;
	opens org.sheepy.lily.vulkan.process.graphic.pipeline;
	opens org.sheepy.lily.vulkan.process.graphic.pipeline.task;
	opens org.sheepy.lily.vulkan.process.graphic.process;
	opens org.sheepy.lily.vulkan.process.graphic.resource;
	opens org.sheepy.lily.vulkan.process.graphic.scene;
}
