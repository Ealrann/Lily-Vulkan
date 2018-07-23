package org.sheepy.vulkan.pipeline.graphic;

import static org.lwjgl.system.MemoryUtil.memAllocLong;
import static org.lwjgl.system.MemoryUtil.memFree;
import static org.lwjgl.vulkan.KHRSwapchain.VK_STRUCTURE_TYPE_PRESENT_INFO_KHR;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.sheepy.vulkan.command.ICommandBuffer;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.pipeline.SubmissionInfo;
import org.sheepy.vulkan.swapchain.SwapChainManager;

public class FrameSubmissionInfo extends SubmissionInfo
{
	private LongBuffer bSwapChains;
	private IntBuffer bImageIndex;
	private VkPresentInfoKHR presentInfo;

	public FrameSubmissionInfo(int imageIndex, SwapChainManager swapChain,
			ICommandBuffer commandBuffer, int waitStage, Collection<VkSemaphore> waitSemaphores,
			Collection<VkSemaphore> signalSemaphores)
	{
		super(commandBuffer, waitStage, waitSemaphores, signalSemaphores);

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
