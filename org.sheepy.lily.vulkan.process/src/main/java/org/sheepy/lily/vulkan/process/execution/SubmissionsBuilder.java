package org.sheepy.lily.vulkan.process.execution;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.common.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

public class SubmissionsBuilder<T extends ProcessContext<T>>
{
	private final Collection<VkSemaphore> signalSemaphores;
	private final Deque<WaitData> waitSemaphores = new ArrayDeque<>();
	private final boolean useFence;

	public SubmissionsBuilder(	Collection<WaitData> waitForSemaphores,
								Collection<VkSemaphore> signalEmitters,
								boolean useFence)
	{
		this.signalSemaphores = signalEmitters;
		this.useFence = useFence;
		waitSemaphores.addAll(waitForSemaphores);
	}

	public Submission<T> buildSubmission(ICommandBuffer<? super T> commandBuffer)
	{
		return new Submission<T>(commandBuffer, waitSemaphores, signalSemaphores, useFence);
	}
}
