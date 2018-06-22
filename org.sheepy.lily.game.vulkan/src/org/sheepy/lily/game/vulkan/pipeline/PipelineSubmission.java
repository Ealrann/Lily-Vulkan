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
import org.sheepy.lily.game.vulkan.pipeline.swap.FrameSubmissionInfo;

public class PipelineSubmission implements ISignalEmitter
{
	protected SemaphoreManager signalSemaphoreManager;

	protected List<SubmissionInfo> infos = new ArrayList<>();

	public PipelineSubmission(LogicalDevice logicalDevice)
	{
		signalSemaphoreManager = new SemaphoreManager(logicalDevice);
	}

	public void load(AbstractCommandBuffers<?> commandBuffers,
			Collection<ISignalEmitter> waitForEmitters)
	{
		List<VkSemaphore> waitSemaphores = new ArrayList<>();
		for (ISignalEmitter emiter : waitForEmitters)
		{
			waitSemaphores.add(emiter.newSignalSemaphore());
		}

		for (int i = 0; i < commandBuffers.size(); i++)
		{
			ICommandBuffer commandBuffer = commandBuffers.get(i);
			infos.add((FrameSubmissionInfo) buildSumissionInfo(i, commandBuffer,
					waitSemaphores, signalSemaphoreManager.getSemaphores()));
		}
	}

	protected SubmissionInfo buildSumissionInfo(int infoNumber,
			ICommandBuffer commandBuffer,
			Collection<VkSemaphore> waitSemaphores,
			Collection<VkSemaphore> signalSemaphores)
	{
		return new SubmissionInfo(commandBuffer, waitSemaphores,
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

		signalSemaphoreManager.free();

		infos.clear();
	}

	@Override
	public VkSemaphore newSignalSemaphore()
	{
		return signalSemaphoreManager.newSemaphore();
	}

}
