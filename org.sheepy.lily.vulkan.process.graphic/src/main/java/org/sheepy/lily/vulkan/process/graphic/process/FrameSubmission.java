package org.sheepy.lily.vulkan.process.graphic.process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPresentInfoKHR;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.common.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.process.process.ProcessSubmission;
import org.sheepy.lily.vulkan.process.process.SubmissionInfo;
import org.sheepy.lily.vulkan.process.process.WaitData;

public class FrameSubmission extends ProcessSubmission
{
	private final GraphicContext context;

	private VkSemaphore presentWaitSemaphore;

	public FrameSubmission(	GraphicContext context,
							Collection<WaitData> waitForSignals,
							Collection<VkSemaphore> signals)
	{
		super(waitForSignals, signals);

		this.context = context;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		presentWaitSemaphore = new VkSemaphore();
		presentWaitSemaphore.allocate(stack, context);
		super.allocate(stack, context);
	}

	@Override
	protected SubmissionInfo buildSubmissionInfo(	int infoNumber,
													ICommandBuffer commandBuffer,
													Collection<WaitData> waitSemaphores,
													Collection<Long> signalSemaphores)
	{
		List<Long> signals = new ArrayList<>();
		signals.addAll(signalSemaphores);
		signals.add(presentWaitSemaphore.getId());

		return new FrameSubmissionInfo(infoNumber, context.swapChainManager, commandBuffer,
				waitSemaphores, signals, List.of(presentWaitSemaphore.getId()));
	}

	public VkPresentInfoKHR getPresentInfo(int frameIndex)
	{
		return ((FrameSubmissionInfo) submitInfos.get(frameIndex)).getPresentInfo();
	}

	@Override
	public void free(IAllocationContext context)
	{
		super.free(context);
		presentWaitSemaphore.free(context);
		presentWaitSemaphore = null;
	};
}
