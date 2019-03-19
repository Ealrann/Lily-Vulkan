package org.sheepy.lily.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.execution.ISingleTimeCommand;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicCommandBuffers;
import org.sheepy.lily.vulkan.process.graphic.execution.RenderCommandBuffer;
import org.sheepy.lily.vulkan.process.graphic.pipeline.IGraphicsPipelineAdapter;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@Statefull
@Adapter(scope = GraphicProcess.class)
public class GraphicProcessAdapter extends AbstractProcessAdapter<RenderCommandBuffer>
{
	private static final String FAILED_ACQUIRE_IMAGE = "Failed to acquire next image";
	private static final String FAILED_SUBMIT_GRAPHIC = "Failed to submit graphic command buffer";
	private static final String FAILED_SUBMIT_PRESENT = "Failed to submit present command buffer";

	/**
	 * This is just -1L, but it is nicer as a symbolic constant.
	 */
	protected static final long UINT64_MAX = 0xFFFFFFFFFFFFFFFFL;

	private final int[] nextImageArray = new int[1];

	public GraphicProcessAdapter(GraphicProcess process)
	{
		super(process);
	}

	@Override
	protected ProcessContext createContext()
	{
		return new GraphicContext(getQueueType(), isResetAllowed(), descriptorPool,
				(GraphicProcess) process);
	}

	@Override
	public void recordCommands()
	{
		var graphicContext = (GraphicContext) context;

		((GraphicCommandBuffers) context.commandBuffers).recordCommands(graphicContext);
	}

	@Override
	public void recordCommand(RenderCommandBuffer commandBuffer, ECommandStage stage)
	{
		var pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			int subpassCount = 1;
			int currentSubpass = 0;

			do
			{
				if (currentSubpass != 0)
				{
					vkCmdNextSubpass(commandBuffer.getVkCommandBuffer(),
							VK_SUBPASS_CONTENTS_INLINE);
				}

				for (IPipeline pipeline : pipelinePkg.getPipelines())
				{
					final IPipelineAdapter<RenderCommandBuffer> adapter = IPipelineAdapter
							.adapt(pipeline);

					int pipelineSubpass = 0;
					if (adapter instanceof IGraphicsPipelineAdapter)
					{
						var graphicsPipelineAdapter = (IGraphicsPipelineAdapter) adapter;
						pipelineSubpass = graphicsPipelineAdapter.getSubpass();
						if (subpassCount <= pipelineSubpass)
						{
							subpassCount = pipelineSubpass + 1;
						}
					}

					boolean recordOk = pipeline.isEnabled() && pipeline.getStage() == stage;

					if (recordOk && stage == ECommandStage.RENDER)
					{
						recordOk = pipelineSubpass == currentSubpass;
					}

					if (recordOk)
					{
						adapter.record(commandBuffer, VK_PIPELINE_BIND_POINT_GRAPHICS);
						adapter.setRecordNeeded(false);
					}
				}

				currentSubpass++;
			} while (stage == ECommandStage.RENDER && currentSubpass < subpassCount);
		}
	}

	@Override
	public void execute()
	{
		execute(null);
	}

	@Override
	public void execute(IFence fence)
	{
		final var graphicContext = (GraphicContext) context;
		final Integer imageIndex = acquireNextImage(graphicContext);

		if (imageIndex != null)
		{
			submitAndPresentImage(graphicContext, imageIndex, fence);
		}
		else
		{
			signalSubmitSemaphores(graphicContext);
		}
	}

	public Integer acquireNextImage(GraphicContext context)
	{
		long semaphore = context.imageAvailableSemaphore.presentSemaphore.getId();
		long swapChain = context.swapChainManager.getSwapChain();
		var device = context.getVkDevice();

		int res = vkAcquireNextImageKHR(device, swapChain, UINT64_MAX, semaphore, VK_NULL_HANDLE,
				nextImageArray);

		if (res == VK_ERROR_OUT_OF_DATE_KHR)
		{
			context.surfaceManager.setDirty(true);
		}
		else
		{
			Logger.check(res, FAILED_ACQUIRE_IMAGE, true);
		}

		if (res == VK_SUCCESS || res == VK_SUBOPTIMAL_KHR) return nextImageArray[0];
		else return null;
	}

	private void submitAndPresentImage(GraphicContext context, Integer imageIndex, IFence fence)
	{
		var graphicQueue = context.getQueue().vkQueue;
		var presentQueue = context.surfaceManager.getPresentQueue();
		var fenceId = fence != null ? fence.getId() : VK_NULL_HANDLE;
		var submission = context.frameSubmission;
		var submitInfo = submission.getSubmitInfo(imageIndex);
		var presentInfo = submission.getPresentInfo(imageIndex);

		Logger.check(vkQueueSubmit(graphicQueue, submitInfo, fenceId), FAILED_SUBMIT_GRAPHIC, true);

		Logger.check(vkQueuePresentKHR(presentQueue.vkQueue, presentInfo), FAILED_SUBMIT_PRESENT,
				true);
	}

	private void signalSubmitSemaphores(final GraphicContext graphicContext)
	{
		var submission = graphicContext.frameSubmission;

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			graphicContext.execute(stack, submission.signalEmitters, new ISingleTimeCommand()
			{
				@Override
				public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
				{}
			});
		}
	}

	@Override
	public VulkanQueue getQueue()
	{
		return context.getQueue();
	}

	@Override
	protected EQueueType getQueueType()
	{
		return EQueueType.Graphic;
	}

	public static GraphicProcessAdapter adapt(GraphicProcess object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, GraphicProcessAdapter.class);
	}
}
