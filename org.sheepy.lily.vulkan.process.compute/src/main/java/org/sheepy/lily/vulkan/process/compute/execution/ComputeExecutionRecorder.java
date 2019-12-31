package org.sheepy.lily.vulkan.process.compute.execution;

import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.api.process.IComputeContext;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;

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
			for (final var pipeline : pipelinePkg.getPipelines())
			{
				final var adapter = pipeline.adapt(IPipelineAdapter.class);
				adapter.record(recordContext);
			}
		}
	}

}
