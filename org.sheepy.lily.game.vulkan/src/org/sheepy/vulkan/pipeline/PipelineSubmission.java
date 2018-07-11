package org.sheepy.vulkan.pipeline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.vulkan.command.AbstractCommandBuffers;
import org.sheepy.vulkan.command.ICommandBuffer;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.SemaphoreManager;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.LogicalDevice;

public class PipelineSubmission implements ISignalEmitter, IAllocable
{
	protected AbstractCommandBuffers<?> commandBuffers;
	protected int waitStage;
	protected List<VkSemaphore> waitSemaphores;

	protected SemaphoreManager signalSemaphoreManager;

	protected List<SubmissionInfo> infos = new ArrayList<>();

	public PipelineSubmission(LogicalDevice logicalDevice, AbstractCommandBuffers<?> commandBuffers,
			Collection<ISignalEmitter> waitForEmitters, int waitStage)
	{
		this.commandBuffers = commandBuffers;
		this.waitStage = waitStage;
		waitSemaphores = new ArrayList<>();
		for (ISignalEmitter emitter : waitForEmitters)
		{
			VkSemaphore newSignalSemaphore = emitter.newSignalSemaphore();
			waitSemaphores.add(newSignalSemaphore);
			System.out.println("New Semaphore to wait : " + Long.toHexString(newSignalSemaphore.getId()));
		}
		
		signalSemaphoreManager = new SemaphoreManager(logicalDevice);
	}
	
	public void addEmitterToWaitFor(ISignalEmitter emitter)
	{
		VkSemaphore newSignalSemaphore = emitter.newSignalSemaphore();
		waitSemaphores.add(newSignalSemaphore);
		
		System.out.println("New Semaphore to wait : " + Long.toHexString(newSignalSemaphore.getId()));
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		signalSemaphoreManager.lock(true);
		for (int i = 0; i < commandBuffers.size(); i++)
		{
			ICommandBuffer commandBuffer = commandBuffers.get(i);
			infos.add(buildSumissionInfo(i, commandBuffer, waitStage, waitSemaphores,
					signalSemaphoreManager.getSemaphores()));
		}
	}

	protected SubmissionInfo buildSumissionInfo(int infoNumber,
			ICommandBuffer commandBuffer, int waitStage, 
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
		for (SubmissionInfo info : infos)
		{
			info.free();
		}

		signalSemaphoreManager.lock(false);
		signalSemaphoreManager.free();

		infos.clear();
	}

	@Override
	public VkSemaphore newSignalSemaphore()
	{
		return signalSemaphoreManager.newSemaphore();
	}

	public List<VkSemaphore> getWaitSemaphores()
	{
		return waitSemaphores;
	}

}
