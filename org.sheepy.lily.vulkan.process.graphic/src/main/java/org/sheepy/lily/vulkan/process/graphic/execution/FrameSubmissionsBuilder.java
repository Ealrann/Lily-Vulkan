package org.sheepy.lily.vulkan.process.graphic.execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sheepy.lily.vulkan.api.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.api.nativehelper.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.lily.vulkan.process.execution.SubmissionsBuilder;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

public class FrameSubmissionsBuilder extends SubmissionsBuilder
{
	private final GraphicContext context;

	public FrameSubmissionsBuilder(	GraphicContext context,
									Collection<WaitData> waitForSignals,
									Collection<VkSemaphore> signals)
	{
		super(waitForSignals, signals, true);

		this.context = context;
	}

	@Override
	protected Submission buildSubmissionInfo(	int infoNumber,
												ICommandBuffer commandBuffer,
												Collection<WaitData> waitSemaphores,
												Collection<Long> signalSemaphores)
	{
		final List<Long> signals = new ArrayList<>();
		signals.addAll(signalSemaphores);

		return new FrameSubmission(infoNumber, context.swapChainManager, commandBuffer,
				waitSemaphores, signals, useFence);
	}
}
