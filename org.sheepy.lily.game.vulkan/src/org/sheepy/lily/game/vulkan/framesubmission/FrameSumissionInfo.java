package org.sheepy.lily.game.vulkan.framesubmission;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.KHRSwapchain.VK_STRUCTURE_TYPE_PRESENT_INFO_KHR;
import static org.lwjgl.vulkan.VK10.VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_SUBMIT_INFO;

import java.nio.IntBuffer;
import java.nio.LongBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.game.vulkan.command.graphic.RenderCommandBuffer;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;
import org.sheepy.lily.game.vulkan.util.VkSemaphore;

public class FrameSumissionInfo
{
	private int imageIndex;
	private SwapChainManager swapChain;
	private RenderCommandBuffer commandBuffer;
	private VkSemaphore imageAvailableSemaphore;
	private VkSemaphore renderFinishedSemaphore;

	private VkSubmitInfo submitInfo;
	private VkPresentInfoKHR presentInfo;
	private LongBuffer waitSemaphores;
	private IntBuffer waitStages;
	private PointerBuffer pCommandBuffers;
	private LongBuffer signalSemaphores;
	private IntBuffer bImageIndex;
	private LongBuffer bSwapChains;

	public FrameSumissionInfo(int imageIndex, SwapChainManager swapChain,
			RenderCommandBuffer commandBuffer, VkSemaphore imageAvailableSemaphore,
			VkSemaphore renderFinishedSemaphore)
	{
		this.imageIndex = imageIndex;
		this.swapChain = swapChain;
		this.commandBuffer = commandBuffer;
		this.imageAvailableSemaphore = imageAvailableSemaphore;
		this.renderFinishedSemaphore = renderFinishedSemaphore;
		
		load();
	}

	private void load()
	{
		waitSemaphores = MemoryUtil.memAllocLong(1);
		waitSemaphores.put(imageAvailableSemaphore.getId());
		waitSemaphores.flip();
		waitStages = MemoryUtil.memAllocInt(1);
		waitStages.put(VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT);
		waitStages.flip();

		pCommandBuffers = memAllocPointer(1);
		pCommandBuffers.put(commandBuffer.getVkCommandBuffer());
		pCommandBuffers.flip();

		signalSemaphores = MemoryUtil.memAllocLong(1);
		signalSemaphores.put(renderFinishedSemaphore.getId());
		signalSemaphores.flip();

		submitInfo = VkSubmitInfo.calloc();
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.waitSemaphoreCount(1);
		submitInfo.pWaitSemaphores(waitSemaphores);
		submitInfo.pWaitDstStageMask(waitStages);
		submitInfo.pCommandBuffers(pCommandBuffers);
		submitInfo.pSignalSemaphores(signalSemaphores);

		bSwapChains = memAllocLong(1);
		bSwapChains.put(swapChain.getSwapChain());
		bSwapChains.flip();
		
		bImageIndex = MemoryUtil.memAllocInt(1);
		bImageIndex.put(imageIndex);
		bImageIndex.flip();

		presentInfo = VkPresentInfoKHR.calloc();
		presentInfo.sType(VK_STRUCTURE_TYPE_PRESENT_INFO_KHR);
		presentInfo.pWaitSemaphores(signalSemaphores);
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
		memFree(signalSemaphores);
		memFree(waitSemaphores);
		
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
