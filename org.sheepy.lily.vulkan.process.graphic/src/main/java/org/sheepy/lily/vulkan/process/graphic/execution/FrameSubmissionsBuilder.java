package org.sheepy.lily.vulkan.process.graphic.execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.process.execution.SubmissionsBuilder;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.execution.ICommandBuffer;

public class FrameSubmissionsBuilder extends SubmissionsBuilder<IGraphicContext>
{
	public FrameSubmissionsBuilder(	Collection<WaitData> waitForSignals,
									Collection<VkSemaphore> signals)
	{
		super(waitForSignals, signals, true);
	}

	@Override
	protected FrameSubmission buildSubmissionInfo(	int infoNumber,
													ICommandBuffer<? super IGraphicContext> commandBuffer,
													Collection<WaitData> waitSemaphores,
													Collection<Long> signalSemaphores)
	{
		final List<Long> signals = new ArrayList<>();
		signals.addAll(signalSemaphores);

		return new FrameSubmission(infoNumber, commandBuffer, waitSemaphores, signals, useFence);
	}
}
