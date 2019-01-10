package org.sheepy.vulkan.process.graphic.process;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.KHRSwapchain.VK_STRUCTURE_TYPE_PRESENT_INFO_KHR;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.sheepy.vulkan.common.execution.ICommandBuffer;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.process.graphic.swapchain.SwapChainManager;
import org.sheepy.vulkan.process.process.SubmissionInfo;

public class FrameSubmissionInfo extends SubmissionInfo
{
	private final LongBuffer bSwapChains;
	private final IntBuffer bImageIndex;
	private final VkPresentInfoKHR presentInfo;

	public FrameSubmissionInfo(	int imageIndex,
								SwapChainManager swapChain,
								ICommandBuffer commandBuffer,
								EPipelineStage waitStage,
								Collection<Long> waitSemaphores,
								Collection<Long> signalSemaphores,
								Collection<Long> presentWaitSemaphores)
	{
		super(commandBuffer, waitStage, waitSemaphores, signalSemaphores);

		bSwapChains = memAllocLong(1);
		bSwapChains.put(swapChain.getSwapChain());
		bSwapChains.flip();

		bImageIndex = MemoryUtil.memAllocInt(1);
		bImageIndex.put(imageIndex);
		bImageIndex.flip();

		LongBuffer bPresentWaitSemaphores = MemoryUtil.memAllocLong(presentWaitSemaphores.size());
		for (Long signalSemaphore : presentWaitSemaphores)
		{
			bPresentWaitSemaphores.put(signalSemaphore);
		}
		bPresentWaitSemaphores.flip();

		presentInfo = VkPresentInfoKHR.calloc();
		presentInfo.sType(VK_STRUCTURE_TYPE_PRESENT_INFO_KHR);
		presentInfo.pWaitSemaphores(bPresentWaitSemaphores);
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
