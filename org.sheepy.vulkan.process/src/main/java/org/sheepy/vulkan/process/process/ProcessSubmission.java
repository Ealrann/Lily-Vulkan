package org.sheepy.vulkan.process.process;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.vulkan.api.concurrent.ISignalEmitter;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.execution.ICommandBuffer;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.process.execution.AbstractCommandBuffers;

public class ProcessSubmission implements IBasicAllocable
{
	protected AbstractCommandBuffers<?> commandBuffers;
	protected EPipelineStage waitStage;

	protected List<SubmissionInfo> infos = new ArrayList<>();
	private final Collection<ISignalEmitter> signalEmitters;
	private final Deque<Long> waitSemaphores = new ArrayDeque<>();
	private final Deque<Long> signalSemaphores = new ArrayDeque<>();

	public ProcessSubmission(	AbstractCommandBuffers<?> commandBuffers,
								Collection<Long> waitForSemaphores,
								Collection<ISignalEmitter> signalEmitters,
								EPipelineStage waitStage)
	{
		this.commandBuffers = commandBuffers;
		this.signalEmitters = signalEmitters;
		this.waitStage = waitStage;

		waitSemaphores.addAll(waitForSemaphores);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		fillSemaphoreDeque(signalEmitters, signalSemaphores);

		for (int i = 0; i < commandBuffers.size(); i++)
		{
			final ICommandBuffer commandBuffer = commandBuffers.get(i);
			infos.add(buildSubmissionInfo(i, commandBuffer, waitStage, waitSemaphores,
					signalSemaphores));
		}
	}

	private static void fillSemaphoreDeque(	Collection<ISignalEmitter> emitters,
											Deque<Long> semaphoreDeque)
	{
		for (final ISignalEmitter emitter : emitters)
		{
			if (emitter.hasSemaphore())
			{
				long newSignalSemaphore = emitter.getSignalSemaphore();
				semaphoreDeque.add(newSignalSemaphore);
				// System.out.println("New Semaphore to wait : " +
				// Long.toHexString(newSignalSemaphore.getId()));
			}
		}
	}

	@SuppressWarnings("static-method")
	protected SubmissionInfo buildSubmissionInfo(	int infoNumber,
													ICommandBuffer commandBuffer,
													EPipelineStage waitStage,
													Collection<Long> waitSemaphores,
													Collection<Long> signalSemaphores)
	{
		return new SubmissionInfo(commandBuffer, waitStage, waitSemaphores, signalSemaphores);
	}

	public VkSubmitInfo getSubmitInfo(int index)
	{
		return infos.get(index).getSubmitInfo();
	}

	@Override
	public void free()
	{
		for (final SubmissionInfo info : infos)
		{
			info.free();
		}

		signalSemaphores.clear();

		infos.clear();
	}

	@Override
	public boolean isAllocationDirty()
	{
		return commandBuffers.isAllocationDirty();
	}
}
