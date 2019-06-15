package org.sheepy.lily.vulkan.process.execution;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

import org.sheepy.lily.vulkan.api.process.IProcessContext.IRecorderContext;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.execution.ICommandBuffer;

public class SubmissionsBuilder<T extends IRecorderContext<T>>
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

	public Submission<T> buildSubmission(ICommandBuffer<? super T> commandBuffer, int index)
	{
		fillSemaphoreDeque(signalEmitters, signalSemaphores);

		return buildSubmissionInfo(index, commandBuffer, waitSemaphores, signalSemaphores);
	}

	private static void fillSemaphoreDeque(	Collection<VkSemaphore> emitters,
											Deque<Long> semaphoreDeque)
	{
		for (final VkSemaphore emitter : emitters)
		{
			final long newSignalSemaphore = emitter.getPtr();
			semaphoreDeque.add(newSignalSemaphore);
		}
	}

	protected Submission<T> buildSubmissionInfo(int infoNumber,
												ICommandBuffer<? super T> commandBuffer,
												Collection<WaitData> waitSemaphores,
												Collection<Long> signalSemaphores)
	{
		return new Submission<T>(commandBuffer, waitSemaphores, signalSemaphores, useFence);
	}
}
