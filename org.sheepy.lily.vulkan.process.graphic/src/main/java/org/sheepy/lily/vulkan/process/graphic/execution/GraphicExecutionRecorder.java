package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.execution.IRecordable;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class GraphicExecutionRecorder extends AbstractExecutionRecorder<IGraphicContext>
{
	private final PresentSubmission presentSubmission;
	private final VkSemaphore presentSemaphore;

	public GraphicExecutionRecorder(GraphicCommandBuffer commandBuffer,
									Submission<IGraphicContext> submission,
									PresentSubmission presentSubmission,
									VkSemaphore presentSemaphore,
									int index)
	{
		super(commandBuffer, submission, index);
		this.presentSubmission = presentSubmission;
		this.presentSemaphore = presentSemaphore;
	}

	@Override
	public final void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		config.addChildren(List.of(presentSemaphore));
		super.configureAllocation(config, context);
		config.addChildren(List.of(presentSubmission));
	}

	@Override
	protected void recordCommand(	List<? extends IRecordable> adapters,
									RecordContext context,
									ECommandStage stage)
	{
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
		int subpassCount = 1;
		int currentSubpass = 0;

		do
		{
			if (stage == ECommandStage.RENDER && currentSubpass != 0)
			{
				vkCmdNextSubpass(vkCommandBuffer, VK_SUBPASS_CONTENTS_INLINE);
			}

			for (int i = 0; i < adapters.size(); i++)
			{
				final var recordable = adapters.get(i);
				int pipelineSubpass = 0;

				if (stage == ECommandStage.RENDER && recordable instanceof GraphicsPipelineAdapter)
				{
					final var graphicsPipelineAdapter = (GraphicsPipelineAdapter) recordable;
					pipelineSubpass = graphicsPipelineAdapter.getSubpass();
					if (subpassCount <= pipelineSubpass)
					{
						subpassCount = pipelineSubpass + 1;
					}
				}

				if (pipelineSubpass == currentSubpass)
				{
					recordable.record(context, stage);
				}
			}

			currentSubpass++;
		} while (currentSubpass < subpassCount);
	}

	@Override
	public IFenceView play()
	{
		final var res = super.play();
		presentSubmission.submit();
		return res;
	}
}
