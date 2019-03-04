package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO;

import org.joml.Vector2i;
import org.lwjgl.vulkan.VkPipelineViewportStateCreateInfo;
import org.lwjgl.vulkan.VkRect2D;
import org.lwjgl.vulkan.VkViewport;
import org.sheepy.lily.vulkan.model.process.graphic.DynamicViewportState;
import org.sheepy.lily.vulkan.model.process.graphic.Scissor;
import org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState;
import org.sheepy.lily.vulkan.model.process.graphic.Viewport;
import org.sheepy.lily.vulkan.model.process.graphic.ViewportState;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalDeviceSurfaceManager;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalDeviceSurfaceManager.Extent2D;

public class ViewportStateBuilder
{

	private VkPipelineViewportStateCreateInfo viewportState;
	private VkViewport.Buffer viewports;
	private VkRect2D.Buffer scissors;

	public VkPipelineViewportStateCreateInfo allocCreateInfo(	PhysicalDeviceSurfaceManager surfaceManager,
																ViewportState vState)
	{
		viewportState = VkPipelineViewportStateCreateInfo.calloc();
		viewportState.sType(VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO);

		if (vState instanceof StaticViewportState)
		{
			var state = (StaticViewportState) vState;
			fillStaticStateInfo(surfaceManager, state);
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

	private void fillStaticStateInfo(	PhysicalDeviceSurfaceManager surfaceManager,
										StaticViewportState state)
	{
		// Viewports and scissors
		Extent2D swapExtent = surfaceManager.getExtent();
		viewports = VkViewport.calloc(state.getViewports().size());
		for (Viewport viewport : state.getViewports())
		{
			Vector2i offset = viewport.getOffset();
			viewports.x(offset.x);
			viewports.y(offset.y);

			Vector2i extent = viewport.getExtent();
			if (extent == null)
			{
				viewports.width(swapExtent.getWidth());
				viewports.height(swapExtent.getHeight());
			}
			else
			{
				viewports.width(extent.x);
				viewports.height(extent.y);
			}

			viewports.minDepth(viewport.getMinDepth());
			viewports.maxDepth(viewport.getMaxDepth());

			viewports.get();
		}
		viewports.flip();

		scissors = VkRect2D.calloc(state.getScissors().size());
		for (Scissor scissor : state.getScissors())
		{
			Vector2i offset = scissor.getOffset();
			scissors.offset().set(offset.x, offset.y);

			var extent = scissor.getExtent();
			if (extent == null)
			{
				scissors.extent().set(swapExtent.getWidth(), swapExtent.getHeight());
			}
			else
			{
				scissors.extent().set(extent.x, extent.y);
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
