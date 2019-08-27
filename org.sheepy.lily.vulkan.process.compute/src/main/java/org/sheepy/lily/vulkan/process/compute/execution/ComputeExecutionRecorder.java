package org.sheepy.lily.vulkan.process.compute.execution;

import java.util.List;

import org.sheepy.lily.vulkan.api.execution.IRecordable;
import org.sheepy.lily.vulkan.api.process.IComputeContext;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public class ComputeExecutionRecorder extends AbstractExecutionRecorder<IComputeContext>
{
	public ComputeExecutionRecorder(ComputeCommandBuffer commandBuffer,
									Submission<? super IComputeContext> submission,
									int index)
	{
		super(commandBuffer, submission, index);
	}

	@Override
	protected void recordCommand(List<? extends IRecordable> recordables, ECommandStage stage)
	{
		for (int i = 0; i < recordables.size(); i++)
		{
			final var pipelineAdapter = recordables.get(i);
			record(pipelineAdapter, stage);
		}
	}
}
