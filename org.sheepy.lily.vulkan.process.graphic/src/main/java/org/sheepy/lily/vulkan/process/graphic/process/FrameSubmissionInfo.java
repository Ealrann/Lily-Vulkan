package org.sheepy.lily.vulkan.process.graphic.process;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.KHRSwapchain.VK_STRUCTURE_TYPE_PRESENT_INFO_KHR;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.sheepy.lily.vulkan.common.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainManager;
import org.sheepy.lily.vulkan.process.process.SubmissionInfo;
import org.sheepy.lily.vulkan.process.process.WaitData;

public class FrameSubmissionInfo extends SubmissionInfo
{
	private LongBuffer bSwapChains;
	private IntBuffer bImageIndex;
	private VkPresentInfoKHR presentInfo;
	private LongBuffer bPresentWaitSemaphores;

	public FrameSubmissionInfo(	int imageIndex,
								SwapChainManager swapChain,
								ICommandBuffer commandBuffer,
								Collection<WaitData> waitSemaphores,
								Collection<Long> signalSemaphores,
								Collection<Long> presentWaitSemaphores)
	{
		super(commandBuffer, waitSemaphores, signalSemaphores);

		bSwapChains = memAllocLong(1);
		bSwapChains.put(swapChain.getSwapChain());
		bSwapChains.flip();

		bImageIndex = memAllocInt(1);
		bImageIndex.put(imageIndex);
		bImageIndex.flip();

		bPresentWaitSemaphores = MemoryUtil.memAllocLong(presentWaitSemaphores.size());
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
		memFree(bPresentWaitSemaphores);

		bImageIndex = null;
		bSwapChains = null;
		bPresentWaitSemaphores = null;

		presentInfo.free();
		presentInfo = null;

		super.free();
	}

	public VkPresentInfoKHR getPresentInfo()
	{
		return presentInfo;
	}
}
