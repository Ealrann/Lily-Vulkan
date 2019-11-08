package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.vulkan.execution.IRecordable;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class GraphicExecutionRecorder extends AbstractExecutionRecorder<IGraphicContext>
{
	public GraphicExecutionRecorder(GraphicCommandBuffer commandBuffer,
									FrameSubmission frameSubmission,
									int index)
	{
		super(commandBuffer, frameSubmission, index);
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
}
