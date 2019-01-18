package org.sheepy.vulkan.process.process;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.vulkan.common.execution.ICommandBuffer;
import org.sheepy.vulkan.process.execution.AbstractCommandBuffers;

public class ProcessSubmission implements IBasicAllocable
{
	protected final AbstractCommandBuffers<?> commandBuffers;
	private final Collection<VkSemaphore> signalEmitters;
	private final Deque<WaitData> waitSemaphores = new ArrayDeque<>();
	private final Deque<Long> signalSemaphores = new ArrayDeque<>();

	protected List<SubmissionInfo> submitInfos = new ArrayList<>();

	public ProcessSubmission(	AbstractCommandBuffers<?> commandBuffers,
								Collection<WaitData> waitForSemaphores,
								Collection<VkSemaphore> signalEmitters)
	{
		this.commandBuffers = commandBuffers;
		this.signalEmitters = signalEmitters;

		waitSemaphores.addAll(waitForSemaphores);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		fillSemaphoreDeque(signalEmitters, signalSemaphores);

		for (int i = 0; i < commandBuffers.size(); i++)
		{
			final ICommandBuffer commandBuffer = commandBuffers.get(i);
			submitInfos
					.add(buildSubmissionInfo(i, commandBuffer, waitSemaphores, signalSemaphores));
		}
	}

	private static void fillSemaphoreDeque(	Collection<VkSemaphore> emitters,
											Deque<Long> semaphoreDeque)
	{
		for (final VkSemaphore emitter : emitters)
		{
			long newSignalSemaphore = emitter.getId();
			semaphoreDeque.add(newSignalSemaphore);
			// System.out.println("New Semaphore to wait : " +
			// Long.toHexString(newSignalSemaphore.getId()));
		}
	}

	@SuppressWarnings("static-method")
	protected SubmissionInfo buildSubmissionInfo(	int infoNumber,
													ICommandBuffer commandBuffer,
													Collection<WaitData> waitSemaphores,
													Collection<Long> signalSemaphores)
	{
		return new SubmissionInfo(commandBuffer, waitSemaphores, signalSemaphores);
	}

	public VkSubmitInfo getSubmitInfo(int index)
	{
		return submitInfos.get(index).getSubmitInfo();
	}

	@Override
	public void free()
	{
		for (final SubmissionInfo info : submitInfos)
		{
			info.free();
		}

		signalSemaphores.clear();

		submitInfos.clear();
	}

	@Override
	public boolean isAllocationDirty()
	{
		return commandBuffers.isAllocationDirty();
	}
}
