package org.sheepy.vulkan.pipeline.swap;

import java.util.Collection;

import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.sheepy.vulkan.command.AbstractCommandBuffers;
import org.sheepy.vulkan.command.ICommandBuffer;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.PipelineSubmission;
import org.sheepy.vulkan.pipeline.SubmissionInfo;
import org.sheepy.vulkan.swapchain.SwapChainManager;

public class FrameSubmission extends PipelineSubmission
{
	private SwapChainManager swapChain;

	public FrameSubmission(LogicalDevice logicalDevice, AbstractCommandBuffers<?> commandBuffers, SwapChainManager swapChain, Collection<ISignalEmitter> waitForSignals, int waitStage)
	{
		super(logicalDevice, commandBuffers, waitForSignals, waitStage);

		this.swapChain = swapChain;
	}

	@Override
	protected SubmissionInfo buildSumissionInfo(int infoNumber,
			ICommandBuffer commandBuffer,
			int waitStage,
			Collection<VkSemaphore> waitSemaphores,
			Collection<VkSemaphore> signalSemaphores)
	{
		return new FrameSubmissionInfo(infoNumber, swapChain, commandBuffer, waitStage,
				waitSemaphores, signalSemaphoreManager.getSemaphores());
	}

	public VkPresentInfoKHR getPresentInfo(int frameIndex)
	{
		return ((FrameSubmissionInfo) infos.get(frameIndex)).getPresentInfo();
	}
}
