package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.sheepy.lily.vulkan.api.execution.IRecordable;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.graphic.pipeline.AbstractGraphicsPipelineAdapter;

public class GraphicExecutionRecorder extends AbstractExecutionRecorder
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
				boolean recordOk = adapter.shouldRecord(stage);

				int pipelineSubpass = 0;
				if (stage == ECommandStage.RENDER
						&& adapter instanceof AbstractGraphicsPipelineAdapter)
				{
					final var graphicsPipelineAdapter = (AbstractGraphicsPipelineAdapter) adapter;
					pipelineSubpass = graphicsPipelineAdapter.getSubpass();
					if (subpassCount <= pipelineSubpass)
					{
						subpassCount = pipelineSubpass + 1;
					}

					recordOk &= pipelineSubpass == currentSubpass;
				}

				if (recordOk)
				{
					adapter.record(vkCommandBuffer, VK_PIPELINE_BIND_POINT_GRAPHICS, index);
					adapter.setRecordNeeded(false);
				}
			}

			currentSubpass++;
		} while (currentSubpass < subpassCount);
	}
}
