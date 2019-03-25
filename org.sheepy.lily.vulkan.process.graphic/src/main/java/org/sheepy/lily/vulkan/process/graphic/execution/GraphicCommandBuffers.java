package org.sheepy.lily.vulkan.process.graphic.execution;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.process.execution.AbstractCommandBuffers;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicProcessAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

public class GraphicCommandBuffers extends AbstractCommandBuffers<RenderCommandBuffer>
{
	@Override
	protected List<RenderCommandBuffer> allocCommandBuffers(MemoryStack stack,
															ProcessContext context)
	{
		final List<RenderCommandBuffer> res = new ArrayList<>();

		final var graphicContext = (GraphicContext) context;
		final var framebuffers = graphicContext.framebuffers;

		for (int i = 0; i < framebuffers.getIDs().size(); i++)
		{
			final var commandBuffer = new RenderCommandBuffer(i);
			res.add(commandBuffer);
		}

		return List.copyOf(res);
	}

	public void recordCommands(GraphicContext context)
	{
		for (int i = 0; i < commandBuffers.size(); i++)
		{
			final var commandBuffer = commandBuffers.get(i);
			final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();

			commandBuffer.startCommand();

			final var adapter = GraphicProcessAdapter.adapt(context.graphicProcess);
			adapter.recordCommand(vkCommandBuffer, ECommandStage.PRE_RENDER, i);

			commandBuffer.startRenderPass();

			adapter.recordCommand(vkCommandBuffer, ECommandStage.RENDER, i);

			commandBuffer.endRenderPass();

			adapter.recordCommand(vkCommandBuffer, ECommandStage.POST_RENDER, i);

			commandBuffer.endCommand();
		}
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		return graphicContext.framebuffers.isAllocationDirty(context);
	}
}
