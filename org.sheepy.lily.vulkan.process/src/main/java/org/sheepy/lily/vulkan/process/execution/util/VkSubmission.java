package org.sheepy.lily.vulkan.process.execution.util;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.process.execution.WaitData;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;
import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_SUBMIT_INFO;
import static org.lwjgl.vulkan.VK10.vkQueueSubmit;

public final class VkSubmission
{
	private final VkSubmitInfo submitInfo;

	public VkSubmission(MemoryStack stack,
						List<VkCommandBuffer> commandBuffers,
						Collection<WaitData> waitSemaphores,
						Collection<VkSemaphore> signalSemaphores)
	{
		final LongBuffer bWaitSemaphores;
		final IntBuffer waitStages;
		if (waitSemaphores.isEmpty() == false)
		{
			bWaitSemaphores = stack.mallocLong(waitSemaphores.size());
			waitStages = stack.mallocInt(waitSemaphores.size());
			for (final WaitData waitData : waitSemaphores)
			{
				bWaitSemaphores.put(waitData.semaphore().getPtr());
				waitStages.put(waitData.waitStage().getValue());
			}
			bWaitSemaphores.flip();
			waitStages.flip();
		}
		else
		{
			bWaitSemaphores = null;
			waitStages = null;
		}

		final PointerBuffer pCommandBuffers = stack.mallocPointer(commandBuffers.size());
		for(final var commandBuffer : commandBuffers)
		{
			pCommandBuffers.put(commandBuffer);
		}
		pCommandBuffers.flip();

		final LongBuffer bSignalSemaphores = stack.mallocLong(signalSemaphores.size());
		for (var signalSemaphore : signalSemaphores)
		{
			bSignalSemaphores.put(signalSemaphore.getPtr());
		}
		bSignalSemaphores.flip();

		submitInfo = VkSubmitInfo.calloc(stack);
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.waitSemaphoreCount(waitSemaphores.size());
		submitInfo.pWaitSemaphores(bWaitSemaphores);
		submitInfo.pWaitDstStageMask(waitStages);
		submitInfo.pCommandBuffers(pCommandBuffers);
		submitInfo.pSignalSemaphores(bSignalSemaphores);
	}

	public int submit(VkQueue queue, long fencePtr)
	{
		return vkQueueSubmit(queue, submitInfo, fencePtr);
	}
}
