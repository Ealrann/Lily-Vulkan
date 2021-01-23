package org.sheepy.lily.vulkan.process.graphic;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.process.graphic.barrier.SwapImageBarrierAllocation;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicExecutionRecorderAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.FramebufferAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.graphic.pipeline.*;
import org.sheepy.lily.vulkan.process.graphic.pipeline.task.*;
import org.sheepy.lily.vulkan.process.graphic.pipeline.viewport.CinemaViewportAdapter;
import org.sheepy.lily.vulkan.process.graphic.pipeline.viewport.ViewportAdapter;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicConfigurationAllocation;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicProcessAdapter;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicProcessAllocation;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.lily.vulkan.process.graphic.resource.ColorAttachmentAllocation;
import org.sheepy.lily.vulkan.process.graphic.resource.DepthAttachmentAllocation;
import org.sheepy.lily.vulkan.process.graphic.scene.BackgroundImageSubpassProvider;
import org.sheepy.lily.vulkan.process.graphic.scene.ScreenEffectSubpassProvider;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Extenders implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(GraphicProcessAllocation.class,
					   GraphicProcessAdapter.class,
					   GraphicsPipelineAllocationNode.class,
					   GraphicsPipelineAllocation.class,
					   GraphicsPipelineRecorder.class,
					   DepthAttachmentAllocation.class,
					   SwapImageBarrierAllocation.class,
					   BlitToSwapImageRecorder.class,
					   BlitTaskRecorder.class,
					   DrawIndexedRecorder.class,
					   DrawRecorder.class,
					   BindIndexBufferRecorder.class,
					   BindVertexBuferRecorder.class,
					   SetScissorRecorder.class,
					   SetViewportAdapter.class,
					   BackgroundImageSubpassProvider.class,
					   ScreenEffectSubpassProvider.class,
					   ColorAttachmentAllocation.class,
					   ViewportAdapter.class,
					   CinemaViewportAdapter.class,
					   PhysicalSurfaceAllocation.class,
					   SwapChainAllocation.class,
					   RenderPassAllocation.class,
					   ImageViewAllocation.class,
					   FramebufferAllocation.class,
					   GraphicExecutionManagerAllocation.class,
					   GraphicExecutionRecorderAllocation.class,
					   GraphicConfigurationAllocation.class,
					   SubpassAllocation.class,
					   SubpassRecorder.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
