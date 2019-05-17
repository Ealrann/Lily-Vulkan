package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.sheepy.lily.vulkan.api.execution.IRecordable;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
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
	protected void recordCommand(List<? extends IRecordable> adapters, ECommandStage stage)
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
				final IRecordable adapter = adapters.get(i);
				int pipelineSubpass = 0;

				if (stage == ECommandStage.RENDER && adapter instanceof GraphicsPipelineAdapter)
				{
					final var graphicsPipelineAdapter = (GraphicsPipelineAdapter) adapter;
					pipelineSubpass = graphicsPipelineAdapter.getSubpass();
					if (subpassCount <= pipelineSubpass)
					{
						subpassCount = pipelineSubpass + 1;
					}
				}

				if (adapter.isActive())
				{
					final boolean shouldRecord = adapter.shouldRecord(stage);
					final boolean goodSubpass = pipelineSubpass == currentSubpass;

					if (shouldRecord && goodSubpass)
					{
						final var context = new RecordContext(vkCommandBuffer, stage,
								VK_PIPELINE_BIND_POINT_GRAPHICS, index);
						adapter.record(context);
					}
				}
			}

			currentSubpass++;
		} while (currentSubpass < subpassCount);
	}
}
