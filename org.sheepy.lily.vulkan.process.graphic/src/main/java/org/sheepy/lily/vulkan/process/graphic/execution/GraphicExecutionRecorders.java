package org.sheepy.lily.vulkan.process.graphic.execution;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorders;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.lily.vulkan.process.graphic.process.PresentSemaphore;

public class GraphicExecutionRecorders extends ExecutionRecorders
{
	public final PresentSemaphore imageAvailableSemaphore;

	public GraphicExecutionRecorders()
	{
		imageAvailableSemaphore = new PresentSemaphore();
	}

	@Override
	public List<IExecutionRecorder> createRecorders(MemoryStack stack, IAllocationContext context)
	{
		final List<IExecutionRecorder> res = new ArrayList<>();

		final var graphicContext = (GraphicContext) context;
		final var process = graphicContext.process;
		final int executionCount = graphicContext.swapChainManager.getImageCount();

		imageAvailableSemaphore.allocate(stack, context);

		final var waitForEmitters = gatherWaitDatas(process);
		final var signals = gatherSinalSemaphores(process);
		final var submissionsBuilder = new FrameSubmissionsBuilder(graphicContext, waitForEmitters,
				signals);

		for (int i = 0; i < executionCount; i++)
		{
			final var commandBuffer = new GraphicCommandBuffer(i);

			final var submission = (FrameSubmission) submissionsBuilder
					.buildSubmission(commandBuffer, i);

			final var recorder = new GraphicExecutionRecorder(commandBuffer, submission, i);
			res.add(recorder);
		}

		return res;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		final var graphicContext = (GraphicContext) context;
		return graphicContext.swapChainManager.isAllocationDirty(context)
				|| super.isAllocationDirty(context);
	}

	@Override
	public void free(IAllocationContext context)
	{
		super.free(context);
		imageAvailableSemaphore.free(context);
	}

	@Override
	protected List<WaitData> gatherWaitDatas(AbstractProcess process)
	{
		final var res = super.gatherWaitDatas(process);
		res.add(0, createAcquireSemaphoreData((GraphicProcess) process));
		return res;
	}

	private WaitData createAcquireSemaphoreData(GraphicProcess process)
	{
		final var acquireWaitStage = process.getConfiguration().getAcquireWaitStage();
		return new WaitData(imageAvailableSemaphore.presentSemaphore, acquireWaitStage);
	}
}
