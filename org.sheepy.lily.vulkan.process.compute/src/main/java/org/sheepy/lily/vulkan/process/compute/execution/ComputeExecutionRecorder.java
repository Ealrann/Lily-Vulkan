package org.sheepy.lily.vulkan.process.compute.execution;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.common.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.common.process.IComputeContext;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.Submission;

public class ComputeExecutionRecorder extends AbstractExecutionRecorder<IComputeContext>
{
	public ComputeExecutionRecorder(ComputeCommandBuffer commandBuffer,
									Submission<? super IComputeContext> submission,
									int index)
	{
		super(commandBuffer, submission, index);
	}

	@Override
	protected void recordCommand(IComputeContext context, RecordContext recordContext)
	{
		record((ComputeProcess) context.getProcess(), recordContext);
	}

	private static void record(ComputeProcess process, RecordContext recordContext)
	{
		final var pipelinePkg = process.getPipelinePkg();
		if (pipelinePkg != null)
		{
			final EList<IPipeline> pipelines = pipelinePkg.getPipelines();
			for (int i = 0; i < pipelines.size(); i++)
			{
				final var pipeline = pipelines.get(i);
				record(recordContext, pipeline);
			}
		}
	}
}
