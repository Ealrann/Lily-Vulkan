package org.sheepy.lily.vulkan.process.graphic.execution;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.IGraphicExecutionRecorders;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorders;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.vulkan.concurrent.VkSemaphore;

public final class GraphicExecutionRecorders extends ExecutionRecorders<IGraphicContext>
		implements IGraphicExecutionRecorders
{
	public final VkSemaphore imageAvailableSemaphore;

	public GraphicExecutionRecorders()
	{
		imageAvailableSemaphore = new VkSemaphore();
	}

	@Override
	public void configureAllocation(IAllocationConfiguration config, IGraphicContext context)
	{
		config.addChildren(List.of(imageAvailableSemaphore));
		config.addDependencies(List.of(context.getSwapChainManager()));
		super.configureAllocation(config, context);
	}

	@Override
	public List<GraphicExecutionRecorder> createRecorders(IGraphicContext context)
	{
		final List<GraphicExecutionRecorder> res = new ArrayList<>();

		final var process = context.getGraphicProcess();
		final int executionCount = context.getSwapChainManager().getImageCount();

		final var waitForEmitters = gatherWaitDatas(process);
		final var signals = gatherSinalSemaphores(process);
		final var submissionsBuilder = new FrameSubmissionsBuilder(waitForEmitters, signals);

		for (int i = 0; i < executionCount; i++)
		{
			res.add(createRecorder(submissionsBuilder, i));
		}

		return res;
	}

	private static GraphicExecutionRecorder createRecorder(	final FrameSubmissionsBuilder submissionsBuilder,
															int index)
	{
		final var commandBuffer = new GraphicCommandBuffer(index);
		final var submission = (FrameSubmission) submissionsBuilder.buildSubmission(commandBuffer,
				index);

		return new GraphicExecutionRecorder(commandBuffer, submission, index);
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
