package org.sheepy.lily.vulkan.process.graphic;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
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

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(	GraphicProcessAdapter.class,
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
						BackgroundImageSubpassProvider.class);
	}
}
