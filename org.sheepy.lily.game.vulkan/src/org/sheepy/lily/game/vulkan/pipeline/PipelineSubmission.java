package org.sheepy.lily.game.vulkan.pipeline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.game.vulkan.command.AbstractCommandBuffers;
import org.sheepy.lily.game.vulkan.command.ICommandBuffer;
import org.sheepy.lily.game.vulkan.concurrent.ISignalEmitter;
import org.sheepy.lily.game.vulkan.concurrent.SemaphoreManager;
import org.sheepy.lily.game.vulkan.concurrent.VkSemaphore;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class PipelineSubmission implements ISignalEmitter
{
	protected SemaphoreManager signalSemaphoreManager;
	protected List<VkSemaphore> waitSemaphores;
	protected int waitStage;
	

	protected List<SubmissionInfo> infos = new ArrayList<>();

	public PipelineSubmission(LogicalDevice logicalDevice, 
			Collection<ISignalEmitter> waitForEmitters, int waitStage)
	{
		signalSemaphoreManager = new SemaphoreManager(logicalDevice);
		this.waitStage = waitStage;
		
		waitSemaphores = new ArrayList<>();
		for (ISignalEmitter emiter : waitForEmitters)
		{
			waitSemaphores.add(emiter.newSignalSemaphore());
		}
	}

	public void load(AbstractCommandBuffers<?> commandBuffers)
	{
		// At least one semaphore is needed
		if(signalSemaphoreManager.getSemaphores().isEmpty())
			signalSemaphoreManager.newSemaphore();
			
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

}
