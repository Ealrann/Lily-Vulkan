package org.sheepy.vulkan.process.graphic.pool;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.KHRSwapchain.VK_STRUCTURE_TYPE_PRESENT_INFO_KHR;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;
import java.util.List;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.sheepy.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.vulkan.common.execution.ICommandBuffer;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.process.graphic.swapchain.SwapChainManager;
import org.sheepy.vulkan.process.pool.SubmissionInfo;

public class FrameSubmissionInfo extends SubmissionInfo
{
	private LongBuffer bSwapChains;
	private IntBuffer bImageIndex;
	private VkPresentInfoKHR presentInfo;

	public FrameSubmissionInfo(	int imageIndex,
								SwapChainManager swapChain,
								ICommandBuffer commandBuffer,
								EPipelineStage waitStage,
								Collection<VkSemaphore> waitSemaphores,
								VkSemaphore waitPresentSemaphore)
	{
		super(commandBuffer, waitStage, waitSemaphores, List.of(waitPresentSemaphore));

		bSwapChains = memAllocLong(1);
		bSwapChains.put(swapChain.getSwapChain());
		bSwapChains.flip();

		bImageIndex = MemoryUtil.memAllocInt(1);
		bImageIndex.put(imageIndex);
		bImageIndex.flip();

		presentInfo = VkPresentInfoKHR.calloc();
		presentInfo.sType(VK_STRUCTURE_TYPE_PRESENT_INFO_KHR);
		presentInfo.pWaitSemaphores(bSignalSemaphores);
		presentInfo.swapchainCount(1);
		presentInfo.pSwapchains(bSwapChains);
		presentInfo.pImageIndices(bImageIndex);
		presentInfo.pResults(null); // Optional
	}

	@Override
	public void free()
	{
		memFree(bImageIndex);
		memFree(bSwapChains);

		presentInfo.free();

		super.free();
	}

	public VkPresentInfoKHR getPresentInfo()
	{
		return presentInfo;
	}
}
