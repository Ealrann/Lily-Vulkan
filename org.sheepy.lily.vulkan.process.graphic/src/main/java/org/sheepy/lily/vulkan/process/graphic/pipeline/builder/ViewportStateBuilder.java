package org.sheepy.lily.vulkan.process.graphic.pipeline.builder;

import org.joml.Vector2ic;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineViewportStateCreateInfo;
import org.lwjgl.vulkan.VkRect2D;
import org.lwjgl.vulkan.VkViewport;
import org.sheepy.lily.game.api.graphic.IViewportAdapter;
import org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState;
import org.sheepy.vulkan.model.graphicpipeline.Scissor;
import org.sheepy.vulkan.model.graphicpipeline.StaticViewportState;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO;

public class ViewportStateBuilder
{
	private VkPipelineViewportStateCreateInfo viewportState;

	public VkPipelineViewportStateCreateInfo allocCreateInfo(MemoryStack stack,
															 Vector2ic swapExtent,
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

	private void fillStaticStateInfo(MemoryStack stack, Vector2ic swapExtent, StaticViewportState state)
	{
		// Viewports and scissors
		final VkViewport.Buffer viewports = VkViewport.callocStack(state.getViewports().size(), stack);
		for (final var viewport : state.getViewports())
		{
			final var adapter = viewport.adaptNotNull(IViewportAdapter.class);
			final var viewportInfo = adapter.getInfo(swapExtent);
			viewports.x(viewportInfo.xOffset);
			viewports.y(viewportInfo.yOffset);
			viewports.width(viewportInfo.width);
			viewports.height(viewportInfo.height);
			viewports.minDepth(viewportInfo.minDepth);
			viewports.maxDepth(viewportInfo.maxDepth);
			viewports.get();
		}
		viewports.flip();

		final VkRect2D.Buffer scissors = VkRect2D.callocStack(state.getScissors().size(), stack);
		for (final Scissor scissor : state.getScissors())
		{
			final int offsetX = scissor.getOffsetX();
			final int offsetY = scissor.getOffsetX();
			scissors.offset().set(offsetX, offsetY);

			final var extent = scissor.getExtent();
			if (extent == null)
			{
				scissors.extent().set(swapExtent.x(), swapExtent.y());
			}
			else
			{
				scissors.extent().set(extent.x(), extent.x());
			}

			scissors.get();
		}
		scissors.flip();

		viewportState.pViewports(viewports);
		viewportState.pScissors(scissors);
	}
}
