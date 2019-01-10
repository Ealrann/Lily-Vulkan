package org.sheepy.vulkan.process.graphic.process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.sheepy.vulkan.api.concurrent.ISignalEmitter;
import org.sheepy.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.vulkan.common.execution.ICommandBuffer;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.process.process.ProcessSubmission;
import org.sheepy.vulkan.process.process.SubmissionInfo;

public class FrameSubmission extends ProcessSubmission
{
	private final GraphicContext context;

	private VkSemaphore presentWaitSemaphore;

	public FrameSubmission(	GraphicContext context,
							Collection<Long> waitForSignals,
							Collection<ISignalEmitter> signals)
	{
		super(context.commandBuffers, waitForSignals, signals,
				context.configuration.getAcquireWaitStage());

		this.context = context;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		presentWaitSemaphore = new VkSemaphore();
		presentWaitSemaphore.allocate(context.logicalDevice);
		super.allocate(stack);
	}

	@Override
	protected SubmissionInfo buildSubmissionInfo(	int infoNumber,
													ICommandBuffer commandBuffer,
													EPipelineStage waitStage,
													Collection<Long> waitSemaphores,
													Collection<Long> signalSemaphores)
	{
		List<Long> signals = new ArrayList<>();
		signals.addAll(signalSemaphores);
		signals.add(presentWaitSemaphore.getId());

		return new FrameSubmissionInfo(infoNumber, context.swapChainManager, commandBuffer,
				waitStage, waitSemaphores, signals, List.of(presentWaitSemaphore.getId()));
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
		presentWaitSemaphore = null;
	};
}
