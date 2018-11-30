package org.sheepy.vulkan.process.pool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.concurrent.ISignalEmitter;
import org.sheepy.vulkan.common.concurrent.SemaphoreManager;
import org.sheepy.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.execution.ICommandBuffer;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.process.execution.AbstractCommandBuffers;

public class ProcessSubmission implements ISignalEmitter, IBasicAllocable
{
	protected AbstractCommandBuffers<?> commandBuffers;
	protected EPipelineStage waitStage;
	protected List<VkSemaphore> waitSemaphores;

	protected SemaphoreManager signalSemaphoreManager;

	protected List<SubmissionInfo> infos = new ArrayList<>();

	public ProcessSubmission(	LogicalDevice logicalDevice,
								AbstractCommandBuffers<?> commandBuffers,
								Collection<ISignalEmitter> waitForEmitters,
								EPipelineStage waitStage)
	{
		this.commandBuffers = commandBuffers;
		this.waitStage = waitStage;
		waitSemaphores = new ArrayList<>();
		for (final ISignalEmitter emitter : waitForEmitters)
		{
			final VkSemaphore newSignalSemaphore = emitter.newSignalSemaphore(logicalDevice);
			waitSemaphores.add(newSignalSemaphore);
			// System.out.println("New Semaphore to wait : " +
			// Long.toHexString(newSignalSemaphore.getId()));
		}

		signalSemaphoreManager = new SemaphoreManager(logicalDevice);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		signalSemaphoreManager.lock(true);
		for (int i = 0; i < commandBuffers.size(); i++)
		{
			final ICommandBuffer commandBuffer = commandBuffers.get(i);
			infos.add(buildSubmissionInfo(i, commandBuffer, waitStage, waitSemaphores,
					signalSemaphoreManager.getSemaphores()));
		}
	}

	protected SubmissionInfo buildSubmissionInfo(	int infoNumber,
													ICommandBuffer commandBuffer,
													EPipelineStage waitStage,
													Collection<VkSemaphore> waitSemaphores,
													Collection<VkSemaphore> signalSemaphores)
	{
		return new SubmissionInfo(commandBuffer, waitStage, waitSemaphores,
				signalSemaphoreManager.getSemaphores());
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

		signalSemaphoreManager.lock(false);
		signalSemaphoreManager.free();

		infos.clear();
	}

	@Override
	public VkSemaphore newSignalSemaphore(LogicalDevice logicalDevice)
	{
		return signalSemaphoreManager.newSemaphore();
	}

	public List<VkSemaphore> getWaitSemaphores()
	{
		return waitSemaphores;
	}

	@Override
	public boolean isAllocationDirty()
	{
		return commandBuffers.isAllocationDirty();
	}
}
