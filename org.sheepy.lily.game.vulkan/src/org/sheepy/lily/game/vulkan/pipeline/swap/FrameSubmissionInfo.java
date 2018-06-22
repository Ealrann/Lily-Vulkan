package org.sheepy.lily.game.vulkan.pipeline.swap;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.KHRSwapchain.VK_STRUCTURE_TYPE_PRESENT_INFO_KHR;
import static org.lwjgl.vulkan.VK10.VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_SUBMIT_INFO;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.game.vulkan.command.graphic.RenderCommandBuffer;
import org.sheepy.lily.game.vulkan.concurrent.VkSemaphore;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;

public class FrameSubmissionInfo
{
	private int imageIndex;
	private SwapChainManager swapChain;
	private RenderCommandBuffer commandBuffer;
	private Collection<VkSemaphore> waitSemaphores;
	private Collection<VkSemaphore> signalSemaphores;

	private VkSubmitInfo submitInfo;
	private VkPresentInfoKHR presentInfo;
	private LongBuffer bWaitSemaphores;
	private IntBuffer waitStages;
	private PointerBuffer pCommandBuffers;
	private LongBuffer bSignalSemaphores;
	private IntBuffer bImageIndex;
	private LongBuffer bSwapChains;

	public FrameSubmissionInfo(int imageIndex, SwapChainManager swapChain,
			RenderCommandBuffer commandBuffer, Collection<VkSemaphore> waitSemaphores,
			Collection<VkSemaphore> signalSemaphores)
	{
		this.imageIndex = imageIndex;
		this.swapChain = swapChain;
		this.commandBuffer = commandBuffer;
		this.waitSemaphores = waitSemaphores;
		this.signalSemaphores = signalSemaphores;

		load();
	}

	private void load()
	{
		bWaitSemaphores = MemoryUtil.memAllocLong(waitSemaphores.size());
		for (VkSemaphore waitSemaphore : waitSemaphores)
		{
			bWaitSemaphores.put(waitSemaphore.getId());
		}
		bWaitSemaphores.flip();
		waitStages = MemoryUtil.memAllocInt(1);
		waitStages.put(VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT);
		waitStages.flip();

		pCommandBuffers = memAllocPointer(1);
		pCommandBuffers.put(commandBuffer.getVkCommandBuffer());
		pCommandBuffers.flip();

		bSignalSemaphores = MemoryUtil.memAllocLong(signalSemaphores.size());
		for (VkSemaphore signalSemaphore : signalSemaphores)
		{
			bSignalSemaphores.put(signalSemaphore.getId());
		}
		bSignalSemaphores.flip();

		submitInfo = VkSubmitInfo.calloc();
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.waitSemaphoreCount(1);
		submitInfo.pWaitSemaphores(bWaitSemaphores);
		submitInfo.pWaitDstStageMask(waitStages);
		submitInfo.pCommandBuffers(pCommandBuffers);
		submitInfo.pSignalSemaphores(bSignalSemaphores);

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

	public void free()
	{
		memFree(bImageIndex);
		memFree(bSwapChains);
		memFree(pCommandBuffers);
		memFree(waitStages);
		memFree(bSignalSemaphores);
		memFree(bWaitSemaphores);

		submitInfo.free();
		presentInfo.free();
	}

	public VkSubmitInfo getSubmitInfo()
	{
		return submitInfo;
	}

	public VkPresentInfoKHR getPresentInfo()
	{
		return presentInfo;
	}

}
