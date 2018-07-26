package org.sheepy.vulkan.pipeline.graphic;

import java.util.Collection;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.sheepy.vulkan.command.ICommandBuffer;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.pipeline.PipelineSubmission;
import org.sheepy.vulkan.pipeline.SubmissionInfo;

public class FrameSubmission extends PipelineSubmission
{
	private GraphicContext context;

	private VkSemaphore presentWaitSemaphore;

	public FrameSubmission(GraphicContext context, Collection<ISignalEmitter> waitForSignals)
	{
		super(context.logicalDevice, context.commandBuffers, waitForSignals,
				context.configuration.frameWaitStage);

		this.context = context;
		this.presentWaitSemaphore = new VkSemaphore(context.logicalDevice);
	}
	
	@Override
	public void allocate(MemoryStack stack)
	{
		presentWaitSemaphore.allocate(stack);
		super.allocate(stack);
	}

	@Override
	protected SubmissionInfo buildSubmissionInfo(int infoNumber,
			ICommandBuffer commandBuffer,
			int waitStage,
			Collection<VkSemaphore> waitSemaphores,
			Collection<VkSemaphore> signalSemaphores)
	{
		return new FrameSubmissionInfo(infoNumber, context.swapChainManager, commandBuffer,
				waitStage, waitSemaphores, presentWaitSemaphore);
	}

	public VkPresentInfoKHR getPresentInfo(int frameIndex)
	{
		return ((FrameSubmissionInfo) infos.get(frameIndex)).getPresentInfo();
	}
	
	@Override
	public void free() {
		super.free();
		presentWaitSemaphore.free();
	};
}
