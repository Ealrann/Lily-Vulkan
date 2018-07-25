package org.sheepy.vulkan.command.graphic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.AbstractCommandBuffers;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.ECommandStage;
import org.sheepy.vulkan.pipeline.graphic.Framebuffers;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcess;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcessPool;
import org.sheepy.vulkan.pipeline.graphic.IRenderPass;
import org.sheepy.vulkan.swapchain.SwapChainManager;

public class GraphicCommandBuffers extends AbstractCommandBuffers<RenderCommandBuffer>
{

	private GraphicProcessPool processPool;

	public GraphicCommandBuffers(CommandPool commandPool, GraphicProcessPool processPool)
	{
		super(commandPool);
		this.processPool = processPool;
	}

	@Override
	protected List<RenderCommandBuffer> allocCommandBuffers(MemoryStack stack)
	{
		Framebuffers framebuffers = processPool.context.framebuffers;
		SwapChainManager swapChain = processPool.context.swapChainManager;
		IRenderPass renderPass = processPool.context.renderPass;

		long commandPoolId = commandPool.getId();

		// Command Pool Buffers
		// ------------------
		long[] commandBufferIds = allocCommandBuffers(commandPoolId, framebuffers.size());

		List<RenderCommandBuffer> commandBuffers = new ArrayList<>();
		for (int i = 0; i < framebuffers.getIDs().size(); i++)
		{
			Long framebufferId = framebuffers.getIDs().get(i);
			long commandBufferId = commandBufferIds[i];

			commandBuffers.add(new RenderCommandBuffer(logicalDevice, i, commandBufferId,
					processPool.configuration.depthBuffer, framebufferId, swapChain.getExtent(), renderPass));
		}

		return Collections.unmodifiableList(commandBuffers);
	}

	public void recordCommands()
	{
		for (int i = 0; i < commandBuffers.size(); i++)
		{
			RenderCommandBuffer commandBuffer = commandBuffers.get(i);

			commandBuffer.startCommand();

			for (GraphicProcess graphicProcess : processPool.getProcesses())
			{
				graphicProcess.recordCommand(commandBuffer, ECommandStage.PreRender);
			}

			commandBuffer.startRenderPass();

			for (GraphicProcess graphicProcess : processPool.getProcesses())
			{
				graphicProcess.recordCommand(commandBuffer, ECommandStage.Render);
			}

			commandBuffer.endRenderPass();

			for (GraphicProcess graphicProcess : processPool.getProcesses())
			{
				graphicProcess.recordCommand(commandBuffer, ECommandStage.PostRender);
			}

			commandBuffer.endCommand();
		}
	}
}
