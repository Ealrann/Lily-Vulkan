package org.sheepy.lily.vulkan.process.graphic.execution;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;
import java.util.List;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.execution.ICommandBuffer;
import org.sheepy.vulkan.log.EVulkanErrorStatus;
import org.sheepy.vulkan.log.Logger;

public class FrameSubmission extends Submission<IGraphicContext>
{
	private static final String FAILED_SUBMIT_PRESENT = "Failed to submit present command buffer";

	private final int imageIndex;

	private final VkSemaphore presentWaitSemaphore;

	private LongBuffer bSwapChains;
	private IntBuffer bImageIndex;
	private VkPresentInfoKHR presentInfo;
	private LongBuffer bPresentWaitSemaphores;
	private VkQueue presentQueue;

	private IGraphicContext context;

	public FrameSubmission(	int imageIndex,
							ICommandBuffer<? super IGraphicContext> commandBuffer,
							Collection<WaitData> waitSemaphores,
							Collection<Long> signalSemaphores,
							boolean useFence)
	{
		super(commandBuffer, waitSemaphores, signalSemaphores, useFence);

		presentWaitSemaphore = new VkSemaphore();

		this.imageIndex = imageIndex;
	}

	@Override
	public void configureAllocation(IAllocationConfiguration config, IGraphicContext context)
	{
		super.configureAllocation(config, context);
		config.addDependencies(List.of(context.getSwapChainManager()));
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		final var swapChain = context.getSwapChainManager();
		this.context = context;

		presentQueue = context.getSurfaceManager().getPresentQueue().vkQueue;

		presentWaitSemaphore.allocate(context);
		final long presentSemaphorePtr = presentWaitSemaphore.getPtr();
		signalSemaphores.add(presentSemaphorePtr);

		super.allocate(context);

		bSwapChains = memAllocLong(1);
		bSwapChains.put(swapChain.getAddress());
		bSwapChains.flip();

		bImageIndex = memAllocInt(1);
		bImageIndex.put(imageIndex);
		bImageIndex.flip();

		bPresentWaitSemaphores = MemoryUtil.memAllocLong(1);
		bPresentWaitSemaphores.put(presentSemaphorePtr);
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
	public void free(IGraphicContext context)
	{
		presentWaitSemaphore.free(context);
		presentInfo.free();
		memFree(bImageIndex);
		memFree(bSwapChains);
		memFree(bPresentWaitSemaphores);

		presentInfo = null;
		bImageIndex = null;
		bSwapChains = null;
		bPresentWaitSemaphores = null;

		super.free(context);
	}

	@Override
	public IFenceView submit()
	{
		super.submit();

		final var res = vkQueuePresentKHR(presentQueue, presentInfo);

		Logger.check(res, FAILED_SUBMIT_PRESENT, true);

		if (res != VK_SUCCESS)
		{
			if (DebugUtil.DEBUG_ENABLED)
			{
				final var status = EVulkanErrorStatus.resolveFromCode(res);
				System.err.println("[Present] " + status.message);
			}
			presentWaitSemaphore.signalSemaphore(context);
		}

		return fence;
	}

	public VkPresentInfoKHR getPresentInfo()
	{
		return presentInfo;
	}
}
