package org.sheepy.lily.vulkan.process.graphic.execution;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.common.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.common.graphic.IGraphicExecutionRecorders;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorders;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.lily.vulkan.process.execution.WaitData;

public final class GraphicExecutionRecorders extends ExecutionRecorders<IGraphicContext>
		implements IGraphicExecutionRecorders
{
	private final VkSemaphore imageAvailableSemaphore;

	public GraphicExecutionRecorders()
	{
		imageAvailableSemaphore = new VkSemaphore();
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
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

		for (int i = 0; i < executionCount; i++)
		{
			res.add(createRecorder(process, waitForEmitters, signals, i));
		}

		return res;
	}

	private static GraphicExecutionRecorder createRecorder(	GraphicProcess process,
															List<WaitData> waitForEmitters,
															List<VkSemaphore> signals,
															int index)
	{
		final var commandBuffer = new GraphicCommandBuffer(index);
		final var presentSemaphore = new VkSemaphore();

		final var currentSignalSemaphores = new ArrayList<VkSemaphore>(signals.size() + 1);
		currentSignalSemaphores.addAll(signals);
		currentSignalSemaphores.add(presentSemaphore);

		final var submission = new Submission<IGraphicContext>(	commandBuffer,
																waitForEmitters,
																currentSignalSemaphores,
																true);
		final var presentSubmission = new PresentSubmission(index, presentSemaphore);

		return new GraphicExecutionRecorder(process,
											commandBuffer,
											submission,
											presentSubmission,
											presentSemaphore,
											index);
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
