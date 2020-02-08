package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineViewportStateCreateInfo;
import org.lwjgl.vulkan.VkRect2D;
import org.lwjgl.vulkan.VkViewport;
import org.sheepy.lily.vulkan.core.window.Extent2D;
import org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState;
import org.sheepy.vulkan.model.graphicpipeline.Scissor;
import org.sheepy.vulkan.model.graphicpipeline.StaticViewportState;
import org.sheepy.vulkan.model.graphicpipeline.Vec2I;
import org.sheepy.vulkan.model.graphicpipeline.Viewport;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;

public class ViewportStateBuilder
{
	private VkPipelineViewportStateCreateInfo viewportState;
	private VkViewport.Buffer viewports;
	private VkRect2D.Buffer scissors;

	public VkPipelineViewportStateCreateInfo allocCreateInfo(	MemoryStack stack,
																Extent2D swapExtent,
																ViewportState vState)
	{
		viewportState = VkPipelineViewportStateCreateInfo.callocStack(stack);
		viewportState.sType(VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO);

		if (vState instanceof StaticViewportState)
		{
			final var state = (StaticViewportState) vState;
			fillStaticStateInfo(stack, swapExtent, state);
		}
		else if (vState instanceof DynamicViewportState)
		{
			final var state = (DynamicViewportState) vState;
			fillDynamicStateInfo(state);
		}

		return viewportState;
	}

	private void fillDynamicStateInfo(DynamicViewportState state)
	{
		viewportState.scissorCount(state.getScissorCount());
		viewportState.viewportCount(state.getViewportCount());
	}

	private void fillStaticStateInfo(	MemoryStack stack,
										Extent2D swapExtent,
										StaticViewportState state)
	{
		// Viewports and scissors
		viewports = VkViewport.callocStack(state.getViewports().size(), stack);
		for (final Viewport viewport : state.getViewports())
		{
			final int offsetX = viewport.getOffsetX();
			final int offsetY = viewport.getOffsetX();
			viewports.x(offsetX);
			viewports.y(offsetY);

			final Vec2I extent = viewport.getExtent();
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

		scissors = VkRect2D.callocStack(state.getScissors().size(), stack);
		for (final Scissor scissor : state.getScissors())
		{
			final int offsetX = scissor.getOffsetX();
			final int offsetY = scissor.getOffsetX();
			scissors.offset().set(offsetX, offsetY);

			final var extent = scissor.getExtent();
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
}
