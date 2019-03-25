package org.sheepy.lily.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.execution.ISingleTimeCommand;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicCommandBuffers;
import org.sheepy.lily.vulkan.process.graphic.pipeline.IGraphicsPipelineAdapter;
import org.sheepy.lily.vulkan.process.graphic.present.GraphicPresenter;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@Statefull
@Adapter(scope = GraphicProcess.class)
public class GraphicProcessAdapter extends AbstractProcessAdapter
{

	private GraphicPresenter presenter;

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
		final var graphicContext = (GraphicContext) context;

		final int presentCount = graphicContext.swapChainManager.getSwapChainImages().size();
		presenter = new GraphicPresenter(graphicContext, presentCount);

		((GraphicCommandBuffers) context.commandBuffers).recordCommands(graphicContext);
	}

	@Override
	public void recordCommand(VkCommandBuffer commandBuffer, ECommandStage stage, int index)
	{
		int subpassCount = 1;
		int currentSubpass = 0;

		do
		{
			if (stage == ECommandStage.RENDER && currentSubpass != 0)
			{
				vkCmdNextSubpass(commandBuffer, VK_SUBPASS_CONTENTS_INLINE);
			}

			for (int i = 0; i < pipelineAdapters.size(); i++)
			{
				final IPipelineAdapter adapter = pipelineAdapters.get(i);
				boolean recordOk = adapter.shouldRecord(stage);

				int pipelineSubpass = 0;
				if (stage == ECommandStage.RENDER && adapter instanceof IGraphicsPipelineAdapter)
				{
					final var graphicsPipelineAdapter = (IGraphicsPipelineAdapter) adapter;
					pipelineSubpass = graphicsPipelineAdapter.getSubpass();
					if (subpassCount <= pipelineSubpass)
					{
						subpassCount = pipelineSubpass + 1;
					}

					recordOk &= pipelineSubpass == currentSubpass;
				}

				if (recordOk)
				{
					adapter.record(commandBuffer, VK_PIPELINE_BIND_POINT_GRAPHICS, index);
					adapter.setRecordNeeded(false);
				}
			}

			currentSubpass++;
		} while (currentSubpass < subpassCount);
	}

	@Override
	public void execute()
	{
		execute(null);
	}

	@Override
	public void execute(IFence fence)
	{
		prepare();

		final var graphicContext = (GraphicContext) context;

		if (presenter.acquireNextImage() == true)
		{
			presenter.submitAndPresentImage(fence);
		}
		else
		{
			signalSubmitSemaphores(graphicContext);
		}
	}

	private static void signalSubmitSemaphores(final GraphicContext graphicContext)
	{
		final var submission = graphicContext.frameSubmission;

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
		return IAdapterFactoryService.INSTANCE.adapt(object, GraphicProcessAdapter.class);
	}
}
