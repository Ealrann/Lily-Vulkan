package org.sheepy.lily.vulkan.process.execution.util;

import org.lwjgl.PointerBuffer;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.process.execution.WaitData;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_SUBMIT_INFO;
import static org.lwjgl.vulkan.VK10.vkQueueSubmit;

public final class Submission
{
	private final VkSubmitInfo submitInfo;
	private final PointerBuffer pCommandBuffers;

	private final LongBuffer bWaitSemaphores;
	private final IntBuffer waitStages;
	private final LongBuffer bSignalSemaphores;

	public Submission(VkCommandBuffer commandBuffer,
					  Collection<WaitData> waitSemaphores,
					  Collection<VkSemaphore> signalSemaphores)
	{
		if (waitSemaphores.isEmpty() == false)
		{
			bWaitSemaphores = memAllocLong(waitSemaphores.size());
			waitStages = memAllocInt(waitSemaphores.size());
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

		pCommandBuffers = memAllocPointer(1);
		pCommandBuffers.put(commandBuffer);
		pCommandBuffers.flip();

		bSignalSemaphores = memAllocLong(signalSemaphores.size());
		for (var signalSemaphore : signalSemaphores)
		{
			bSignalSemaphores.put(signalSemaphore.getPtr());
		}
		bSignalSemaphores.flip();

		submitInfo = VkSubmitInfo.calloc();
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.waitSemaphoreCount(waitSemaphores.size());
		submitInfo.pWaitSemaphores(bWaitSemaphores);
		submitInfo.pWaitDstStageMask(waitStages);
		submitInfo.pCommandBuffers(pCommandBuffers);
		submitInfo.pSignalSemaphores(bSignalSemaphores);
	}

	public void free()
	{
		memFree(pCommandBuffers);

		if (waitStages != null) memFree(waitStages);

		memFree(bSignalSemaphores);
		if (bWaitSemaphores != null) memFree(bWaitSemaphores);

		submitInfo.free();
	}

	public int submit(VkQueue queue, long fencePtr)
	{
		return vkQueueSubmit(queue, submitInfo, fencePtr);
	}
}
