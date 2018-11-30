package org.sheepy.vulkan.process.graphic.execution;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.process.execution.AbstractCommandBuffers;
import org.sheepy.vulkan.process.graphic.pool.GraphicContext;
import org.sheepy.vulkan.process.graphic.process.GraphicProcessAdapter;

public class GraphicCommandBuffers extends AbstractCommandBuffers<RenderCommandBuffer>
{
	private final GraphicContext context;

	public GraphicCommandBuffers(GraphicContext context)
	{
		super(context.getVkDevice(), context.executionManager.commandPool);
		this.context = context;
	}

	@Override
	protected List<RenderCommandBuffer> allocCommandBuffers(MemoryStack stack)
	{
		final var framebuffers = context.framebuffers;

		final long commandPoolId = commandPool.getId();

		// Command Pool Buffers
		// ------------------
		final long[] commandBufferIds = allocCommandBuffers(commandPoolId, framebuffers.size());

		final List<RenderCommandBuffer> commandBuffers = new ArrayList<>();
		for (int i = 0; i < framebuffers.getIDs().size(); i++)
		{
			final Long framebufferId = framebuffers.getIDs().get(i);
			final long commandBufferId = commandBufferIds[i];

			commandBuffers.add(new RenderCommandBuffer(context, i, commandBufferId, framebufferId));
		}

		return List.copyOf(commandBuffers);
	}

	public void recordCommands(GraphicContext context)
	{
		for (int i = 0; i < commandBuffers.size(); i++)
		{
			final RenderCommandBuffer commandBuffer = commandBuffers.get(i);

			commandBuffer.startCommand();

			final List<GraphicProcessAdapter> adapters = new ArrayList<>();

			for (final AbstractProcess graphicProcess : context.graphicProcessPool.getProcesses())
			{
				adapters.add(GraphicProcessAdapter.adapt((GraphicProcess) graphicProcess));
			}

			for (final GraphicProcessAdapter adapter : adapters)
			{
				adapter.recordCommand(commandBuffer, ECommandStage.PRE_RENDER);
			}

			commandBuffer.startRenderPass();

			for (final GraphicProcessAdapter adapter : adapters)
			{
				adapter.recordCommand(commandBuffer, ECommandStage.RENDER);
			}

			commandBuffer.endRenderPass();

			for (final GraphicProcessAdapter adapter : adapters)
			{
				adapter.recordCommand(commandBuffer, ECommandStage.POST_RENDER);
			}

			commandBuffer.endCommand();
		}
	}

	@Override
	public boolean isAllocationDirty()
	{
		return context.framebuffers.isAllocationDirty();
	}
}
