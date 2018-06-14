package org.sheepy.lily.game.vulkan.pipeline.swap;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.game.vulkan.command.graphic.GraphicCommandBuffers;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;
import org.sheepy.lily.game.vulkan.util.VkSemaphore;

public class FrameSubmission
{
	private List<FrameSumissionInfo> infos = null;

	public void load(int frameCount,
			SwapChainManager swapChain,
			GraphicCommandBuffers commandBuffers,
			VkSemaphore imageAvailableSemaphore,
			VkSemaphore renderFinishedSemaphore)
	{
		infos = new ArrayList<>();
		for (int i = 0; i < frameCount; i++)
		{
			infos.add(new FrameSumissionInfo(i, swapChain, commandBuffers.get(i),
					imageAvailableSemaphore, renderFinishedSemaphore));
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
		for (FrameSumissionInfo info : infos)
		{
			info.free();
		}
		infos = null;
	}
}
