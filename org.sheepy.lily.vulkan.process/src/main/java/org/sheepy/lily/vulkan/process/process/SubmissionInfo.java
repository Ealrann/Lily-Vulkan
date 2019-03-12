package org.sheepy.lily.vulkan.process.process;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_SUBMIT_INFO;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;

import org.lwjgl.PointerBuffer;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.vulkan.common.execution.ICommandBuffer;
public class SubmissionInfo
{
	protected VkSubmitInfo submitInfo;
	protected LongBuffer bWaitSemaphores;
	protected IntBuffer waitStages;
	protected PointerBuffer pCommandBuffers;
	protected LongBuffer bSignalSemaphores;

	public SubmissionInfo(	ICommandBuffer commandBuffer,
							Collection<WaitData> waitSemaphores,
							Collection<Long> signalSemaphores)
	{
		if (waitSemaphores.isEmpty() == false)
		{
			bWaitSemaphores = memAllocLong(waitSemaphores.size());
			waitStages = memAllocInt(waitSemaphores.size());
			for (WaitData waitData : waitSemaphores)
			{
				bWaitSemaphores.put(waitData.semaphore.getId());
				waitStages.put(waitData.waitStage.getValue());
			}
			bWaitSemaphores.flip();
			waitStages.flip();
		}

		pCommandBuffers = memAllocPointer(1);
		pCommandBuffers.put(commandBuffer.getVkCommandBuffer());
		pCommandBuffers.flip();

		bSignalSemaphores = memAllocLong(signalSemaphores.size());
		for (Long signalSemaphore : signalSemaphores)
		{
			bSignalSemaphores.put(signalSemaphore);
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

	public VkSubmitInfo getSubmitInfo()
	{
		return submitInfo;
	}
}
