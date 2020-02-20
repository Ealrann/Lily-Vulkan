package org.sheepy.lily.vulkan.process.graphic;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.process.graphic.barrier.SwapImageBarrierAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.*;
import org.sheepy.lily.vulkan.process.graphic.pipeline.viewport.CinemaViewportAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.viewport.ViewportAdapter;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicProcessAdapter;
import org.sheepy.lily.vulkan.process.graphic.resource.AttachmentDescriptorAdapter;
import org.sheepy.lily.vulkan.process.graphic.resource.ColorAttachmentAdapter;
import org.sheepy.lily.vulkan.process.graphic.resource.DepthAttachmentAdapter;
import org.sheepy.lily.vulkan.process.graphic.resource.SwapImageAttachmentAdapter;
import org.sheepy.lily.vulkan.process.graphic.scene.BackgroundImageSubpassProvider;
import org.sheepy.lily.vulkan.process.graphic.scene.ScreenEffectSubpassProvider;

import java.util.List;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(GraphicProcessAdapter.class,
					   GraphicsPipelineAdapter.class,
					   DepthAttachmentAdapter.class,
					   SwapImageBarrierAdapter.class,
					   BlitToSwapImageAdapter.class,
					   BlitTaskAdapter.class,
					   DrawIndexedAdapter.class,
					   DrawAdapter.class,
					   BindIndexBufferAdapter.class,
					   BindVertexBuferAdapter.class,
					   SetScissorAdapter.class,
					   SetViewportAdapter.class,
					   SwapImageAttachmentAdapter.class,
					   BackgroundImageSubpassProvider.class,
					   ScreenEffectSubpassProvider.class,
					   AttachmentDescriptorAdapter.class,
					   ColorAttachmentAdapter.class,
					   ViewportAdapter.class,
					   CinemaViewportAdapter.class);
	}
}
