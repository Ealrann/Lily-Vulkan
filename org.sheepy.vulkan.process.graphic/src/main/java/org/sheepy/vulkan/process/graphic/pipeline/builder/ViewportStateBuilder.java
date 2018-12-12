package org.sheepy.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO;

import org.lwjgl.vulkan.VkPipelineViewportStateCreateInfo;
import org.lwjgl.vulkan.VkRect2D;
import org.lwjgl.vulkan.VkViewport;
import org.sheepy.common.api.types.SVector2i;
import org.sheepy.vulkan.model.process.graphic.DynamicViewportState;
import org.sheepy.vulkan.model.process.graphic.Scissor;
import org.sheepy.vulkan.model.process.graphic.StaticViewportState;
import org.sheepy.vulkan.model.process.graphic.Viewport;
import org.sheepy.vulkan.model.process.graphic.ViewportState;
import org.sheepy.vulkan.process.graphic.swapchain.SwapChainManager;
import org.sheepy.vulkan.process.graphic.swapchain.SwapChainManager.Extent2D;

public class ViewportStateBuilder
{

	private VkPipelineViewportStateCreateInfo viewportState;
	private VkViewport.Buffer viewports;
	private VkRect2D.Buffer scissors;

	public VkPipelineViewportStateCreateInfo allocCreateInfo(	SwapChainManager swapChainManager,
																ViewportState vState)
	{
		viewportState = VkPipelineViewportStateCreateInfo.calloc();
		viewportState.sType(VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO);

		if (vState instanceof StaticViewportState)
		{
			var state = (StaticViewportState) vState;
			fillStaticStateInfo(swapChainManager, state);
		}
		else if (vState instanceof DynamicViewportState)
		{
			var state = (DynamicViewportState) vState;
			fillDynamicStateInfo(state);
		}

		return viewportState;
	}

	private void fillDynamicStateInfo(DynamicViewportState state)
	{
		viewportState.scissorCount(state.getScissorCount());
		viewportState.viewportCount(state.getViewportCount());
	}

	private void fillStaticStateInfo(SwapChainManager swapChainManager, StaticViewportState state)
	{
		// Viewports and scissors
		Extent2D swapExtent = swapChainManager.getExtent();
		viewports = VkViewport.calloc(state.getViewports().size());
		for (Viewport viewport : state.getViewports())
		{
			SVector2i offset = viewport.getOffset();
			viewports.x(offset.x);
			viewports.y(offset.y);

			SVector2i extent = viewport.getExtent();
			if (extent == null)
			{
				viewports.width(swapExtent.getWidth());
				viewports.height(swapExtent.getHeight());
			}
			else
			{
				viewports.width(extent.getX());
				viewports.height(extent.getY());
			}

			viewports.minDepth(viewport.getMinDepth());
			viewports.maxDepth(viewport.getMaxDepth());

			viewports.get();
		}
		viewports.flip();

		scissors = VkRect2D.calloc(state.getScissors().size());
		for (Scissor scissor : state.getScissors())
		{
			SVector2i offset = scissor.getOffset();
			scissors.offset().set(offset.x, offset.y);

			var extent = scissor.getExtent();
			if (extent == null)
			{
				scissors.extent().set(swapExtent.getWidth(), swapExtent.getHeight());
			}
			else
			{
				scissors.extent().set(extent.getX(), extent.getY());
			}

			scissors.get();
		}
		scissors.flip();

		viewportState.pViewports(viewports);
		viewportState.pScissors(scissors);
	}

	public void freeViewportStateCreateInfo()
	{
		viewportState.free();

		if (scissors != null) scissors.free();
		if (viewports != null) viewports.free();
		scissors = null;
		viewports = null;
	}
}
