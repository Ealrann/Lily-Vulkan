package org.sheepy.lily.vulkan.process.execution;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

import org.sheepy.lily.vulkan.api.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.api.nativehelper.concurrent.VkSemaphore;

public class SubmissionsBuilder
{
	public final Collection<VkSemaphore> signalEmitters;
	private final Deque<WaitData> waitSemaphores = new ArrayDeque<>();
	private final Deque<Long> signalSemaphores = new ArrayDeque<>();
	protected final boolean useFence;

	public SubmissionsBuilder(	Collection<WaitData> waitForSemaphores,
								Collection<VkSemaphore> signalEmitters,
								boolean useFence)
	{
		this.signalEmitters = signalEmitters;
		this.useFence = useFence;
		waitSemaphores.addAll(waitForSemaphores);
	}

	public Submission buildSubmission(ICommandBuffer commandBuffer, int index)
	{
		fillSemaphoreDeque(signalEmitters, signalSemaphores);

		return buildSubmissionInfo(index, commandBuffer, waitSemaphores, signalSemaphores);
	}

	private static void fillSemaphoreDeque(	Collection<VkSemaphore> emitters,
											Deque<Long> semaphoreDeque)
	{
		for (final VkSemaphore emitter : emitters)
		{
			final long newSignalSemaphore = emitter.getId();
			semaphoreDeque.add(newSignalSemaphore);
		}
	}

	protected Submission buildSubmissionInfo(	int infoNumber,
												ICommandBuffer commandBuffer,
												Collection<WaitData> waitSemaphores,
												Collection<Long> signalSemaphores)
	{
		return new Submission(commandBuffer, waitSemaphores, signalSemaphores, useFence);
	}
}
