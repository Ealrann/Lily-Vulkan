package org.sheepy.lily.vulkan.process.graphic.execution;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.IGraphicExecutionRecorders;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorders;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.vulkan.concurrent.VkSemaphore;

public class GraphicExecutionRecorders extends ExecutionRecorders<IGraphicContext>
		implements IGraphicExecutionRecorders
{
	public final VkSemaphore imageAvailableSemaphore;

	public GraphicExecutionRecorders()
	{
		imageAvailableSemaphore = new VkSemaphore();
	}

	@Override
	public List<GraphicExecutionRecorder> createRecorders(	MemoryStack stack,
															IGraphicContext context)
	{
		final List<GraphicExecutionRecorder> res = new ArrayList<>();

		final var process = context.getGraphicProcess();
		final int executionCount = context.getSwapChainManager().getImageCount();

		imageAvailableSemaphore.allocate(stack, context);

		final var waitForEmitters = gatherWaitDatas(process);
		final var signals = gatherSinalSemaphores(process);
		final var submissionsBuilder = new FrameSubmissionsBuilder(waitForEmitters, signals);

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
	public boolean isAllocationDirty(IGraphicContext context)
	{
		return context.getSwapChainManager().isAllocationDirty(context)
				|| super.isAllocationDirty(context);
	}

	@Override
	public void free(IGraphicContext context)
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
		return new WaitData(imageAvailableSemaphore, acquireWaitStage);
	}

	@Override
	public VkSemaphore getAcquireSemaphore()
	{
		return imageAvailableSemaphore;
	}
}
