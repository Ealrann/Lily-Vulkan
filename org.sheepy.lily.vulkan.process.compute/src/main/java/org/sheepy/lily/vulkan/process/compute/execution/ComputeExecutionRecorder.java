package org.sheepy.lily.vulkan.process.compute.execution;

import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.compute.process.ComputeContext;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.Submission;

public class ComputeExecutionRecorder extends AbstractExecutionRecorder<ComputeContext>
{
	public ComputeExecutionRecorder(ComputeCommandBuffer commandBuffer,
									Submission<? super ComputeContext> submission,
									int index)
	{
		super(commandBuffer, submission, index);
	}

	@Override
	protected void recordCommand(ComputeContext context, RecordContext recordContext)
	{
		record((ComputeProcess) context.getProcess(), recordContext);
	}

	private static void record(ComputeProcess process, RecordContext recordContext)
	{
		final var pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			final var pipelines = pipelinePkg.getPipelines();
			for (int i = 0; i < pipelines.size(); i++)
			{
				final var pipeline = pipelines.get(i);
				record(recordContext, pipeline);
			}
		}
	}
}
