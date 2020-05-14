package org.sheepy.lily.vulkan.process.compute.execution;

import org.sheepy.lily.vulkan.core.execution.IRecordable;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.process.execution.AbstractExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.Submission;

import java.util.List;

public class ComputeExecutionRecorder extends AbstractExecutionRecorder
{
	public ComputeExecutionRecorder(ComputeCommandBuffer commandBuffer, Submission submission, int index)
	{
		super(commandBuffer, submission, index);
	}

	@Override
	protected void recordCommand(final List<IRecordable> pipelines, final RecordContext recordContext)
	{
		for (final var pipeline : pipelines)
		{
			pipeline.record(recordContext);
		}
	}
}
