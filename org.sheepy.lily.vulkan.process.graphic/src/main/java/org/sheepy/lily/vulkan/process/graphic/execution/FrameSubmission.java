package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.KHRSwapchain.*;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.api.nativehelper.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainManager;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

public class FrameSubmission extends Submission
{
	private static final String FAILED_SUBMIT_PRESENT = "Failed to submit present command buffer";

	private final int imageIndex;
	private final SwapChainManager swapChain;

	private final VkSemaphore presentWaitSemaphore;

	private LongBuffer bSwapChains;
	private IntBuffer bImageIndex;
	private VkPresentInfoKHR presentInfo;
	private LongBuffer bPresentWaitSemaphores;
	private VkQueue presentQueue;

	public FrameSubmission(	int imageIndex,
							SwapChainManager swapChain,
							ICommandBuffer commandBuffer,
							Collection<WaitData> waitSemaphores,
							Collection<Long> signalSemaphores)
	{
		super(commandBuffer, waitSemaphores, signalSemaphores);

		presentWaitSemaphore = new VkSemaphore();

		this.imageIndex = imageIndex;
		this.swapChain = swapChain;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		presentQueue = graphicContext.surfaceManager.getPresentQueue().vkQueue;

		presentWaitSemaphore.allocate(stack, context);
		final long presentSemaphoreId = presentWaitSemaphore.getId();
		signalSemaphores.add(presentSemaphoreId);

		super.allocate(stack, context);

		bSwapChains = memAllocLong(1);
		bSwapChains.put(swapChain.getSwapChain());
		bSwapChains.flip();

		bImageIndex = memAllocInt(1);
		bImageIndex.put(imageIndex);
		bImageIndex.flip();

		bPresentWaitSemaphores = MemoryUtil.memAllocLong(1);
		bPresentWaitSemaphores.put(presentSemaphoreId);
		bPresentWaitSemaphores.flip();

		presentInfo = VkPresentInfoKHR.calloc();
		presentInfo.sType(VK_STRUCTURE_TYPE_PRESENT_INFO_KHR);
		presentInfo.pWaitSemaphores(bPresentWaitSemaphores);
		presentInfo.swapchainCount(1);
		presentInfo.pSwapchains(bSwapChains);
		presentInfo.pImageIndices(bImageIndex);
		presentInfo.pResults(null);
	}

	@Override
	public void free(IAllocationContext context)
	{
		presentInfo.free();
		presentInfo = null;

		memFree(bImageIndex);
		memFree(bSwapChains);
		memFree(bPresentWaitSemaphores);

		presentWaitSemaphore.free(context);

		bImageIndex = null;
		bSwapChains = null;
		bPresentWaitSemaphores = null;

		super.free(context);
	}

	@Override
	public void submit()
	{
		super.submit();

		Logger.check(vkQueuePresentKHR(presentQueue, presentInfo), FAILED_SUBMIT_PRESENT, true);
	}

	public VkPresentInfoKHR getPresentInfo()
	{
		return presentInfo;
	}
}
