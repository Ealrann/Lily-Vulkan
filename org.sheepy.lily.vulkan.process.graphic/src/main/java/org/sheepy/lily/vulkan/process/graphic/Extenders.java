package org.sheepy.lily.vulkan.process.graphic;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.process.graphic.barrier.SwapImageBarrierAdapter;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicExecutionRecorders;
import org.sheepy.lily.vulkan.process.graphic.frame.FramebufferAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAllocation;
import org.sheepy.lily.vulkan.process.graphic.pipeline.SubpassRecordableAllocation;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.*;
import org.sheepy.lily.vulkan.process.graphic.pipeline.viewport.CinemaViewportAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.viewport.ViewportAdapter;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicProcessAdapter;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.lily.vulkan.process.graphic.resource.AttachmentDescriptorAllocation;
import org.sheepy.lily.vulkan.process.graphic.resource.ColorAttachmentAllocation;
import org.sheepy.lily.vulkan.process.graphic.resource.DepthAttachmentAllocation;
import org.sheepy.lily.vulkan.process.graphic.resource.SwapImageAttachmentAdapter;
import org.sheepy.lily.vulkan.process.graphic.scene.BackgroundImageSubpassProvider;
import org.sheepy.lily.vulkan.process.graphic.scene.ScreenEffectSubpassProvider;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(GraphicProcessAdapter.class,
					   GraphicsPipelineAllocation.class,
					   DepthAttachmentAllocation.class,
					   SwapImageBarrierAdapter.class,
					   BlitToSwapImageAllocation.class,
					   BlitTaskAllocation.class,
					   DrawIndexedAdapter.class,
					   DrawAdapter.class,
					   BindIndexBufferAdapter.class,
					   BindVertexBuferAdapter.class,
					   SetScissorAdapter.class,
					   SetViewportAdapter.class,
					   SwapImageAttachmentAdapter.class,
					   BackgroundImageSubpassProvider.class,
					   ScreenEffectSubpassProvider.class,
					   AttachmentDescriptorAllocation.class,
					   ColorAttachmentAllocation.class,
					   ViewportAdapter.class,
					   CinemaViewportAdapter.class,
					   PhysicalSurfaceAllocation.class,
					   SwapChainAllocation.class,
					   RenderPassAllocation.class,
					   ImageViewAllocation.class,
					   FramebufferAllocation.class,
					   GraphicExecutionRecorders.class,
					   SubpassRecordableAllocation.class);
	}
}
