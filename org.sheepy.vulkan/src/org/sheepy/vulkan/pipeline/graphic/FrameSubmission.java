package org.sheepy.vulkan.pipeline.graphic;

import java.util.Collection;

import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.sheepy.vulkan.command.ICommandBuffer;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.pipeline.PipelineSubmission;
import org.sheepy.vulkan.pipeline.SubmissionInfo;

public class FrameSubmission extends PipelineSubmission
{
	private SwapConfiguration configuration;

	public FrameSubmission(SwapConfiguration configuration,
			Collection<ISignalEmitter> waitForSignals)
	{
		super(configuration.logicalDevice, configuration.commandBuffers, waitForSignals,
				configuration.frameWaitStage);
		
		this.configuration = configuration;
	}

	@Override
	protected SubmissionInfo buildSumissionInfo(int infoNumber,
			ICommandBuffer commandBuffer,
			int waitStage,
			Collection<VkSemaphore> waitSemaphores,
			Collection<VkSemaphore> signalSemaphores)
	{
		return new FrameSubmissionInfo(infoNumber, configuration.swapChainManager, commandBuffer, waitStage,
				waitSemaphores, signalSemaphoreManager.getSemaphores());
	}

	public VkPresentInfoKHR getPresentInfo(int frameIndex)
	{
		return ((FrameSubmissionInfo) infos.get(frameIndex)).getPresentInfo();
	}
}
