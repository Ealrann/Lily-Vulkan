package org.sheepy.lily.vulkan.api.nativehelper.pipeline.builder;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO;

import org.joml.Vector2i;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineViewportStateCreateInfo;
import org.lwjgl.vulkan.VkRect2D;
import org.lwjgl.vulkan.VkViewport;
import org.sheepy.lily.vulkan.api.nativehelper.Extent2D;
import org.sheepy.lily.vulkan.model.process.graphic.DynamicViewportState;
import org.sheepy.lily.vulkan.model.process.graphic.Scissor;
import org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState;
import org.sheepy.lily.vulkan.model.process.graphic.Viewport;
import org.sheepy.lily.vulkan.model.process.graphic.ViewportState;

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
			final Vector2i offset = viewport.getOffset();
			viewports.x(offset.x);
			viewports.y(offset.y);

			final Vector2i extent = viewport.getExtent();
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

		scissors = VkRect2D.callocStack(state.getScissors().size(), stack);
		for (final Scissor scissor : state.getScissors())
		{
			final Vector2i offset = scissor.getOffset();
			scissors.offset().set(offset.x, offset.y);

			final var extent = scissor.getExtent();
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
}