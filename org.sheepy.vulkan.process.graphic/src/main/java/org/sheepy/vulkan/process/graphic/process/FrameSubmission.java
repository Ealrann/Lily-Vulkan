package org.sheepy.vulkan.process.graphic.process;

import java.util.Collection;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.sheepy.vulkan.common.concurrent.ISignalEmitter;
import org.sheepy.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.vulkan.common.execution.ICommandBuffer;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.process.process.ProcessSubmission;
import org.sheepy.vulkan.process.process.SubmissionInfo;

public class FrameSubmission extends ProcessSubmission
{
	private final GraphicContext context;

	private final VkSemaphore presentWaitSemaphore;

	public FrameSubmission(	GraphicContext context,
							Collection<ISignalEmitter> waitForSignals)
	{
		super(context.logicalDevice, context.commandBuffers, waitForSignals,
				context.configuration.getAcquireWaitStage());

		this.context = context;
		this.presentWaitSemaphore = new VkSemaphore();
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		presentWaitSemaphore.allocate(context.logicalDevice);
		super.allocate(stack);
	}

	@Override
	protected SubmissionInfo buildSubmissionInfo(	int infoNumber,
													ICommandBuffer commandBuffer,
													EPipelineStage waitStage,
													Collection<VkSemaphore> waitSemaphores,
													Collection<VkSemaphore> signalSemaphores)
	{
		return new FrameSubmissionInfo(infoNumber, context.swapChainManager,
				commandBuffer, waitStage, waitSemaphores, presentWaitSemaphore);
	}

	public VkPresentInfoKHR getPresentInfo(int frameIndex)
	{
		return ((FrameSubmissionInfo) infos.get(frameIndex)).getPresentInfo();
	}

	@Override
	public void free()
	{
		super.free();
		presentWaitSemaphore.free(context.logicalDevice);
	};
}
