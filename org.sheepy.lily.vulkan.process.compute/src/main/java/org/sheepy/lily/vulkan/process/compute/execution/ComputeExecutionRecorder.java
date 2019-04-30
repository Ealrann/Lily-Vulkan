package org.sheepy.lily.vulkan.process.compute.execution;

import static org.lwjgl.vulkan.VK10.VK_PIPELINE_BIND_POINT_COMPUTE;

import java.util.List;

import org.sheepy.lily.vulkan.api.execution.IRecordable;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class ComputeExecutionRecorder extends AbstractExecutionRecorder
{
	public ComputeExecutionRecorder(ComputeCommandBuffer commandBuffer,
									Submission submission,
									int index)
	{
		super(commandBuffer, submission, index);
	}

	@Override
	protected void recordCommand(List<? extends IRecordable> recordables, ECommandStage stage)
	{
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
		for (int i = 0; i < recordables.size(); i++)
		{
			final var pipelineAdapter = recordables.get(i);
			if (pipelineAdapter.shouldRecord(stage))
			{
				pipelineAdapter.record(stage, vkCommandBuffer, VK_PIPELINE_BIND_POINT_COMPUTE,
						index);
			}
			pipelineAdapter.setRecordNeeded(false);
		}
	}
}
