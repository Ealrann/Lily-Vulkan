package org.sheepy.lily.vulkan.process.execution;

import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class SubmissionsBuilder<T extends ProcessContext>
{
	private final Collection<VkSemaphore> signalSemaphores;
	private final Deque<WaitData> waitSemaphores = new ArrayDeque<>();
	private final boolean useFence;

	public SubmissionsBuilder(Collection<WaitData> waitForSemaphores,
							  Collection<VkSemaphore> signalEmitters,
							  boolean useFence)
	{
		this.signalSemaphores = signalEmitters;
		this.useFence = useFence;
		waitSemaphores.addAll(waitForSemaphores);
	}

	public Submission buildSubmission(ICommandBuffer commandBuffer, ExecutionContext context)
	{
		return new Submission(commandBuffer.getVkCommandBuffer(), context, waitSemaphores, signalSemaphores, useFence);
	}
}
