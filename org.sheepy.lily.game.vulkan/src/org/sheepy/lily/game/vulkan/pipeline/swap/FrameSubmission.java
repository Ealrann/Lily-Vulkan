package org.sheepy.lily.game.vulkan.pipeline.swap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.game.vulkan.command.graphic.GraphicCommandBuffers;
import org.sheepy.lily.game.vulkan.concurrent.ISignalEmitter;
import org.sheepy.lily.game.vulkan.concurrent.SemaphoreManager;
import org.sheepy.lily.game.vulkan.concurrent.VkSemaphore;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;

public class FrameSubmission implements ISignalEmitter
{
	private List<FrameSubmissionInfo> infos = null;

	private SemaphoreManager signalSemaphoreManager;

	public FrameSubmission(LogicalDevice logicalDevice)
	{
		signalSemaphoreManager = new SemaphoreManager(logicalDevice);
	}

	@Override
	public VkSemaphore newSignalSemaphore()
	{
		return signalSemaphoreManager.newSemaphore();
	}

	public void load(int frameCount,
			SwapChainManager swapChain,
			GraphicCommandBuffers commandBuffers,
			Collection<ISignalEmitter> waitForEmitters)
	{
		infos = new ArrayList<>();

		List<VkSemaphore> waitSemaphores = new ArrayList<>();
		for (ISignalEmitter emiter : waitForEmitters)
		{
			waitSemaphores.add(emiter.newSignalSemaphore());
		}

		for (int i = 0; i < frameCount; i++)
		{
			infos.add(new FrameSubmissionInfo(i, swapChain, commandBuffers.get(i), waitSemaphores,
					signalSemaphoreManager.getSemaphores()));
		}
	}

	public VkSubmitInfo getSubmitInfo(int frameIndex)
	{
		return infos.get(frameIndex).getSubmitInfo();
	}

	public VkPresentInfoKHR getPresentInfo(int frameIndex)
	{
		return infos.get(frameIndex).getPresentInfo();
	}

	public void free()
	{
		for (FrameSubmissionInfo info : infos)
		{
			info.free();
		}
		
		signalSemaphoreManager.free();
		
		infos = null;
	}
}
