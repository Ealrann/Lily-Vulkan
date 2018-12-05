package org.sheepy.vulkan.process.process;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_SUBMIT_INFO;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.vulkan.common.execution.ICommandBuffer;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public class SubmissionInfo
{
	protected VkSubmitInfo submitInfo;
	protected LongBuffer bWaitSemaphores;
	protected IntBuffer waitStages;
	protected PointerBuffer pCommandBuffers;
	protected LongBuffer bSignalSemaphores;

	public SubmissionInfo(	ICommandBuffer commandBuffer,
							EPipelineStage waitStage,
							Collection<VkSemaphore> waitSemaphores,
							Collection<VkSemaphore> signalSemaphores)
	{
		if (waitSemaphores.isEmpty() == false)
		{
			bWaitSemaphores = MemoryUtil.memAllocLong(waitSemaphores.size());
			waitStages = MemoryUtil.memAllocInt(waitSemaphores.size());
			for (VkSemaphore waitSemaphore : waitSemaphores)
			{
				bWaitSemaphores.put(waitSemaphore.getId());
				waitStages.put(waitStage.getValue());
			}
			bWaitSemaphores.flip();
			waitStages.flip();
		}

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
